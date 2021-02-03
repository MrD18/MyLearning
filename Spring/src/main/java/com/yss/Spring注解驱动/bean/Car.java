package com.yss.Spring注解驱动.bean;

/**测试Car 生命周期
 * @author: duhao
 * @date: 2021/1/28 15:41
 */
public class Car {
     public Car(){
         System.out.println("car constructor...");
     }

     public void init(){
         //比如说初始化的时候,要创建很多的属性复制
         System.out.println("car....init...");
     }

     public void destroy(){
         // 销毁的时候,可以关闭一些资源等...
         System.out.println("car...destroy...");
     }




}
