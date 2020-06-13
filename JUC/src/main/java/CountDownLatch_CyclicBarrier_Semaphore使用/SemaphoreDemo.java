package CountDownLatch_CyclicBarrier_Semaphore使用;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量主要用于两个目的
 *
 * - 一个是用于共享资源的互斥使用
 * - 另一个用于并发线程数的控制
 * 场景: 3个空车位, 6个车来抢, 肯定有3个是抢不到的的,等前3个释放资源后,剩下的在继续抢
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        /**
         * 初始化一个信号量为3，默认是false 非公平锁， 模拟3个停车位
         */
        Semaphore semaphore = new Semaphore(3, false);

        // 模拟6个抢车位
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    // 代表一辆车,已经占用了该车位
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到了车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t 离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    // 释放停车位
                    semaphore.release();
                }
            },String.valueOf(i)).start();

        }


    }
}
