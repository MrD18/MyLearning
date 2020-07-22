package com.yss.other.AOP;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**使用cglib动态代理，它不仅仅可以实现接口中的方法，还可以实现父类中的非final定义的方法
 * @author: duhao
 * @date: 2020/7/22 17:11
 */
public class DogDemo5 {
    public static void main(String[] args) {
        System.out.println("-------这是一条老狗-------");
          Dog originDog=new Dog();
              originDog.eat();
            originDog.work();

            //下面使用cglib动态代理，需要额外导包，spring-core包集成了cglib包
          // 1. 创建增强器
        Enhancer enhancer = new Enhancer();
        // 2.指定要实现的接口，这句可以不写
        enhancer.setInterfaces(originDog.getClass().getInterfaces());
        //3. 指定要继承的父类
        enhancer.setSuperclass(originDog.getClass());

        //4.  设定回调函数
        enhancer.setCallback(new MethodInterceptor() {
            /**
             28              * 指定动态代理对象中的方法，会进入这里执行
             29              * @param proxy 被代理对象
             30              * @param method 被代理对象的方法
             31              * @param args 被代理对象方法上的参数
             32              * @param methodProxy 方法代理对象
             33              * @return
             34              * @throws Throwable
             35              */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
               // 如果是work 方法,就重写
                if ("work".equals(method.getName())){
                    System.out.println("我是cglib动态代理狗，我也非常爱工作");
                 return null;
                }else {
                    return method.invoke(originDog,args);
                }

            }
        });
     // 生成代理狗
     Dog    proxyDog = (Dog) enhancer.create();
        //使用动态代理狗方法
        System.out.println("-------这是一条动态cglib代理狗-------");
      proxyDog.eat();
      proxyDog.work();
        //可以执行父类上的非接口定义方法，因此推荐使用cglib代理方法
      proxyDog.see();
    }

}
