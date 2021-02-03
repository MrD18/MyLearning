package com.yss.Spring注解驱动.AOP;

import org.springframework.stereotype.Component;

/**
 * AOP:
 * @author: duhao
 * @date: 2021/2/3 16:15
 */
@Component
public class MathCalculator {

    public int div(int i,int j){
        System.out.println("MathCalculator...div方法...");
        return i/j;
    }
}
