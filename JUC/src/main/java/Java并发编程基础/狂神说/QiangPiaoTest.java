package Java并发编程基础.狂神说;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: duhao
 * @date: 2021/4/16 17:32
 */
public class QiangPiaoTest  implements  Runnable {

   // 抢票的资源
    private  volatile int tickeNums=10;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
    lock.lock();
        try {
            while (true){
                //无限循环得有一个结束方法
                if (tickeNums<=0){
                    break;
                }
               // Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"-->抢到第"+tickeNums--+"票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        QiangPiaoTest qiangPiaoTest = new QiangPiaoTest();
        new Thread(qiangPiaoTest,"小明").start();
        new Thread(qiangPiaoTest,"老师").start();
        new Thread(qiangPiaoTest,"黄牛党").start();
    }
}
