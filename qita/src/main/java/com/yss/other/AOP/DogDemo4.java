package com.yss.other.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**动态代理，使用JDK自带代理方法
 * @author: duhao
 * @date: 2020/7/22 16:51
 */

//JDK动态代理，使用JDK Proxy接口的静态方法newProxyInstance()来完成
// JDK动态代理可以比较完美的解决业务问题，但是它有个明显的问题，即只能实现接口中的方法，
// Dog类中自定义的see()方法无法通过代理类调用，编译期就会报错，这样就引出了Cglib动态代理
public class DogDemo4 {
    public static void main(String[] args) {
        System.out.println("-------这是一条老狗-------");
           Dog originDog=new Dog();
           originDog.eat();
           originDog.work();

              // 使用JDK 动态代理, 需要使用JDK 提供的Proxy

      Animal   proxyDog = (Animal) Proxy.newProxyInstance(originDog.getClass().getClassLoader(),
              originDog.getClass().getInterfaces(),new InvocationHandler() {
                                                  //InvocationHandler是接口，下面是匿名内部类
                  /**
                   * 当代理对象执行代理对象的方法时，会执行以下方法
                   * @param proxy 被代理对象
                   * @param method 被代理对象身上的方法
                   * @param args 被代理对象身上方法对应的参数
                   * @return
                   * @throws Throwable
                  */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                 // 如果是work方法,则进行修改

                 if ("work".equals(method.getName())){
                     System.out.println("我是JDK动态代理狗，我非常爱工作");
                     return null;
                 }
                 // 如果是其他方法不修改
                else {
                    return method.invoke(originDog,args);
                 }
            }
        });
 // 使用动态代理狗
        System.out.println("-------这是一条动态JDK代理狗-------");
         proxyDog.eat();
         proxyDog.work();

    }

}
