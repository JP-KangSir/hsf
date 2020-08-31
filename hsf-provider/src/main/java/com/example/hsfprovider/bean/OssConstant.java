package com.example.hsfprovider.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "oss")
public class OssConstant {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;
}
