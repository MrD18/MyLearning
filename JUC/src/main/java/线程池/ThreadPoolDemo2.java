package 线程池;

import java.util.concurrent.*;

/**3种线程池对比
 * @author: duhao
 * @date: 2021/4/23 14:29
 */
public class ThreadPoolDemo2 {
    public static void main(String[] args) {

        ExecutorService executorService1 = Executors.newCachedThreadPool();//可缓存的线程池----------->快
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);//固定数目的线程池----------->慢
        ExecutorService executorService3 = Executors.newSingleThreadExecutor(); // 单线程线程池--------->最慢
           // 自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 30, 0L,
                                                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));

        for (int i = 1; i <=100; i++) {
            threadPoolExecutor.execute(new MyTask(i));
        }

    }
}

class MyTask implements Runnable{
   int i =0;

   public MyTask(int i){
       this.i=i;
   }
    @Override
    public void run() {
        // i 第几个任务
        System.out.println(Thread.currentThread().getName()+"--"+i);
         try{Thread.sleep(1000L);}catch(InterruptedException e){e.printStackTrace();}

    }
}