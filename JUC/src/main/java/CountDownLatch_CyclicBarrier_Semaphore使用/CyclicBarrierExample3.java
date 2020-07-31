package CountDownLatch_CyclicBarrier_Semaphore使用;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**新建 CyclicBarrier 的时候指定一个 Runnable
 * @author: duhao
 * @date: 2020/7/30 15:21
 */
public class CyclicBarrierExample3 {
    // 请求的数量
    private static final int threadCount = 550;
    // 需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
        System.out.println("------当线程数达到之后，优先执行------");
    });

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    public static void test(int threadnum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadnum:" + threadnum + "is ready");
        cyclicBarrier.await();
        System.out.println("threadnum:" + threadnum + "is finish");
    }

}
/**
 * threadnum:0is ready
 * threadnum:1is ready
 * threadnum:2is ready
 * threadnum:3is ready
 * threadnum:4is ready
 * ------当线程数达到之后，优先执行------
 * threadnum:4is finish
 * threadnum:0is finish
 * threadnum:1is finish
 * threadnum:3is finish
 * threadnum:2is finish
 * threadnum:5is ready
 * threadnum:6is ready
 * threadnum:7is ready
 * threadnum:8is ready
 * threadnum:9is ready
 * ------当线程数达到之后，优先执行------
 */