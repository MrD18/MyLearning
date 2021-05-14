package 线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**  使用线程的方式执行程序
 * @author: duhao
 * @date: 2021/4/23 13:53
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo();
        /**
         * 时间:17318
         * 大小:100000
         */
        ThreadPoolTest();
        /**
         * 时间:35
         * 大小:100000
         */
    }

    private static  void ThreadPoolTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        Random random = new Random();
        List<Integer> list= new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
       for(int i=1;i<=100000;i++){
               executorService.execute(()->{
                   list.add(random.nextInt());
               });
       }
        executorService.shutdown();
       executorService.awaitTermination(1, TimeUnit.DAYS); // 还是关闭线程池,与shutdown 搭配使用
        long end = System.currentTimeMillis();
        System.out.println("时间:"+(end-start));
        System.out.println("大小:"+list.size());


    }


    private static void ThreadDemo() throws InterruptedException {
        long start = System.currentTimeMillis();
        Random random = new Random();
        List<Integer> list= new ArrayList<>();
        // 创建10W个线程
        for(int i=1;i<=100000;i++){
            Thread thread = new Thread(() -> {
                list.add(random.nextInt());
            }, "Thread:" + i);
         thread.start();
         thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("时间:"+(end-start));
        System.out.println("大小:"+list.size());
    }
}
