package com.example.hsfprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan(basePackages = "com.example.hsfprovider.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class HsfProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HsfProviderApplication.class, args);
    }

}
