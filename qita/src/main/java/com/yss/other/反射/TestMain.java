package com.yss.other.反射;

import java.lang.reflect.Method;

/**
 * @author: duhao
 * @date: 2021/3/11 14:59
 */
public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.yss.other.反射.TestRflectionFather");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

    }
}
