package com.yss.other.各种定时任务.xxlJob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @author: duhao
 * @date: 2021/4/14 11:27
 */

@Component
public class HelloJobHandler extends IJobHandler {

    @XxlJob(value = "helloJobHandler")
    @Override
    public ReturnT<String> execute(String param) {
        System.out.println("XXL-JOB, Hello World.");
        return SUCCESS;
    }
}