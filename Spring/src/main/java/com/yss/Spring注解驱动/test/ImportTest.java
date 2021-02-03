package com.yss.Spring注解驱动.test;

import com.yss.Spring注解驱动.config.ImportBeanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: duhao
 * @date: 2021/1/28 9:18
 */
public class ImportTest {


    @Test
    public void testFactoryBean(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportBeanConfig.class);
        System.out.println("ioc容器创建完成...");

        // 工厂Bean获取的是调用getObject创建的对象,也就是说,通过ColorFactoryBean 获取到的是里面注入的color bean对象
        Object factoryBean = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型:"+factoryBean.getClass()); //bean的类型:class com.yss.Spring注解驱动.bean.Color
       // 获取 factoryBean 这个对象,加"&"符号
        Object factoryBean2 = applicationContext.getBean("&colorFactoryBean");
        System.out.println("bean的类型:"+factoryBean2.getClass()); //bean的类型:class com.yss.Spring注解驱动.bean.ColorFactoryBean

    }


    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportBeanConfig.class);
        System.out.println("ioc容器创建完成...");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {

            System.out.println(beanDefinitionName); //com.yss.Spring注解驱动.bean.Color
        }

    }
}
