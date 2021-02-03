package com.dhao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dhao.dao")
@SpringBootApplication
public class EasycodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycodeApplication.class, args);
    }

}
