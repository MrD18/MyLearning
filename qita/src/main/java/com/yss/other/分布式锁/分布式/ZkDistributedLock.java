package com.yss.other.分布式锁.分布式;

import java.util.concurrent.CountDownLatch;

/**分布式锁
 * 哈哈  继承抽象类,必须实现其中的抽象方法
 * @author: duhao
 * @date: 2020/7/29 14:23
 */
public class ZkDistributedLock extends ZkAbstractTemplateLock {
    @Override
    public boolean tryLock() {
        // 判断节点是否存在，如果存在则返回false，否者返回true
        return false;
    }

    @Override
    public void waitZKLock() throws InterruptedException {
        // 等待锁的时候，需要加监控，查询这个lock是否释放
        CountDownLatch countDownLatch = new CountDownLatch(1);

   // 解除监听
         countDownLatch.await();
    }
}
