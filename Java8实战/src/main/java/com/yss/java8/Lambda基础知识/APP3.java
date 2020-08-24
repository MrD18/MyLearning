package com.yss.java8.Lambda基础知识;

/**
 * 测试变量捕获
 * 全局变量  局部变量 内部变量
 *
 * @author: duhao
 * @date: 2020/8/24 11:29
 */
public class APP3 {
    String s1 = "全局变量";

    // 1. 匿名内部类型中对于变量的访问
    public void testInnerClass() {
        String s2 = "局部变量";

        new Thread(new Runnable() {
            String s3 = "内部变量";
            @Override
            public void run() {
              // s1="hello";  这局部变量可以修改
                // 访问全局变量
                System.out.println(s1);
                // 访问局部变量
              //  s2="hello";
                System.out.println(s2);// 局部变量的访问，~不能对局部变量进行数据的修改[final]
                System.out.println(s3);
                // 访问内部变量
                s3="修改内部变量";
                System.out.println(this.s3);
            }
        }).start();
    }


    // 2. lambda表达式变量捕获
    public  void testLambda(){
        String s2="局部变量";
        new Thread(()->{
            String s3="内部变量";
            System.out.println();
            System.out.println();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(this.s1);// this点的是全局变量
            System.out.println(s3);
            s3 = "labmda 内部变量直接修改";
            System.out.println(s3);
        }).start();


    }


    public static void main(String[] args) {
        APP3 app3 = new APP3();
        app3.testInnerClass();
        app3.testLambda();
    }
}
