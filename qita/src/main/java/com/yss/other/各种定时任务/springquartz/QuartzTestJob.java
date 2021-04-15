package com.yss.other.各种定时任务.springquartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**创建真正的定时任务执行类，该类继承QuartzJobBean。
 * @author: duhao
 * @date: 2021/4/14 10:41
 */
public class QuartzTestJob extends QuartzJobBean {
   // 执行的方法,在这里
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String userName = (String) context.getJobDetail().getJobDataMap().get("userName");
        System.out.println("userName"+userName);
    }
}
