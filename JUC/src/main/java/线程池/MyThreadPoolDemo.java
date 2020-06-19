package 线程池;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 第四种获取/使用java多线程的方式, 通过线程池
 *
 * @author: duhao
 * @date: 2020/6/19 9:35
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        /**
         * 几个辅助工具
         */
        // Array   Arrays(辅助工具)
        // Collection Collections(辅助工具类)
        // Executor Executors(辅助工具类)

        /**
         * 1. 一池5个处理线程（用池化技术，一定要记得关闭）
         * ExecutorService threadPool = Executors.newFixedThreadPool(5);
         *   使用队列: LinkedBlockingQueue<Runnable>()-->由链表结构组成的有界阻塞队列
         *                                               有界, 但是界限非常大,相当于无界
         *
         * 2. 创建一个只有一个线程的线程池
         *ExecutorService threadPool = Executors.newSingleThreadExecutor();
         *  使用队列: LinkedBlockingQueue<Runnable>()-->由链表结构组成的有界阻塞队列
         *                                              有界, 但是界限非常大,相当于无界
         *
         * 3.创建一个拥有N个线程的线程池，根据调度创建合适的线程
         *ExecutorService threadPool = Executors.newCacheThreadPool();
         * 使用队列: SynchronousQueue<Runnable>()--> 不存储元素的阻塞队列，也即单个元素的队列
         *                                           生产一个，消费一个，不存储元素，不消费不生产
         *
         */

        // 现在创建一个线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        //模拟10个用户来办理业务
        try {
            for (int i = 1; i <= 10; i++) {
                final int finalI = i;
                // 利用线程池进行消费线程, 不用之前的new 线程了
                fixedThreadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 给用户:" + finalI + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            fixedThreadPool.shutdown();
        }
    }
}
