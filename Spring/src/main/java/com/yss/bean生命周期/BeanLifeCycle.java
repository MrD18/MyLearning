package com.yss.bean生命周期;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**bean生命周期测试
 * @author: duhao
 * @date: 2020/7/22 13:45
 */
public class BeanLifeCycle {
    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
         //利用工厂得到bean
        Person person = factory.getBean("person", Person.class);
        //以上经过这整个过程的加工 bean已经装在完成,
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        factory.registerShutdownHook();
    }
}
