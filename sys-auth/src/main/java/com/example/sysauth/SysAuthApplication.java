package com.example.sysauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.sysauth.dao")
public class SysAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysAuthApplication.class, args);
    }

}
