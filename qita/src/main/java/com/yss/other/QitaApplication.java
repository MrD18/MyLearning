package com.yss.other;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class QitaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QitaApplication.class, args);
    }

}
