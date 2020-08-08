package com.yss.other.分布式锁.分布式ZK;


import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * ZKLock 抽象类
 * 这就是模板设计模式
 *
 * @author: duhao
 * @date: 2020/7/29 14:14
 */
public abstract class ZkAbstractTemplateLock implements ZKLock {

    public static final String ZKSERVER = "127.0.0.1";
    public static final int TIME_OUT = 45 * 1000;
    ZkClient zkClient = new ZkClient(ZKSERVER, TIME_OUT);
    protected String path = "/zklock0401";
    protected CountDownLatch countDownLatch = null;

    @Override
    public void zkLock() {
        // 尝试获取锁
        if (tryLock()) {
            System.out.println(Thread.currentThread().getName() + "\t 占用锁成功");
        } else {
            //等待锁
            waitZKLock();
            //重新调用获取锁的方法
            zkLock();
        }
    }

    /**
     * 定义两个抽象方法, 一个尝试锁,一个是等待锁
     */
    /**
     * 同时我们在抽象类里，又定义了两个抽象方法，zkWaitLock()  和 tryLock
     * 最后我们是具体的实现方法
     */
    public abstract boolean tryLock();

    public abstract void waitZKLock();

    @Override
    public void zkUnLock() {
        if (zkClient != null) {
            zkClient.close();
        }
        System.out.println(Thread.currentThread().getName() + "\t 释放锁成功");
        System.out.println();
        System.out.println();
    }
}
