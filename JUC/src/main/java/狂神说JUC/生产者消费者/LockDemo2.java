package 狂神说JUC.生产者消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock 实现生产与消费,实现精准唤醒
 * 可是用到 condition 进行监视
 *
 * @author: duhao
 * @date: 2021/5/12 13:52
 */
public class LockDemo2 {
    public static void main(String[] args) {

        C c = new C();
        new Thread(()->{
            c.printA();
        }).start();

        new Thread(()->{
            c.printB();
        }).start();

        new Thread(()->{
            c.printC();
        }).start();
    }
}

//资源类(属性, 方法)
class C {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public void printA() {
        lock.lock();

        try {
            while (number != 1) {
                condition1.await();
            }
            number = 2;
            System.out.println("AAAAAA");
            // 唤醒2
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void printB() {
        lock.lock();
        try {
            while (number!=2) {
           condition2.await();
            }
            number=3;
            System.out.println("BBBBBB");
            // 唤醒3
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printC() {
        lock.lock();
        try {
            while (number!=3) {
                condition3.await();
            }
            number=3;
            System.out.println("CCCCC");
            // 唤醒3
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}