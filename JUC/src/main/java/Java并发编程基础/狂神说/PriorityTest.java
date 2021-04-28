package Java并发编程基础.狂神说;

/**
 * 线程优先级测试
 * java提供一个线程调度器来监控程序中启动后进入就绪状态的所有程序,调度
 * 按照优先级来执行
 *
 * 优先级范围: 1~10
 * Thread.MAX_PRIORITY  10
 * Thread.NORM_PRIORITY  默认5
 * Thread.MIN_PRIORITY  1
 *
 * 1. 获取优先级: Thread.currentThread().getPriority()
 * 2. 设置优先级: t3.setPriority(Thread.MAX_PRIORITY);
 *
 * 优先级只是意味着获得调度的概率低, 并不是优先级低就不会被调用了,都是CPU进行调度的
 *
 * @author: duhao
 * @date: 2021/4/21 10:10
 */
public class PriorityTest {
    public static void main(String[] args) {
        // main线程的优先级
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);
        // 直接启动t1
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(Thread.MIN_PRIORITY);
        t3.start();

        t4.setPriority(7);
        t4.start();

        t5.setPriority(6);
        t5.start();

        t6.setPriority(4);
        t6.start();

    }

}


class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}