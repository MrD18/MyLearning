package com.yss.Spring注解驱动.test;

import com.yss.Spring注解驱动.bean.Person;
import com.yss.Spring注解驱动.config.PersonConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: duhao
 * @date: 2021/1/27 14:09
 */
public class ConfigTest {


    public static void main(String[] args) {
        //通过配置类获取到容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
        // 通过容器获取到bean
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean); //Person(userName=lisi, age=18)

        // 获取容器的名字,根据类型找
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String beanName : beanNamesForType) {
            System.out.println(beanName);//person
        }
        // 排除一些注解类型的容器
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }
}
