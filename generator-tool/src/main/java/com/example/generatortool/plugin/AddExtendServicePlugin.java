package com.example.generatortool.plugin;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.XmlConstants;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 生成扩展Dao文件，用于扩展Mapper的操作。
 * 每个表分别对应生成两个文件 xxxDao.java、xxxDao.xml。 该插件通过生成的xxxDao.java，继承了原来生成的xxxMapper.java文件，已经包含默认的sql操作，
 * 项目中可以直接使用xxxDao.java进行开发，无需对xxxMapper.java文件进行更改，而且原所有由mybatis generator生成的文件（包括model、mapper、example），每次生成都会被重新覆盖，
 * 不应该再修改这些文件，与数据库表建立了固定联系， 后续开发只需要集中于xxxDao.xml 和 xxxDao.xml 文件即可。
 * 总体开发步骤：数据库表添加或变更->运行Mybatis Generator生成->model、mapper、example文件重新覆盖更新，扩展文件已存在的不覆盖—>根据需要对扩展的xxxDao进行开发
 * <p>
 * <p>
 * 使用方法：
 * 在generatorConfig.xml中的Content内添加该插件 ，四个属性值必传，如：
 * <content ...>
 * <extend type="cn.aesop.extend.plugin.AddExtendDaoPlugin">
 * <property name="baseDir" value="${basedir}"/> POM所在目录
 * <property name="targetProject" value="src/main/java"/> 根包位置
 * <property name="targetProjectXml" value="src/main/resources"/> xml资源位置
 * <property name="targetPackage" value="cn.issuetracker.group.dao"/> 根包位置
 * </extend>
 * ...
 * </content>
 *
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/10/18 16:28
 */
public class AddExtendServicePlugin extends PluginAdapter {
    private String fileTitle = "《扩展Service操作，由Mybatis Generator插件自动生成，多次生成，不会覆盖》";
    private String targetPackage;
    private String targetProject;
    private String serviceBaseName;
    private String baseDir;
    private String author;

    @Override
    public boolean validate(List<String> list) {
        baseDir = properties.getProperty("baseDir");
        targetPackage = properties.getProperty("targetPackage");
        targetProject = properties.getProperty("targetProject");
        author = properties.getProperty("author");
        if (baseDir == null || baseDir.trim().isEmpty()
                || targetPackage == null || targetPackage.trim().isEmpty()
                || targetProject == null || targetProject.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 此方法在生成SqlMap文件时调用。
     *
     * @param sqlMap
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        return true;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {

        String introspectedTableName = introspectedTable.getFullyQualifiedTable().getIntrospectedTableName();
        String beanName = lineToHump(introspectedTableName);
        serviceBaseName = beanName+"Service";

        String targetPackagePath = targetPackage.replaceAll("\\.", "/");
        StringBuilder filePath = getPath(targetPackagePath, ".java");
        if (new File(filePath.toString()).exists()) {
            System.out.println(filePath + "文件存在，不生成");
            return null;
        }

        CompilationUnit unit = generateUnit(introspectedTable);
        // this.context.getProperty("javaFileEncoding")
        GeneratedJavaFile gf = new GeneratedJavaFile(unit, targetProject, "utf-8", this.context.getJavaFormatter());


        return Arrays.asList(gf);
    }


    @Override
    public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles(IntrospectedTable introspectedTable) {
        return null;
    }

    private void addResultElement(XmlElement resultMap, String ele, String actualColumnName, String jdbcTypeName, String javaProperty) {

    }

    private CompilationUnit generateUnit(IntrospectedTable introspectedTable) {
        //实体类类型
        String entityClazzType = introspectedTable.getBaseRecordType();
        // xxxMapper类类型
        String mapperInterfaceType = introspectedTable.getMyBatis3JavaMapperType();

        String domainObjectName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();

        StringBuilder builder = new StringBuilder();

        //集成mybatisplus   BaseMapper<实体类类型>
        FullyQualifiedJavaType superClassType = new FullyQualifiedJavaType(
                builder.append("IService<")
                        .append(entityClazzType)
                        .append(">").toString()
        );
        Interface dto = new Interface(targetPackage + "." + serviceBaseName);
        dto.addSuperInterface(superClassType);
        dto.setVisibility(JavaVisibility.PUBLIC);

        //导入xxxMapper类所在的包
        /*FullyQualifiedJavaType modelJavaType = new FullyQualifiedJavaType(mapperInterfaceType);
        dto.addImportedType(modelJavaType);*/

        FullyQualifiedJavaType modelJavaType = new FullyQualifiedJavaType("com.baomidou.mybatisplus.service.IService");
        FullyQualifiedJavaType beanPath = new FullyQualifiedJavaType(entityClazzType);
        dto.addImportedType(modelJavaType);
        dto.addImportedType(beanPath);

        //导入注解包、并添加@Mapper注解
        // FullyQualifiedJavaType importType = new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper");
        // dto.addImportedType(importType);
        // dto.addAnnotation("@Mapper");

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dto.addJavaDocLine("/**\n" +
                " * " + fileTitle + "\n" +
                " * \n" +
                " * @author " + author + "\n" +
                " * @date " + dateFormatter.format(new Date()) + "\n" +
                " */");

        return dto;
    }

    private StringBuilder getPath(String targetPackagePath, String type) {
        StringBuilder filePath = new StringBuilder();
        filePath.append(baseDir)
                .append(File.separator)
                .append(targetProject)
                .append(File.separator)
                .append(targetPackagePath)
                .append(File.separator)
                .append(serviceBaseName)
                .append(type);
        return filePath;
    }

    /**
     * 下划线转驼峰
     */
    public String lineToHump(String str) {
        str = str.toLowerCase();
        final StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("_(\\w)");
        Matcher m = p.matcher(str);
        while (m.find()){
            m.appendReplacement(sb,m.group(1).toUpperCase());
        }
        m.appendTail(sb);
        return upperCase(sb.toString());
    }

    /**
     * 首字母大写
     * @param str
     * @return
     */
    public String upperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
