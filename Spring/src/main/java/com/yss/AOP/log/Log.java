package com.yss.AOP.log;

/**
 * 自定义的一个日志类,将其织入
 *
 * @author: duhao
 * @date: 2020/12/25 15:48
 */
public class Log {
    public void before() {
        System.out.println("===@before方法执行前===");
    }

    public void after() {
        System.out.println("===@after方法后通知===");
    }

    public void afterReturning() {
        System.out.println("===@AfterReturning我是返回后通知===");
    }

    public void afterThrowingNotify() {
        System.out.println("===@AfterThrowing我是异常通知===");
    }

    public void around() {
        System.out.println("===@around我是环绕通知===");

    }
}
