package com.yss.other.装饰者模式;

/**测试
 * 创建一个实体煎饼果子类并赋值给抽象煎饼果子类，然后将这个父类对象注入装饰类，
 * 再把得到的对象赋值给创建的抽象对象。
 * @author: duhao
 * @date: 2020/6/30 11:20
 */
public class DecoratorV2Test {
    public static void main(String[] args) {

        ABattercake aBattercake = new Battercake();// 实体煎饼果子的对象
           aBattercake = new EggDecorator(aBattercake);
           aBattercake = new SausageDecorator(aBattercake);

        System.out.println(aBattercake.getDesc()+"销售价格:"+aBattercake.cost());

    }
}
