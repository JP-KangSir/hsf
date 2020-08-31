package com.example.hsfcommuncation.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.hsfcommuncation.bean.Template;
import com.example.hsfcommuncation.dao.TemplateDao;
import com.example.hsfcommuncation.service.TemplateService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateDao, Template> implements TemplateService {

    @Override
    public String getContent(String template,  Map<String,Object> datas) {
        String content = fillTemplet(template, datas);
        return content;
    }

    /**
     * 填充模板
     *
     * @param templet
     * @param params
     * @return
     */
    private static String fillTemplet(String templet, Map<String, Object> params) {
        String rgex = "\\{\\{[^}]*\\}\\}";
        Pattern pattern = Pattern.compile(rgex);
        Matcher matcher = pattern.matcher(templet);
        ;
        while (matcher.find()) {
            String keyWrapper = matcher.group();
            templet = templet.replaceFirst(keyWrapper.replace("{", "\\{").replace("}", "\\}"),
                    params.get(keyWrapper.substring(2, keyWrapper.length() - 2)) + "");
        }
        return templet;
    }
}
