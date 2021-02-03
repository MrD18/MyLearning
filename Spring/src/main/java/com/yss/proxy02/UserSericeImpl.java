package com.yss.proxy02;

import com.yss.dynamicproxy.UserService;

/**
 * @author: duhao
 * @date: 2020/12/25 10:31
 */
public class UserSericeImpl implements UserService {
    @Override
    public void add() {
        System.out.println("这是一个add方法");
    }

    @Override
    public void delete() {
        System.out.println("这是一个delete方法");
    }

    @Override
    public void update() {
        System.out.println("这是一个update方法");
    }

    @Override
    public void list() {
        System.out.println("这是一个list方法");
    }
}
