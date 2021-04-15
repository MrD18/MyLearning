package com.yss.other.各种定时任务;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/** 单线程
 * spring task是spring3以上版本自带的定时任务，实现定时任务的功能时，
 * 需要引入spring-context包，目前它支持：xml 和 注解 两种方式。
 *
 * 优点:spring框架自带的定时功能, springboot已经封装的很好,支持复杂的cron表达式,满足绝大数单机版的业务场景
 *      单个任务时，当前次的调度完成后，再执行下一次任务调度。
 * 缺点:默认单线程，如果前面的任务执行时间太长，对后面任务的执行有影响。不支持集群方式部署，不能做数据存储型定时任务。
 * @author: duhao
 * @date: 2021/4/14 10:26
 */
@Service
public class SpringTask {

    @Scheduled(cron="0/10 * *  * * ? ")   //每10秒执行一次
    public void fun(){
        System.out.println("doSomething..");
    }
    /**
     * 常见cron表达式使用举例：
     * 0 0 0 1 * ?  每月1号零点执行
     * 0 0 2 * * ?  每天凌晨2点执行
     * 0 0 2 * * ?  每天凌晨2点执行
     * 0 0/5 11 * * ? 每天11点-11点55分，每隔5分钟执行一次
     * 0 0 18 ? * WED 每周三下午6点执行
     */
}
