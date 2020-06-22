package Synchronized和Lock区别与好处;

/**
 * 区别
 *
 * @author: duhao
 * @date: 2020/6/17 14:37
 * <p>
 * 1）synchronized属于JVM层面，属于java的关键字
 * - monitorenter（底层是通过monitor对象来完成，其实wait/notify等方法也依赖于monitor对象 只能在同步块或者方法中才能调用 wait/ notify等方法）
 * - Lock是具体类（java.util.concurrent.locks.Lock）是api层面的锁
 * 2）使用方法：
 * - synchronized：不需要用户去手动释放锁，当synchronized代码执行后，系统会自动让线程释放对锁的占用
 * - ReentrantLock：则需要用户去手动释放锁，若没有主动释放锁，就有可能出现死锁的现象，需要lock() 和 unlock() 配置try catch语句来完成
 * 3）等待是否中断
 * - synchronized：不可中断，除非抛出异常或者正常运行完成
 * - ReentrantLock：可中断，可以设置超时方法
 * - 设置超时方法，trylock(long timeout, TimeUnit unit)
 * - lockInterrupible() 放代码块中，调用interrupt() 方法可以中断
 * 4）加锁是否公平
 * - synchronized：非公平锁
 * - ReentrantLock：默认非公平锁，构造函数可以传递boolean值，true为公平锁，false为非公平锁
 * 5）锁绑定多个条件Condition
 * - synchronized：没有，要么随机，要么全部唤醒
 * - ReentrantLock：用来实现分组唤醒需要唤醒的线程，可以精确唤醒，而不是像synchronized那样，要么随机，要么全部唤醒
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程循环调用:实现A->B->C 三个线程启动
 * A打印5次 B打印10次 C打印15次
 * 紧接着
 * A打印5次 B打印10次 C打印15次
 * <p>
 * 打印10轮
 */


//创建资源类
class MyData {
    //标志 A:1 B:2 C:3
    private Integer number = 1;
    //创建一个重入锁
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (number != 1) {
                // 不等于1 需要等待
                condition1.await();
            }
            //干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t A" + i);
            }
            //唤醒(干完活后,通知B线程执行)
            number = 2;
            // 定点唤醒 通知2去干活
            condition2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10() {
        lock.lock();
        try {
            while (number != 2) {
                // 不等于1 需要等待
                condition2.await();
            }
            //干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t B" + i);
            }
            //唤醒(干完活后,通知B线程执行)
            number = 3;
            // 定点唤醒 通知2去干活
            condition3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (number != 3) {
                // 不等于1 需要等待
                condition3.await();
            }
            //干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t C" + i);
            }
            //唤醒(干完活后,通知B线程执行)
            number = 1;
            // 定点唤醒 通知2去干活
            condition1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class SynchronizedAndReenTrantLockDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                myData.print5();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                myData.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                myData.print15();
            }
        }, "C").start();

    }

}
