package com.yss.Spring注解驱动.config;

import com.yss.Spring注解驱动.bean.Car;
import com.yss.Spring注解驱动.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**Bean的生命周期
 * @author: duhao
 * @date: 2021/1/28 15:41
 */
@ComponentScan("com.yss.Spring注解驱动.bean")
@Configuration
public class BeanConfigOfLifeCycle {
    /**
     * bean的生命周期:
     * bean创建---初始化---销毁过程
     * 容器管理bean的生命周期:
     * 我们可以自定义初始化和销毁方法, 容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和
     * 销毁方法.
     *
     * 构造(对象创建)
     *     单实例: 在容器启动的时候创建对象
     *     多实例: 在每次获取的时候创建对象
     *
     *  postProcessBeforeInitialization: 初始化之前
     *  初始化:
     *     对象创建完成, 并赋值好,调用初始化方法...
     *  postProcessAfterInitialization: 初始化之后
     *
     *  销毁:
     *     单实例: 容器关闭的时候
     *     多实例: 容器不会管理这个bean, 容器不会调用销毁方法
     *
     * 1). 指定初始化和销毁方法:
     *   指定init-method和destroy-method方法
     * 2). 通过spring给我们提供的InitializingBean(定义初始化逻辑)
     *                         DisposableBean(定义销毁逻辑)
     * 3).可以使用JSR250标准
     *         @PostConstruct: 在bean创建完成并且属性赋值完成,来执行初始化方法
     *         @PreDestroy: 在容器销毁bean之前通知我们进行清理工作
     * 4). Spring提供组件 BeanPostProcessor,bean的后置处理器,
     *     在bean初始化前后进行一些处理工作
     *     postProcessBeforeInitialization: 初始化之前
     *     postProcessAfterInitialization: 初始化之后
     *
     * Spring底层对 BeanPostProcess的使用:
     *  bean 赋值: 注入其他组件,@Autowired,生命周期注解功能, @Async, xxx BeanPostProcessor
     */

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();

    }

    @Bean
    public Cat cat(){
        return new Cat();
    }
}
