package com.yss.other.分布式锁.单机模式Redis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现单机版redis 线程安全
 *
 * @author: duhao
 * @date: 2020/8/7 13:15
 */
public class RedisTest {
    // 定一些常量
    private static Integer inventory = 1001;
    private static final int NUM = 1000;
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
    static ReentrantLock reentrantLock = new ReentrantLock();
    static CountDownLatch countDownLatch = null;


    public static void main(String[] args) {
        // 准备用线程池来获取线程
        /**
         *     public ThreadPoolExecutor(int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         * ---------------------------------------------------------------------------------
         *                                  ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
         *         .setNameFormat("demo-pool-%d").build();
         *     ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
         *         0L, TimeUnit.MILLISECONDS,
         *         new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
         *
         *     singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
         *     singleThreadPool.shutdown();
         *
         */
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, linkedBlockingQueue, new ThreadPoolExecutor.AbortPolicy());
        // 在整一个计数器
        countDownLatch = new CountDownLatch(1);
        long start = System.currentTimeMillis();
        Jedis jedis = new Jedis("192.168.232.111",6379);
        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(() -> {
                //加锁,后能确定扣减成功
                reentrantLock.lock();
                inventory--;
                reentrantLock.unlock();
                System.out.println(Thread.currentThread().getName() + "\t 剩余库存:" + inventory);
                countDownLatch.countDown();
            });
        }
        // 关闭线程池
        threadPoolExecutor.shutdown();
        // 计数器唤醒
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("执行线程数:" + NUM + " 总耗时:" + (end - start) + " 库存数:" + inventory);

    }


}
