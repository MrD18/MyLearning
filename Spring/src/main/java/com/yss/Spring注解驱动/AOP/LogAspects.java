package com.yss.Spring注解驱动.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**日志监控
 * @author: duhao
 * @date: 2021/2/3 16:25
 */
@Aspect
//@Component
public class LogAspects {

    @Pointcut("execution(public * com.yss.Spring注解驱动.AOP.MathCalculator.*(..))")
    public void LogAspects(){

    }
    @Before("LogAspects()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        //返回方法名  方法参数
        System.out.println(""+joinPoint.getSignature().getName()+"运行...@Before:运行参数表:{"+ Arrays.asList(args)+"}");
    }
    @After("LogAspects()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"除法结束");
    }

    @AfterReturning(value = "LogAspects()",returning = "result")  // result接返回值
    public void logReturn(Object result){
        System.out.println("除法正常返回...运行结果:{"+result+"}");
    }
    @AfterThrowing(value = "LogAspects()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println("除法异常"+joinPoint.getSignature().getName()+"异常信息是 :{"+exception+"}");
    }







}
