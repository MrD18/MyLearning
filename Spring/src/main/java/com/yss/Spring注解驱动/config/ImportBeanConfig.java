package com.yss.Spring注解驱动.config;

import com.yss.Spring注解驱动.bean.Color;
import com.yss.Spring注解驱动.bean.ColorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: duhao
 * @date: 2021/1/28 9:13
 */
@Configuration
@Import({Color.class})// 使用@Import注解,导入bean,  里面是一个数组[]
public class ImportBeanConfig {

    /**
     * 给容器中注册组件:
     * 1). 包扫描+组件标注注解(@Contrpller/@Service/@Repository/@Component)
     * 2). @Bean[导入的第三方包里面的组件]
     * 3). @Import[快速给容器中导入一个组件]
     *         1). @Import(要导入到容器中的组件):容器会自动注册这个组件,id默认是全类名
     *         2). ImportSelector: 返回需要导入的组件的全类名数组
     *         3). ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4). 使用Spring提供的FactoryBean(工厂Bean)
     *         1). 默认获取到的是工厂bean调用getObject创建的对象
     *         2). 要获取工厂Bean本身, 我们给id前加一个 & --> &colorFactoryBean
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
      return new ColorFactoryBean();
    }


}
