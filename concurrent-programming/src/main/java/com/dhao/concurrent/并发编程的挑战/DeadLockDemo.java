package com.dhao.concurrent.并发编程的挑战;

/**测试死锁
 * t1 t2 都等待对方释放锁
 * t1拿到锁后,由于异常没有释放锁,导致t2一致等待
 *
 * 检查方法:  jps -l  找到线程id
 *          jstack 线程id
 * @author: duhao
 * @date: 2021/1/10 19:45
 */
public class DeadLockDemo {
    private static  String A="A";
    private static  String B="B";

    public static void main(String[] args) {
          new DeadLockDemo().deadLock();
    }

    private void deadLock(){
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.sleep(2000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("1");
            }

            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("2");
                }
            }
        });
        t1.start();
        t2.start();

    }

}
