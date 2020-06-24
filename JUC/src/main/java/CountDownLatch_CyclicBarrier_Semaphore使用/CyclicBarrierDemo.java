package CountDownLatch_CyclicBarrier_Semaphore使用;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 和CountDownLatch相反，需要集齐七颗龙珠，召唤神龙。也就是做加法，开始是0，
 * 加到某个值的时候就执行

 CyclicBarrier的字面意思就是可循环（cyclic）使用的屏障（Barrier）。
 它要求做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活，
 线程进入屏障通过CyclicBarrier的await方法
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            // 只有执行了7个线程后, 主线程才会执行
            System.out.println(Thread.currentThread().getName()+"\t 开始召唤神龙");
        });
        for (int i = 1; i <=7; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 收集到 第:"+ finalI +"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();

        }

    }

}
