package com.yss.Spring注解驱动.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**后置处理器: 初始化前后进行处理工作
 * @author: duhao
 * @date: 2021/1/29 10:09
 */
@Component
public class MyBeanPostProcess implements BeanPostProcessor {

    /**
     * bean初始化之前,做一些工作
     * @param bean   实例bean
     * @param beanName  bean的name
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在bean初始化话之前的一些工作..beanName:"+bean);
        return null;
    }

    /**
     * bean 初始化后做一些工作
     * @param bean 实例bean
     * @param beanName bean的name
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在bean初始化话之后的一些工作..beanName:"+bean);
        return null;
    }
}
