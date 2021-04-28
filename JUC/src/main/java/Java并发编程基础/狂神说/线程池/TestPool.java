package Java并发编程基础.狂神说.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 测试线程池
 * @author: duhao
 * @date: 2021/4/22 15:57
 */
public class TestPool {

    public static void main(String[] args) {
        // 1.创建服务, 创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 2.执行
         service.execute(new MyThread());
         service.execute(new MyThread());
         service.execute(new MyThread());
         service.execute(new MyThread());

        // 关闭
        service.shutdownNow();
    }
}

class MyThread implements  Runnable{


    @Override
    public void run() {

            System.out.println(Thread.currentThread().getName());

    }
}