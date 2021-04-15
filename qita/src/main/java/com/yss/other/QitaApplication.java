package com.yss.other;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling //开启定时任务的注解
public class QitaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QitaApplication.class, args);
    }

}
