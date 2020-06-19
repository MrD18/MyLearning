package 线程池;

import java.util.concurrent.*;

/**手写线程池
 * @author: duhao
 * @date: 2020/6/19 9:58
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        /**
         * 合理参数设置:
         * CPU密集:
         *  CPU核数+1个线程数
         * IO密集:
         * CPU核数*2
         * CPU核数/(1-阻塞系数)   阻塞系数:0.8~0.9
         */
        final Integer corePoolSize=2;
        final Integer maximumPoolSize=5;
        final  Long keepAliveTime=1L;
  // 自定义线程池,只是改变LinkBlockingQueue的队列大小
        ExecutorService executorService= new ThreadPoolExecutor(
                   corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        /**
         * 4中拒绝策略
         * AbortPolicy()  --> 默认的, >线程总数+队列数   直接跑异常
         * DiscardPolicy() --> 直接丢弃任务,
         * CallerRunsPolicy()--> 不抛弃,不异常,将任务回退个调用者
         * DiscardOldestPolicy() --> 抛弃队列中等待最久的任务,把当前任务加入队列中尝试再次提交当前任务
         *
         */
        // 模拟10个线程
        try {
            for(int i=1;i<=10;i++){
                final  int tempInt=i;
                int finalI = i;
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 给第:"+ finalI +"办理业务");
                    });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
