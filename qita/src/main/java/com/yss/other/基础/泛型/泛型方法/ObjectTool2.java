package com.yss.other.基础.泛型.泛型方法;

/**
 * 泛型方法
 * @author: duhao
 * @date: 2021/4/22 17:20
 */
public class ObjectTool2 {

    //定义泛型方法..
    public <T> void show(T t) {
        System.out.println(t);

    }

    public static void main(String[] args) {
        // 创建对象
        ObjectTool2 objectObjectTool = new ObjectTool2();

        objectObjectTool.show("hello");
        objectObjectTool.show(12);
        objectObjectTool.show(12.5);
    }

}
