package 线程池;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable接口
 *
 * @author: duhao
 * @date: 2020/6/18 9:46
 * 获取线程的几种方法
 * 1. 实现Runnable接口
 * 2. 实现Callable接口,有返回值
 * 3. 继承Thread类
 * 4. 使用线程池获取
 */
class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("come in callable");
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // FutureTask：实现了Runnable接口，构造函数又需要传入 Callable接口
        // 这里通过了FutureTask接触了Callable接口
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask, "aaa").start();

      // 输出FutureTask的返回值
        System.out.println("result FutureTask " + futureTask.get());

        System.out.println(Thread.currentThread().getName()+"\t 主线程");
    }
}