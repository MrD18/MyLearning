package com.yss.AnnotationAOP.log;

import org.aspectj.lang.annotation.*;

/**
 * 自定义的一个日志类,将其织入
 *
 * @author: duhao
 * @date: 2020/12/25 15:48
 */
@Aspect
public class Log {
    @Pointcut("execution(* com.yss.AnnotationAOP.service.impl.UserSericeImpl.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void before() {
        System.out.println("===@before方法执行前===");
    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {
        System.out.println("===@AfterReturning我是返回后通知===");
    }

    public void after() {
        System.out.println("===@after方法后通知===");
    }

    @AfterThrowing(value = "webLog()")
    public void afterThrowingNotify() {
        System.out.println("===@AfterThrowing我是异常通知===");
    }

    public void around() {
        System.out.println("===@around我是环绕通知===");

    }
}
