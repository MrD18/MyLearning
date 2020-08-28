package com.yss.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.yss.entity.User;
import com.yss.service.UserSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/6 17:07
 */
@Component
public class UserJob {
    @Autowired
    private UserSerice userSerice;

    @XxlJob("userJobHandler")
    public ReturnT<String> userJobHandler(String param) throws Exception {
        System.out.println("hello, user...");

        // 查询数据库，业务处理后再写回数据库
        List<User> users = userSerice.listAll();
        System.out.println(users);

        return ReturnT.SUCCESS;
    }

}
