package com.yss.other.各种定时任务;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**使用Timer
 *
 * Timer类是jdk专门提供的定时器工具，用来在后台线程计划执行指定任务,在java.util包下，要跟TimerTask一起配合使用。
 *
 * 会存在以下问题,包括你在使用的时候,会提示你Timer运行多个TimeTask时, 只要其中一个没有捕获的异常,其他任务会自动终止运行,
 * 建议使用线城池ScheduledExecutorService:
 *   1.由于Timer是单线程执行任务，如果其中一个任务耗时非常长，会影响其他任务的执行。
 *   2.如果TimerTask抛出RuntimeException，Timer会停止所有任务的运行。
 * 优点: 非常方便实现多个周期性的定时任务,并支持延迟执行, 还支持指定时间之后支持,功能还算强大
 * 缺点: 如果其中一个任务耗时非常长，会影响其他任务的执行。并且如果TimerTask抛出RuntimeException，
 * Timer会停止所有任务的运行，所以阿里巴巴开发者规范中不建议使用它
 *
 * @author: duhao
 * @date: 2021/4/14 9:17
 */
public class TimerDemo {
    public static void main(String[] args) {
      //  init();
        init2();
    }

    public static void init(){
        // 先实例化一个Timer类
        Timer timer = new Timer();
        //调用schedule方法其中参数:实例化TimeTask类, 延迟时间,间隔时间
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("doSomething");
            }
        },2000,1000); //
    }

    /**
     * 阿里的规范中规定:建议不要使用,使用线程池
     *且每隔100毫秒执行一次。
     */
    public static void init2(){
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("run"+System.currentTimeMillis());
            }
        },0,100, TimeUnit.MILLISECONDS);
    }

}
