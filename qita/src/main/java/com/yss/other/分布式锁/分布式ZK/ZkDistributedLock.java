package com.yss.other.分布式锁.分布式ZK;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * 分布式锁
 * 哈哈  继承抽象类,必须实现其中的抽象方法
 *
 * @author: duhao
 * @date: 2020/7/29 14:23
 */
public class ZkDistributedLock extends ZkAbstractTemplateLock {
    @Override
    public boolean tryLock() {
        // 判断节点是否存在，如果存在则返回false，否者返回true
        try {
            zkClient.createEphemeral(path); //约定好的路径,有这个路径就返回true
            return true;
        } catch (Exception e) {
            // 没有路径返回false
            return false;
        }
    }

    @Override
    public void waitZKLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        };
        // 这里面传值需要监听器
        zkClient.subscribeDataChanges(path, iZkDataListener);
        if (zkClient.exists(path)) {
            // 等待锁的时候，需要加监控，查询这个lock是否释放
            countDownLatch = new CountDownLatch(1);
            // 解除监听
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //接触监听
            zkClient.unsubscribeDataChanges(path, iZkDataListener);
        }
    }
}
