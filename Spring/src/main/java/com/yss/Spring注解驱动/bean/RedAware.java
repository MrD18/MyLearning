package com.yss.Spring注解驱动.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**使用spring底层的一些组件
 * @author: duhao
 * @date: 2021/2/3 14:01
 */
@Component
public class RedAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

     private  ApplicationContext applicationContext;

     //实现ApplicationContextAware接口,直接将容器传过来了
     @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc:"+applicationContext);
        this.applicationContext=applicationContext;
    }
   // 实现BeanNameAware 直接可以操作这个bean
    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean的名字:"+name);
    }

   // 实现EmbeddedValueResolverAware,解析占位符
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String resolveStringValue = resolver.resolveStringValue("你好${os.name}  我是#{20*18}");
        System.out.println("解析的字符串:"+resolveStringValue);
    }
}
