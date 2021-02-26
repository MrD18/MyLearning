package com.yss.Spring注解驱动.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: duhao
 * @date: 2021/1/28 16:53
 */
    @Component //以组件的形式,注入到容器
    public class Dog {
    public Dog(){
        System.out.println("dog constructor...");
    }
    // 对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("Dog...对象复制之后...@PostConstruct...");
    }
    // 容器移除对象之前
    @PreDestroy
    public void detory(){
        System.out.println("Dog...对象移除以前... @PreDestroy");
    }











}
