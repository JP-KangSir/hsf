package com.example.hsfcommuncation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan(basePackages = "com.example.hsfcommuncation.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class HsfCommuncationApplication {

    public static void main(String[] args) {
        SpringApplication.run(HsfCommuncationApplication.class, args);
    }

}
