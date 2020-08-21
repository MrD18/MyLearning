package com.yss.java8.函数式处理数据2.Impl;

import com.yss.java8.函数式处理数据2.IUserCredential;

/**
 * @author: duhao
 * @date: 2020/8/21 14:59
 */
public class IUserCredentialImpl implements IUserCredential {
    @Override
    public String verifyUser(String username) {
        //模拟方法
        if ("admin".equals(username)){
            return "admin + 系统管理员";
        }else if("manager".equals(username)){
            return "manager + 用户管理员用户";
        } else {
            return "commons + 普通会员用户";
        }
    }
}
