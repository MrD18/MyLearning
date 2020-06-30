package com.yss.other.装饰者模式.煎平果子;

/** 香肠装饰类
 * @author: duhao
 * @date: 2020/6/30 11:19
 */
public class SausageDecorator extends AbstractDecorator {
    public SausageDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc()+"加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost()+2;
    }
}
