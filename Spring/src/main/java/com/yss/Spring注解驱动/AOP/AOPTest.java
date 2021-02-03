package com.yss.Spring注解驱动.AOP;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: duhao
 * @date: 2021/2/3 16:48
 */
public class AOPTest {
    @Test
    public void testAOP(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1,10);
    }

}
