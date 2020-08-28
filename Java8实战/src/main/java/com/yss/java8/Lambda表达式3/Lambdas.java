package com.yss.java8.Lambda表达式3;

/**
 * @author: duhao
 * @date: 2020/8/10 15:28
 */
public class Lambdas {
    static Runnable r1= new Runnable() {
        @Override
        public void run() {
            System.out.println("使用匿名类");
        }
    };

    static Runnable r2=()->{
        System.out.println("使用Lamdba表达式");
    };
    public static void main(String[] args) {
        r1.run();
        r2.run();

    }

}
