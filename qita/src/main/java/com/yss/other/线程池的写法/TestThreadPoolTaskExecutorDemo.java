package com.yss.other.线程池的写法;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: dhao
 * @Date: 2021/7/9 9:38 上午
 */
@RestController
public class TestThreadPoolTaskExecutorDemo {

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

   @GetMapping("/demo/test")
    private  String threadTest() {

        taskExecutor.execute(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("***************************");
            System.out.println(Thread.currentThread().getName());
            System.out.println("***************************");
        });
       System.out.println("***********threadTest***********");
       return "success";
    }




    /**
     * @Date:
     * @describe: 有参返回方法
     * @return : null
     * @throws:
     */
    @GetMapping("/demo/hasReturn")
    public String hasReturn() throws ExecutionException, InterruptedException {
        Future<String> future = taskExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("***************************");
                System.out.println(Thread.currentThread().getName());
                System.out.println("***************************");
                return "执行成功";
            }
        });
        System.out.println("***********hasReturn***********");
        String returnStr = future.get();
        System.out.println("hasReturn:"+returnStr);
        System.out.println("***********end***********");
        return "success";
    }
}


