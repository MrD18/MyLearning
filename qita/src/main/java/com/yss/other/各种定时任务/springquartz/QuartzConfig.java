package com.yss.other.各种定时任务.springquartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: duhao
 * @date: 2021/4/14 10:43
 */
@Configuration
public class QuartzConfig {
    @Value("${sue.spring.quartz.cron}")
    private String testCron;

    /**
     * 创建定时任务
     */
    @Bean
    public JobDetail quartzTestDetail(){
        JobDetail jobDetail  = JobBuilder.newJob(QuartzTestJob.class)
                .withIdentity("quartzTestDetail", "QUARTZ_TEST")
                .usingJobData("userName", "susan")
                .storeDurably()
                .build();
        return jobDetail;
    }
    /**
     * 创建触发器
     */
    @Bean
    public Trigger quartzTestJobTrigger() {
        //每隔5秒执行一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(testCron);

        //创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(quartzTestDetail())
                .withIdentity("quartzTestJobTrigger", "QUARTZ_TEST_JOB_TRIGGER")
                .withSchedule(cronScheduleBuilder)
                .build();
        return trigger;
    }
}
