package com.yss.Spring注解驱动.test;

import com.yss.Spring注解驱动.config.PersonConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: duhao
 * @date: 2021/1/27 22:10
 */
public class LazyTest {
    @Test
    public void testLazy(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig2.class);
        System.out.println("ioc容器创建完成...");
        Object bean = applicationContext.getBean("person");
        Object bean1 = applicationContext.getBean("person");
        System.out.println(bean==bean1);

    }

}
