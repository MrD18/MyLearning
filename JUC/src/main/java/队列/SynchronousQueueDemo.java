package 队列;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**SynchronousQueue没有容量，与其他BlockingQueue不同，SynchronousQueue是一个不存储的BlockingQueue，
 * 每一个put操作必须等待一个take操作，否者不能继续添加元素
 * @author: duhao
 * @date: 2020/6/16 11:30
 *
 * 测试SynchronousQueue添加元素的过程
 * 首先我们创建了两个线程，一个线程用于生产，一个线程用于消费
 * 生产的线程分别put了 A、B、C这三个字段
 */
public class SynchronousQueueDemo {


       public static void main(String[] args) {
           BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

  // 生产
             new Thread(() -> {
                 try {
                     System.out.println(Thread.currentThread().getName()+"\t put A");
                     blockingQueue.put("A");
                     System.out.println(Thread.currentThread().getName()+"\t put B");
                     blockingQueue.put("B");
                     System.out.println(Thread.currentThread().getName()+"\t put C");
                     blockingQueue.put("C");
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }, "t1").start();

// 消费
             new Thread(() -> {

                 try {
                      try{Thread.sleep(1000*5);}catch(InterruptedException e){e.printStackTrace();}
                     System.out.println(Thread.currentThread().getName()+"\t task A");
                     blockingQueue.take();
                     try{Thread.sleep(1000*5);}catch(InterruptedException e){e.printStackTrace();}
                     System.out.println(Thread.currentThread().getName()+"\t task B");
                     blockingQueue.take();
                     try{Thread.sleep(1000*5);}catch(InterruptedException e){e.printStackTrace();}
                     System.out.println(Thread.currentThread().getName()+"\t task C");
                     blockingQueue.take();

                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }, "t2").start();

                  }
       
}
/*
t1	 put A
t2	 task A
t1	 put B
t2	 task B
t1	 put C
t2	 task C
   从结果中可以看出,每次t1 线程向队列中添加阻塞队列添加元素后,t1 就会等t2线程消费后,
   t2 挂起,继续等待t1存入,周而复始,形成一对一的模式
 */