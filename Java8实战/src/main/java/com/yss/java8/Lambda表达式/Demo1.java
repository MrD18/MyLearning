package com.yss.java8.Lambda表达式;

/**
 * 为什么要用Lambda表达式:
 * 我们可以把Lambda表达式理解为是一段可以传递的代码，将代码像数据一样传递，这样可以写出更简洁、更灵活的代码，作为一个更紧凑的代码风格，使Java语言表达能力得到了提升
 *
 * @author: duhao
 * @date: 2020/8/18 16:48
 */
public class Demo1 {
    public static void main(String[] args) {
        /**
         * 原来使用匿名内部类
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类获取当前线程的编号:" + Thread.currentThread().getId());
            }
        }).start();

        /**
         * 采用Lambda方式
         */
        new Thread(() -> {
            System.out.println("采用Lambda方式获取当前线程编号:" + Thread.currentThread().getId());
        }).start();
    }
}