package 队列;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock版本-生产者与消费者(传统版)
 *
 * @author: duhao
 * @date: 2020/6/17 10:45
 * <p>
 * 生产者消费者 传统版
 * 题目：一个初始值为0的变量，两个线程对其交替操作，一个加1，一个减1，来5轮
 * <p>
 * 关于多线程操作,我们记住下面几句话:
 * 线程 操作 资源类
 * 判断 干活 通知
 * 防止虚假唤醒机制
 */

// 先来一个资源类ShareData
class ShareData {
    private int namber = 0;
    private Lock lock = new ReentrantLock();
    //Condition依赖于lock 实现对线程的监控作用
    private Condition condition = lock.newCondition();

    // 做加法运算
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (namber != 0) {
                //等待 不能生产
                condition.await();
            }
            //干活
            namber++;
            System.out.println(Thread.currentThread().getName() + "\t " + namber);
            // 通知 唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 做减法
    public void decremet() throws Exception {
        lock.lock();
        try {
            //判断
            while (namber == 0) {
                // 等待 不能消费
                condition.await();
            }
            // 干活
            namber--;
            System.out.println(Thread.currentThread().getName() + "\t " + namber);
            // 通知 唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ProdConsumerTraditionDemo {

    public static void main(String[] args) {
        // 高内聚，低耦合    内聚指的是，一个空调，自身带有调节温度高低的方法
        ShareData shareData = new ShareData();
        // t1 线程,生产
        new Thread(() -> {
            // 来5轮
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                     try{Thread.sleep(1000*3);}catch(InterruptedException e){e.printStackTrace();}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
        //t2 线程,生产
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decremet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
    }
}
/*
t1	 1
t2	 0
t1	 1
t2	 0
t1	 1
t2	 0
t1	 1
t2	 0
t1	 1
t2	 0
生产一个,消费一个
 */