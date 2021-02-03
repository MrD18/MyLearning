package com.yss.Spring注解驱动.test;

import com.yss.Spring注解驱动.bean.RedAware;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: duhao
 * @date: 2021/2/3 14:10
 */
public class RedAwareTest {

    @Test
    public void testRedAware(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RedAware.class);
        System.out.println("ioc容器创建完成...");


    }
}
