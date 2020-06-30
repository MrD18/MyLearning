package com.yss.other.装饰者模式;

/** 实体煎饼果子类,实体煎饼果子继承抽象煎饼果子
 * @author: duhao
 * @date: 2020/6/30 11:03
 */
public class Battercake extends ABattercake {
    @Override
    public String getDesc() {
        return "煎饼";
    }

    @Override
    public int cost() {
        return 8;
    }
}
