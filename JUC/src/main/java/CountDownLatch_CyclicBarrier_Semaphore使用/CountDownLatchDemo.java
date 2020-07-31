package CountDownLatch_CyclicBarrier_Semaphore使用;


import 枚举使用.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**让一些线程阻塞直到另一些线程完成一系列操作才被唤醒
 * CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，
 * 调用线程就会被阻塞。其它线程调用CountDown方法会将计数器减1（调用CountDown方法的线程不会被阻塞）
 * ，当计数器的值变成零时，因调用await方法被阻塞的线程会被唤醒，继续执行
 *
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
           // 引入计数器
        CountDownLatch countDownLatch = new CountDownLatch(6);
        // 6个同学在上自习
        for (int i = 1; i <= 6; i++) {
               new Thread(()->{
                   System.out.println(Thread.currentThread().getName()+"\t 被灭    ");
                   countDownLatch.countDown();
               },String.valueOf(CountryEnum.forEach_Enum(i))).start();
        }
        // await 会导致线程阻塞,直到countDown()方法，当前计数达到零，此后所有等待线程被释放
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 秦国统一");

    }
}
