package com.yss.other.装饰者模式.煎平果子;

/**用这个类装饰父类,选用抽象类
 * @author: duhao
 * @date: 2020/6/30 11:07
 */
public class AbstractDecorator extends ABattercake{
    // 注入抽象煎饼类的对象
    private  ABattercake aBattercake;

    public AbstractDecorator(ABattercake aBattercake) {
        this.aBattercake = aBattercake;
    }

    @Override
    protected  String getDesc() {
        return this.aBattercake.getDesc();
    }

    @Override
    protected  int cost() {
        return this.aBattercake.cost();
    }
}
