package com.yss.bean生命周期;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;

/** 在bean经过BeanDefination解析后,然后会经过BeanFactory进行实例化Bean,
 *   这实例化bean之间,会经过BeanFactoryPostProcessor 对Bean进行前置,后置处理,
 *   扩展出来的这个接口,我们可以用它做一些我们要达到的目的!!!
 * @author: duhao
 * @date: 2020/8/12 10:46
 */
@Configuration
public class YssBeanFactoryPostProcessor  implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)throws BeansException {
      // String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        Iterator<String> beanNamesIterator = configurableListableBeanFactory.getBeanNamesIterator();
        beanNamesIterator.forEachRemaining(s-> {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(s);
            System.out.println("-------到底做了啥--------");
            System.out.println(beanDefinition.getBeanClassName());
        });
    }
}
