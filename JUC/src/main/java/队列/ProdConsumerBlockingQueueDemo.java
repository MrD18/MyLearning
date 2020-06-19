package 队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用阻塞队列-生产者与消费者(升级版)
 *
 * @author: duhao
 * @date: 2020/6/17 11:21
 * <p>
 * 使用阻塞队列不用关心效率、安全这些细节
 * 新版将用: volatil,CAS,atomiclnteger,BlockQueue,线程交互,原子引用
 * <p>
 * 关于多线程操作,我们记住下面几句话:
 * 线程 操作 资源类
 * 判断 干活 通知
 * 防止虚假唤醒机制
 */

// 资源类
class MyResource {
    //默认开启,进行生产消费
    // 用到Volatile 保持数据的可见性,当Tlag被修改后,所有的线程都知道被修改了
    private volatile boolean FLAG = true;
    // 使用原子包装类
    private AtomicInteger atomicInteger = new AtomicInteger();
    // 这里不能为了满足条件，而实例化一个具体的SynchronousBlockingQueue
    BlockingQueue<String> blockingQueue = null;

    // 采用依赖注入里面的,构造注入方法传入
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        // 查询传入的class是什么
        System.out.println(blockingQueue.getClass().getName());
    }

    /**
     * 消息的生产者
     *
     * @throws Exception
     */
    public void myProd() throws Exception {
        String data = null;
        boolean retValue;

        // 多线程环境的判断, 一定要用whlie进行,防止出现虚假唤醒
        //的那个FLAG为true时,开始生产
        while (FLAG) {
            //干活
            data = atomicInteger.incrementAndGet() + " ";
            // 2秒存一个data
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                //为true
                System.out.println(Thread.currentThread().getName() + "\t 插入队列:" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列:" + data + "失败");
            }
         //    try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
            TimeUnit.SECONDS.sleep(1);

        }
        //通知 ????
        System.out.println(Thread.currentThread().getName() + "\t 停止生产,表示FLAG=false,生产停止");
    }

    /**
     * 消费
     * @throws InterruptedException
     */
    public void myConsumer() throws InterruptedException {
        String retValue;
        // 多线程环境的判断, 一定要用whlie进行,防止出现虚假唤醒
        //的那个FLAG为true时,开始生产
        while (FLAG) {
            // 2s 消费一个data
            retValue = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (retValue != null && retValue != "") {
                System.out.println(Thread.currentThread().getName() + "\t 消费队列:" + retValue + "成功");
            } else {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 消费失败,队列中为空,退出");
                return;
            }
        }
    }

    /**
     * 停止生产的判断
     */
    public void stop() {
        this.FLAG = false;
    }
}

/**
 * @author dhao
 */
public class ProdConsumerBlockingQueueDemo {
    public static void main(String[] args) {
        // 传入具体的实现类 ArrayBlockingQueue
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            System.out.println();
            System.out.println();
            try {
                myResource.myProd();
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");

            try {
                myResource.myConsumer();
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();
        // 5s 后停止生产与消费
         try{Thread.sleep(1000*5);}catch(InterruptedException e){e.printStackTrace();}
        System.out.println("5s 停止生产与消费");
        myResource.stop();

    }
}
