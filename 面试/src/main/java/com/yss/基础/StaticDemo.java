package com.yss.基础;

/**staitc关键字
 * @author: duhao
 * @date: 2021/4/9 15:57
 */
public class StaticDemo {

    private static String str1="staticProperty";
    private String str2="property";
    public StaticDemo(){}
//2.但是在非静态成员方法中是可以访问静态成员方法/变量的
    public void print1(){
        System.out.println(str1);
        System.out.println(str2);
        print2();
    }
//1.被static修饰的方法是静态方法: 静态方法中不能访问类的非静态成员变量,不能访问非静态成员变量
    public static void print2(){
        System.out.println(str1);
    //    System.out.println(str2);  非静态变量访问不了
    //    print1(); // 非静态方法访问不
    }
//3.直接用类名调用静态方法,静态成员变量;
    public  void testdiaoyong(){
        StaticDemo.print2();
        String str1 = StaticDemo.str1;
    }
//4.被static修饰的成员变量,会被所有对象共享,在内存中只有一个副本,类初次加载的时候会被初始化,
//5.可以有多个static块,类初次被加载的时候,会按照static块顺序来依次执行每个staitc块,且只会执行一次

}
