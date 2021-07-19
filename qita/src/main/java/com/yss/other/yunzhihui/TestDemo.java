package com.yss.other.yunzhihui;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @Author: dhao
 * @Date: 2021/6/8 6:29 下午
 */
@Slf4j
public class TestDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setName("xiaoming");
        user.setPassword("123456");
        user.setAccountId(1L);
        try {

            int x = 1 / 0 ;
            System.out.println(x );
            System.out.println(user);
        } catch (Exception e) {
            user.setAccountId(Long.valueOf(user.getAccountId().hashCode()));
        log.info("输出对象：{},异常信息：{}",user,e);
        }
    }
}
