package com.yss.Spring注解驱动.config;

import com.yss.Spring注解驱动.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author: duhao
 * @date: 2021/1/27 14:05
 */
//配置类==配置文件
@Configuration  // 告诉spring这是一个配置类
/*// 排除指定规则的组件
@ComponentScan(value = "com.yss.Spring注解驱动",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
})*/
// 加载指定规则的组件
@ComponentScan(value = "com.yss.Spring注解驱动",includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}
,useDefaultFilters = false)
//@ComponentScan   value:指定要扫描的包
//excludeFilters = Filter[],指定扫描的时候按照什么规则排除哪些组件
//inclideFilters = Filter[],指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION: 按照注解
//FilterType.ASSIGNABLE_TYPE: 按照给定类型
//FilterType.ASPECTJ: 按照ASPECTJ表达式
//FilterType.REGEX: 按照正则表达式
//FilterType.CUSTOM: 按照自定义规则

public class PersonConfig {

    // 给容器中注册一个Bean, 类型为返回值类型, 方法名默认为bean Id, 可以通过value值进行指定
    @Bean(value = "person")
    public Person person(){

        return new Person("lisi",18);
    }
}
