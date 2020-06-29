package com.yss.other.动态代理.Impl;

import com.yss.other.动态代理.IUserManager;

/**
 * @author: duhao
 * @date: 2020/6/29 9:32
 */
public class IUserManagerImpl  {

    public void addUser(String id, String password) {

        System.out.println("======调用了UserManagerImpl.addUser()方法======");
    }
}
