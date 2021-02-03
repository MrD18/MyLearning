package com.yss.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author: duhao
 * @date: 2020/12/18 14:56
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BootRedis01App {
    public static void main(String[] args) {
        SpringApplication.run(BootRedis01App.class,args);
    }
}
