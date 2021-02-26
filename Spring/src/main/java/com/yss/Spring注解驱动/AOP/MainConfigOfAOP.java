package com.yss.Spring注解驱动.AOP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP:动态代理
 *  *     指在程序运行期间动态的将某段代码切入到指定位置进行运行的编程方式
 *     1.导入aop模块:Spring AOP:(spring-aspects) Springboot 一次性导入
 *     2. 定义一个业务逻辑类(MathCalculator):在业务逻辑运行的时候将日志进行打印(方法前,方法运行结束,方法出现异常)
 *     3. 定义一个日志切面类(LogAspects):切面类里面的方法需要动态感知MathCalculator.div 运行到哪里然后执行:
 *         通知方法:
 *              前置通知: (@Before) logStart: 在目标方法(div)运行之前运行
 *              后置通知: (@After) logEnd: 在目标方法(div)运行之后运行
 *              返回通知: (@AfterReturning) logReturn: 在目标方法(div)正常返回之后运行
 *              异常通知: (@AfterThrowing) logException: 在目标方法(div) 出现异常以后运行
 *              环绕通知: (@Around)  动态代理,手动推进目标方法运行(joinPonit.procced())
 *    4. 给切面类的目标方法标注何时进行(通知注解)
 *    5. 将切面类和业务逻辑类(目标方法所在的类)都加入到容器中
 *    6. 必须告诉Spring那个类时切面类(给切面类上面加一个注解:@Aspect)
 *    7. 必须配置类加上@EnableAspectJAutoProxy  [开启注解aop模式]
 *
 *    AOP原理:
 *       1. @EnableAspectJAutoProxy---> @Import(AspectJAutoProxyRegistrar.class) 引入的是这个组件
 *             最后发现给容器中注册的是一个:AnnotationAwareAspectJAutoProxyCreator
 *       2. AnnotationAwareAspectJAutoProxyCreator
 *            最后实现的是:  implements   SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *               那么就关注后置处理器(在bean初始化完成前后做的事情), 自动装配(BeanFactoryAware)
 *  @author: duhao
 * @date: 2021/2/3 16:17
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAOP {
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}
