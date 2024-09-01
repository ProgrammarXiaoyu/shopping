package com.example.haohuanshop_boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.haohuanshop_boot.mapper")
public class HaoHuanShopBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(HaoHuanShopBootApplication.class, args);
    }
}