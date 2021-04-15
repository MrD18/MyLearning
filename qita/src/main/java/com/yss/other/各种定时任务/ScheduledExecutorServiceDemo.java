package com.yss.other.各种定时任务;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
  涉及到一些线程池的:

 * 是JDK1.5+版本引进的定时任务，该类位于java.util.concurrent并发包下。
 * ScheduledExecutorService是基于多线程的，设计的初衷是为了解决Timer单线程执行， 多个任务之间会互相影响的问题。
 * 优点: 基于多线程的定时任务,多个任务之间不会相互影响,支持周期性的执行任务,并带延迟功能
 * 缺点: 不支持一些复杂的定时规则
 * 包含的方法:
 *1.schedule(Runnable command,long delay,TimeUnit unit)，带延迟时间的调度，只执行一次，调度之后可通过Future.get()阻塞直至任务执行完毕。
 *2.schedule(Callable<V> callable,long delay,TimeUnit unit)，带延迟时间的调度，只执行一次，调度之后可通过Future.get()阻塞直至任务执行完毕，并且可以获取执行结果。
 *3.scheduleAtFixedRate，表示以固定频率执行的任务，如果当前任务耗时较多，超过定时周期period，则当前任务结束后会立即执行。
 *4.scheduleWithFixedDelay，表示以固定延时执行任务，延时是相对当前任务结束为起点计算开始时间。
 *
 */
public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
         //scheduleAtFixedRate，表示以固定频率执行的任务，如果当前任务耗时较多，超过定时周期period，则当前任务结束后会立即执行
        scheduledExecutorService.scheduleAtFixedRate(()->{
               System.out.println("doSomething...");
           },1000,1000, TimeUnit.MILLISECONDS);

    }
}
