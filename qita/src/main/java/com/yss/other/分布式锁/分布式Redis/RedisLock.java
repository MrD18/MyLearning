package com.yss.other.分布式锁.分布式Redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: duhao
 * @date: 2020/8/7 13:41
 */
public class RedisLock {



    // 定一些常量
   private static Integer inventory = 1001;
    private static final int NUM = 1000;
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
    static ReentrantLock reentrantLock = new ReentrantLock();
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
        ExecutorService threadPoolExecutor =
                new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, linkedBlockingQueue, new ThreadPoolExecutor.AbortPolicy());
        long start = System.currentTimeMillis();
        Config config = new Config();
        config.useSingleServer().setAddress("192.168.232.111:6379");
        final RedissonClient client = Redisson.create(config);
        final RLock lock = client.getLock("lock");

        for (int i = 0; i <= NUM; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    lock.lock();
                    inventory--;
                    System.out.println(inventory);
                    if (lock!=null&&lock.isHeldByCurrentThread()){
                        lock.unlock();
                    }
                } catch (Exception e) {
                    String msg = String.format("UNLOCK FAILED: key=%s", lock);
                    throw new IllegalStateException(msg, e);
                }

            });
        }
        long end = System.currentTimeMillis();
        System.out.println("执行线程数:" + NUM + "   总耗时:" + (end - start) + "  库存数为:" + inventory);

    }
}
