package com.yss.other.AOP;

/**使用装饰者
 * @author: duhao
 * @date: 2020/7/22 16:39
 */

/**
 * 使用装饰者模式，将需要被装饰的狗注入装饰狗,但是这个有个弊端，需要实现接口Animal中所有方法
 * 如果共同的Animal接口有100个方法，则需要重写100个方法，也不是好的解决方案
 */
public class DogDemo2 {
    public static void main(String[] args) {
        System.out.println("-------这是一条老狗-------");
        Dog originDog = new Dog();
        originDog.eat();
        originDog.work();
        System.out.println("-------这是一条装饰狗-------");
        DecorateDog dog = new DecorateDog(new Dog());
        dog.eat();
        dog.work();
    }

}

/**
 * 这是装饰狗,装饰狗和被装饰狗，都需实现同样的接口
 */
class  DecorateDog implements Animal{
   //属性是装饰狗
   private Dog dog=null;
  // 被装饰狗注入
    public DecorateDog(Dog dog) {
        this.dog = dog;
    }

    //如果不修改，也需要实现接口中所有的方法
    @Override
    public void eat() {
           //吃不修改
               dog.eat();
    }

    @Override
    public void work() {
        //工作修改
        System.out.println("我是装饰狗，我爱工作");
    }
}