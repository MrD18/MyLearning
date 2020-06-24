package java锁;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 手写自旋锁
 * spinlock 尝试获取锁的线程不会立即阻塞,而是采用循环的方式去获得锁,
 * 好处: 减少上下文切换的消耗,没有类似于wait的阻塞
 * 缺点: 不断的自旋,循环消耗CPU
 *
 * @author: duhao
 * @date: 2020/6/16 9:30
 * 手写自旋锁: 通过CAS操作完成自旋锁,A线程先进来调用myLock方法自己持有锁5秒，
 * B随后进来发现当前有线程持有锁，不是null，所以只能通过自旋等待，直到A释放锁后B随后抢到
 */
public class SpinLockDemo {
    // 获取对象的原子性对象
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        //获取当前进来的线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in");
        // 开始自旋, CAS 比较并替换,期望值是: null, 要更新的值: thread,不是的话就继续循环
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    /**
     * 解锁
     */
    public void myUnLock() {
        // 获取当前进来的线程
        Thread thread = Thread.currentThread();
        //自己用完后,把atomicRerence变成null
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t invked myUnlock");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        // 开启线程t1, 开始操作
        new Thread(() -> {
            // 抢到锁
            spinLockDemo.myLock();
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 开始释放锁
            spinLockDemo.myUnLock();
        }, "t1").start();
        // 让main线程暂停5s,使得t1先执行
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 1s后 启动t2线程,开始抢这个锁
        new Thread(() -> {
            // 获取当前进来的线程
//            Thread thread = Thread.currentThread();
//            System.out.println(Thread.currentThread().getName()+"\t come in");
            //抢锁
            spinLockDemo.myLock();
            //释放锁
            spinLockDemo.myUnLock();
        }, "t2").start();
    }
}

/**
 * 首先输出的是 t1	 come in
 *
 * 然后1秒后，t2线程启动，发现锁被t1占有，所有不断的执行 compareAndSet方法，来进行比较，直到t1释放锁后，也就是5秒后，t2成功获取到锁，然后释放
 */


