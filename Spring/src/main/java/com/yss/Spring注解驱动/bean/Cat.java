package com.yss.Spring注解驱动.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author: duhao
 * @date: 2021/1/28 16:12
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat(){
        System.out.println("Cat构造器执行...");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("Cat 实现DisposableBean接口, 就有相应的销毁方法...destory..");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat 实现InitializingBean接口, 属性设置完后...init方法..");
    }
}
