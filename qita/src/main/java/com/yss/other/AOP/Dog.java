package com.yss.other.AOP;

/** Dog类 实现Animal接口.
 * 里面还添加自定义方法一个，后面用来测试动态代理。
 * @author: duhao
 * @date: 2020/7/22 16:31
 */
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("我喜欢吃骨头");
    }

    @Override
    public void work() {
        System.out.println("我要守护主人");

    }
    // 添加一个接口外的方法, 测试JDK 静态代理类的不足
    public  final  void   see(){
        System.out.println("我能在黑夜中看到一切");
    }

}
