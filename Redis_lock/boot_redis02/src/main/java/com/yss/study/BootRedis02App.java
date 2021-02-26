package com.yss.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author: duhao
 * @date: 2020/12/18 15:41
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BootRedis02App {
    public static void main(String[] args) {
        SpringApplication.run(BootRedis02App.class,args);
    }
}
