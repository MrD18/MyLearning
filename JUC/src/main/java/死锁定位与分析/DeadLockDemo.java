package 死锁定位与分析;

/**
 * 死锁编码以及定位分析
 * <p>
 * 概念:吃着碗里看着锅里
 * 2个或者2个以上的线程,在争夺资源的时候互相等待,若无外力干涉就无法推进下去
 * <p>
 * 产生原因:
 * 系统资源不足
 * 进程运行推进的顺序不对
 * 资源分配不当
 *
 * @author: duhao
 * @date: 2020/6/19 14:11
 */

/**
 * 资源类
 */
class HoldLockThread implements Runnable {
    // 定义2个锁
    private String lockA;
    private String lockB;

    // 持有自己的锁,还要想得到别人的锁
    //有参数构造
    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有:" + lockA + "\t 尝试获取:" + lockB);
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockB + "\t 尝试获取:" + lockA);

            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";
        new Thread(new HoldLockThread(lockA,lockB),"t1").start();
        new Thread(new HoldLockThread(lockB,lockA),"t2").start();

    }
}
