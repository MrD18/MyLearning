package com.yss.other.AOP;

/** 静态代理狗,弊端与装饰狗类似
 *
 * 这TM 静态代理与装饰者 没啥区别呀
 * @author: duhao
 * @date: 2020/7/22 16:47
 */
public class DogDemo3 {
    public static void main(String[] args) {
        System.out.println("-------这是一条老狗-------");
        Dog originDog=new Dog();
        originDog.eat();
        originDog.work();

        System.out.println("-------这是一条代理狗-------");
          ProxyDog proxyDog=new ProxyDog();
           proxyDog.eat();
             proxyDog.work();

    }


}
//代理狗
class ProxyDog implements Animal{
  // 创建老狗对象
       Dog dog = new Dog();
//也需要重写所有的接口方法
    @Override
    public void eat() {
        //吃方法不重写
        dog.eat();
    }

    @Override
    public void work() {
        //工作方法修改
        System.out.println("我是代理狗，我也爱工作");
    }
}
/**
 * -------这是一条老狗-------
 * 我喜欢吃骨头
 * 我要守护主人
 * -------这是一条代理狗-------
 * 我喜欢吃骨头
 * 我是代理狗，我也爱工作
 */