package java锁;

import java.util.concurrent.locks.ReentrantLock;

/**可重入锁(也叫递归)
 * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取到该锁的代码，在同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 * 也就是说：`线程可以进入任何一个它已经拥有的锁所同步的代码块`
 *
 * 这里只是测试了Synchronized,  ReenterLock 同样的使用
 * 想法: 将两个方法分别上不同的锁,一个用synchronized   一个用锁对象,方法套方法,
 * 结果: 也可以实现可重入操作
 * 问题: 一个是关键字,一个是对象,为什么能通用?
 * 回答:
 *
 * @author: duhao
 * @date: 2020/7/9 13:51
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
         // 获取资源对象
        Phone phone = new Phone();
        // 两个线程操作资源
        for(int i=1;i<=2;i++){
               new Thread(()->{
                phone.sendSMS();
               },String.valueOf(i)).start();
        }
    }

}
/**
 * 资源类
 */
class Phone{
      ReentrantLock lock=  new ReentrantLock();
   // 发送短信
public synchronized  void sendSMS(){
    System.out.println(Thread.currentThread().getName()+"\t invoked sendSMS()");
    // 在同步方法中调用另个一同步方法
    sendEmail();

}
    // 发送邮件
    public  void sendEmail() {
      lock.lock();

        try {
            System.out.println(Thread.currentThread().getName()+"\t invoked sendEmail()");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
