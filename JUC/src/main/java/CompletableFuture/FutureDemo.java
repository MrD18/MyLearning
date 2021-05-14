package CompletableFuture;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 创建异步任务
 * Future.submit
 *
 * @author: duhao
 * @date: 2021/4/23 13:34
 */
public class FutureDemo {


  //  @Test
    public void test1() throws ExecutionException, InterruptedException {
        // 创建异步执行任务
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> cf = executorService.submit(() -> {
            System.out.println(Thread.currentThread() + "start,time-->" + System.currentTimeMillis());
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (false) {
                throw new RuntimeException("test");
            } else {
                System.out.println(Thread.currentThread() + " exit,time->" + System.currentTimeMillis());
                return 1.2;
            }
        });
        System.out.println("main thread start,time->"+System.currentTimeMillis());
        //等待子任务执行完成,如果已完成则直接返回结果
        //如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        System.out.println("run result->"+cf.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());

    }


}
