package Java并发编程基础.狂神说;

/** 线程礼让测试
 * @author: duhao
 * @date: 2021/4/20 16:57
 * 1. 礼让线程, 让当前正在执行的线程停止,但不阻塞
 * 2. 将线程从运行状态转换为就绪状态
 * 3. 让CPU重新调度, 礼让不一定成功,看CPU的调度
 */
public class YieldTest {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield,"A").start();
        new Thread(myYield,"B").start();
    }
}

class MyYield implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始礼让--");
      //  Thread.yield(); // 线程礼让方法
        System.out.println(Thread.currentThread().getName()+":结束礼让--");
    }
}