package com.yss;


import com.yss.AnnotationAOP.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: duhao
 * @date: 2020/12/25 21:24
 */
public class MyTest {
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      // 动态代理的是接口
        UserService userService = (UserService) context.getBean("userService2");
         userService.update();
    }
}
