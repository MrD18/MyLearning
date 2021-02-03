package com.yss.other.过滤器与拦截器;

import org.springframework.boot.SpringApplication;

/**
 * @author: duhao
 * @date: 2020/8/5 16:28
 */
//注解所扫描的包路径必须包含该Filter
//@ServletComponentScan(basePackages = "com.yss.other.过滤器与拦截器.filter")-- 这种是基于@WebFilter 这种扫描方式
//@SpringBootApplication
public class DemoApp {
    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class,args);
    }

}
