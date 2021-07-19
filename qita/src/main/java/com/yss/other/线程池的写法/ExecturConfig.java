package com.yss.other.线程池的写法;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: dhao
 * @Date: 2021/7/9 9:43 上午
 */

@Configuration
public class ExecturConfig {


    @Bean("taskExector")
    public ThreadPoolTaskExecutor taskExector() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        int i = Runtime.getRuntime().availableProcessors();//获取到服务器的cpu内核
        executor.setCorePoolSize(5);//核心池大小   64
        executor.setMaxPoolSize(100);//最大线程数  1000
        executor.setQueueCapacity(1000);//队列程度   2000
        executor.setKeepAliveSeconds(1000);//线程空闲时间   300
        executor.setThreadNamePrefix("tsak-asyn");//线程前缀名称
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//配置拒绝策略
        return executor;
    }
}
