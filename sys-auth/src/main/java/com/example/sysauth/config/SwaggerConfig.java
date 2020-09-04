package com.example.sysauth.config;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

/**
 * swagger配置
 *
 * @author xuk
 * @date 2018/6/29
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger2.enable}")
    private boolean swagger2Enable;


    @Bean(value = "权限管理")
    public Docket loginAPI() {
        return createDocket("权限管理API", "com.example.sysauth.controller.auth");
    }



    private Docket createDocket(String groupName, String basePackage) {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swagger2Enable)
                .apiInfo(apiInfo())
                //将时间类型全部转为String类型
                .directModelSubstitute(LocalDateTime.class, String.class)
                //将日期类型全部转为String类型
                .directModelSubstitute(LocalDate.class, String.class)
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(generateParameters());
    }

    private List<Parameter> generateParameters() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = Lists.newArrayList();
        parameterBuilder.name("token").description("token令牌").modelRef(new ModelRef("String"))
                .parameterType("header").defaultValue("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Imh1b21pbmciLCJwYXNzd29yZCI6IjEyMzQiLCJleHAiOjE1NDgyOTM2MDQsIm5iZiI6MTU0NzQyOTYwNH0.ACb1ZTUIJVDTLHIsbEunSpp1at8VywtCojDp9d7wUT4")
                .required(true).build();
        parameters.add(parameterBuilder.build());
        return parameters;
    }

   /* private Predicate<RequestHandler> predicate() {
        Predicate<RequestHandler> predicate = input -> {
            Class<?> declaringClass = null;
            if (input != null) {
                declaringClass = input.declaringClass();
            }
            // 被注解的类
            assert declaringClass != null;
            return declaringClass.isAnnotationPresent(Api.class);
        };
        return predicate;
    }*/

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("数美API文档")
                .description("数美API文档")
                .version("1.0")
                .build();
    }
}
