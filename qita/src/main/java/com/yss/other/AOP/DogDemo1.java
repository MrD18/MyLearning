package com.yss.other.AOP;

/** 使用继承类:
 *  就是在子类中修改父类的方法，考虑到父类中如果方法很多，这种方法不可取。
 *  并且这种只对子类新创建的对象修改方法有效，父类还是原来的方法。
 * @author: duhao
 * @date: 2020/7/22 16:33
 */

/**
 * 使用继承父类，修改方法，但是只对新创建的对象有效
 */
public class DogDemo1 {
    public static void main(String[] args) {
        //修改方法只对新对象有效，对以前的对象无效
        System.out.println("-------这是一条继承狗-------");
        DogExtend dog = new DogExtend();
        dog.eat();
        dog.work();

        //原来对象无法修改
        System.out.println("-------这是一条老狗-------");
        Dog originDog = new Dog();
        originDog.eat();
        originDog.work();

    }
}

//继承狗，修改狗的方法
class DogExtend extends Dog{
    //修改eat
    @Override
    public void work() {
                System.out.println("我要看贼");
            }
}
/**
 * -------这是一条继承狗-------
 * 我喜欢吃骨头
 * 我要看贼     -- 继承狗 重写了work() 中的方法,打印结果由"我要守护主人"变成"我要看贼"。
 * -------这是一条老狗-------
 * 我喜欢吃骨头
 * 我要守护主人
 */