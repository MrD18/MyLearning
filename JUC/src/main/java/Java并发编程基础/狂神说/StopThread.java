package Java并发编程基础.狂神说;

/**
 * 线程停止的方法
 *
 * @author: duhao
 * @date: 2021/4/20 11:15
 * <p>
 * 1.不推荐使用JDK提供的stop() 方法
 * 2. 推荐线程自己停下来
 * 3. 使用一个标志位进行终止变量,当flag=false,则终止线程运行
 */
public class StopThread implements Runnable {

    // 定义一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("子线程正在进行累加.." + i++);
        }
    }

    // 定义一个停止的方法
    private void stop() {
        this.flag = false;
    }


    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        new Thread(stopThread).start();

        /**外部标志位,使线程停止,建议使用这种方法:
         * 此代码的逻辑:
         * 1.子线程会从0持续进行累加...
         * 2.当主线程到i==666时会对子线程进行停止操作
         * 从打印的数据中就能看出来,子线程开始累加, 主线程也开始跑,都是有CPU调度,当主线程跑到666时,
         * 子线程停止了累加
         *
         */
        for (int i = 0; i <= 1000; i++) {
            System.out.println("main线程开始->"+i);
            if (i == 666) {
                //调用stop方法,进行线程停止
                stopThread.stop();
                System.out.println("让子线程停止了..");
            }
        }
    }
}
