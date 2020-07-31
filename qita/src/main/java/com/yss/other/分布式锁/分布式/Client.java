package com.yss.other.分布式锁.分布式;

/** 客户端
 * @author: duhao
 * @date: 2020/7/29 15:00
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            new Thread(() -> {
               new OrderService().getOrderNumber();

            }, String.valueOf(i)).start();
        }
    }
}