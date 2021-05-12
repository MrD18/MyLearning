package 狂神说JUC.生产者消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock 实现生产与消费,是随机唤醒的
 * 没有使用到 condition 进行监视
 * @author: duhao
 * @date: 2021/5/12 13:29
 */
public class LockDemo {
    public static void main(String[] args) {

        B b = new B();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    b.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    b.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    b.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    b.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}

// 资源类(属性,方法)
//判断等待 业务 通知
class B{
    // 资源
    private int number=0;

     Lock lock=new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {

        lock.lock();

        try {
            while (number!=0){
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public  void decrement() throws InterruptedException {
        lock.lock();

        try {
            while (number==0){
                //等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}