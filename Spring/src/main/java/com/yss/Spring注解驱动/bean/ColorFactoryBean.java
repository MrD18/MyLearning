package com.yss.Spring注解驱动.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author: duhao
 * @date: 2021/1/28 10:49
 */
// 创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

     // 返回一个Color对象, 这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject...");
        return  new Color();
    }
    // 返回对象的类型
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
   // 创建的是单例还是多例
    // true: 这个bean是单实例,在容器中保存一份
    // false: 多实例, 每次获取都会创建一个新的bean;
    @Override
    public boolean isSingleton() {
        return true;
    }
}
