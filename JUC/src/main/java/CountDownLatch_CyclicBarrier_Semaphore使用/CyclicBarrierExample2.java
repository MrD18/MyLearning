package CountDownLatch_CyclicBarrier_Semaphore使用;

import java.util.concurrent.*;

/**
 * @Description: 测试
 * @author: duhao
 * @date: 2020/7/30 14:53
 */
public class CyclicBarrierExample2 {
    // 请求数量
    private  static  final  int threadCount=550;
    // 需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier =  new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < threadCount; i++) {
            final  int threadNum=i;
            Thread.sleep(1000);
            threadPool.execute(()->{
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
     threadPool.shutdown();
    }

    public  static  void  test(int threadNum)  {
        System.out.println("threadnum:" + threadNum + "is ready");

        try {
            /**等待60秒，保证子线程完全执行结束*/
            cyclicBarrier.await(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadnum:" + threadNum + "is finish");
    }
}
/**可以看到当线程数量也就是请求数量达到我们定义的 5 个的时候， await方法之后的方法才被执行。
 *threadnum:0is ready
 * threadnum:1is ready
 * threadnum:2is ready
 * threadnum:3is ready
 * threadnum:4is ready
 * threadnum:4is finish
 * threadnum:0is finish
 * threadnum:1is finish
 * threadnum:2is finish
 * threadnum:3is finish
 * threadnum:5is ready
 * threadnum:6is ready
 * threadnum:7is ready
 * threadnum:8is ready
 * threadnum:9is ready
 * threadnum:9is finish
 * threadnum:5is finish
 *
 */