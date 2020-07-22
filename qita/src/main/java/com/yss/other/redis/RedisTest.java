package com.yss.other.redis;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author: duhao
 * @date: 2020/7/21 14:24
 */
public class RedisTest {
    private static  Integer inventory = 1001;
    private static  final  int NUM=1000;
    private static LinkedBlockingQueue linkedBlockingQueue=new LinkedBlockingQueue();
    static  ReentrantLock reentrantLock =new ReentrantLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                    new ThreadPoolExecutor(inventory, inventory, 10L, SECONDS, linkedBlockingQueue);
     //  CountDownLatch 定义某些线程执行完后,才执行某些线程
       final CountDownLatch countDownLatch = new CountDownLatch(NUM);
        long start = System.currentTimeMillis();

        for(int i=1;i<=NUM;i++){

            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    reentrantLock.lock();
                    inventory--;
                    reentrantLock.unlock();
                    System.out.println("线程执行:"+Thread.currentThread().getName());
                    countDownLatch.countDown();
                }
            });
        }

        try {
            // await 会导致线程阻塞,直到countDown()方法，当前计数达到零，此后所有等待线程被释放
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("执行线程数:"+NUM+", 总耗时:"+(end-start)+", 库存数为:"+inventory);


    }

    @Async
    public  void  test(){



    }



}
