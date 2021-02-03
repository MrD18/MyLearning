package com.yss.proxy01;

/**
 * @author: duhao
 * @date: 2020/12/25 9:45
 */
//房东
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东实现了租房的接口,房东要出租房子");
    }
}
