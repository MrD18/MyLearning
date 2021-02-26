package com.yss.Spring注解驱动.test;

import com.yss.Spring注解驱动.config.BeanConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: duhao
 * @date: 2021/1/28 15:49
 */
public class BeanConfigOfLifeTest {


    @Test
    public void testSDog(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfigOfLifeCycle.class);
        System.out.println("容器创建完成....");
    }


    @Test
    public void testCar(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfigOfLifeCycle.class);
        System.out.println("容器创建完成....");
        //car constructor...
        //car....init...
        //容器创建完成....

        applicationContext.close();
        //car...destroy...

    }
    @Test
    public void testCat(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfigOfLifeCycle.class);
        System.out.println("容器创建完成....");
        //Cat 实现InitializingBean接口, 属性设置完后...init方法..
        //容器创建完成....

        applicationContext.close();
        //Cat 实现DisposableBean接口, 就有相应的销毁方法...destory..
        //car...destroy...
    }
}
