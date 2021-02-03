package com.yss.Spring注解驱动.config;

import com.yss.Spring注解驱动.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author: duhao
 * @date: 2021/1/27 17:46
 */
@Configuration
public class PersonConfig2 {
    /**
     * prototype: 多实例: ioc容器启动不会去调用方法创建对象放在容器中,
     *           每次获取的时候才会调用方法创建对象
     * singleton: 单实例的(默认值),ioc容器启动会调用方法创建对象放到ioc容器中
     *             以后取都直接从容器中拿
     *  request: 同一次请求创建一个实例
     *  session: 同一个session创建一个实例
     *
     *  懒加载:
     *      单实例bean: 默认在容器启动的时候创建对象
     *      懒加载: 容器启动不创建对象,第一次获取bean的时候，才会创建对象,并初始化
     * @return
     */

      // @Scope("prototype")
    @Lazy   // 懒加载注解
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加Person...");
        return new Person("张三",25);
    }

}
