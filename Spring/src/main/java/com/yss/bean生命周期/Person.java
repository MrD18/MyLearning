package com.yss.bean生命周期;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**Spring 创建Bean的生命周期
 *IOC(控制翻转)
 * Spring 中的一个核心组件
 * 1. BeanFactory: spring容器的顶层接口
 *    ApplicationContext 它的子接口
 *    区别:  创建对象的时间不一样
 *        BeanFactory: 什么时候使用什么时候创建
 *        ApplicationContext: 只要一读取配置文件,默认就创建对象
 * 2. 关于对AppliactionContext接口的实现类使用
 *     ClassPathXmlApplicationContext : 从类路径下读取配置xml文件-- 我们用的是这个
 *     FileSystemXmlApplicactionContext： 绝对路径下读取配置xml文件（一般不用）
 *     AnnotationConfigApplicationContext：纯注解模式使用
 * @author: duhao
 * @date: 2020/7/22 11:19
 */

/**
 * Bean 自身方法: 包括bean本身调用的方法和配置文件中的<bean> 的init-method和destroy-menthod指定的方法
 * Bean 级生命周期接口方法: BeanNameAware,BeanFactorAware,InitializingBean,DisposableBean这些接口方法
 * 容器级生命周期接口方法 InstantiationAwareBeanPostProcessor 和 BeanPostProcessor 这两个接口实现，一般称它们的实现类为“后处理器”。
 * 工厂后处理器接口方法:AspectJWeavingEnabler, ConfigurationClassPostProcessor, CustomAutowireConfigurer等等非常有用的工厂后处理器　　
 *                   接口的方法。工厂后处理器也是容器级的。在应用上下文装配配置文件之后立即调用。
 *
 *
 */

public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean, BeanPostProcessor {
    private  String name;
    private  String address;
    private  String phone;
    private  BeanFactory beanFactory;
    private  String beanName;

    public Person() {
        System.out.println("↑↑↑↑↑对象被实例化之前,可以调用BeanPostProcessor做[{前置}]处理");
        System.out.println(" 对象的空参构造----[构造器]调用Person 的构造器实例化");
        System.out.println("↓↓↓↓↓对象被实例化之前,可以调用BeanPostProcessor做[{后置}]处理");
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        System.out.println("[注入属性] 注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("[注入属性] 注入属性address");
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("[注入属性] 注入属性phone");
        this.phone = phone;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", phone=" + phone + ", beanFactory=" + beanFactory + ", beanName='" + beanName + '\'' + '}';
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        System.out.println("【如果实现了BeanFactoryAware接口】那么就调用BeanFactoryAware.setBeanFactory()对BeanFactory设置");
        this.beanFactory=arg0;
    }
 //这是 DipsibleBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("【如果实现了DiposibleBean接口】那么在销毁的时候调用DiposibleBean.destory()方法");

    }
    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【如果实现了InitializingBean接口】那么就调用InitializingBean.afterPropertiesSet() ---初始化bean的时候执行，可以针对某个具体的bean进行配置" );

    }
    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String arg0) {
        System.out.println("【如果实现了BeanNameAware接口】那么就调用BeanNameAware.setBeanName(),对bean进行设置");
            this.beanName = arg0;
    }
    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
            System.out.println("【init-method】调用的是XML中<bean>的init-method属性指定的初始化方法");
         }

        // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
         System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
            }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before: 在bean初始化话之前的一些工作..beanName:"+bean);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After: 在bean初始化话之后的一些工作..beanName:"+bean);
        return null;
    }
}
