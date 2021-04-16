package Java并发编程基础.狂神说;

/**
 * @author: duhao
 * @date: 2021/4/16 16:11
 *
 * 创建线程方式一:继承Thread类, 重写run()方法,调用start开启线程
 * 总结: 注意,开启线程不一定立即执行, 由CPU调度执行
 */
public class ExtendThread extends Thread {
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("....我是子线程,所有执行的任务....");
        }
    }
    public static void main(String[] args) {
        // 创建线程对象
        ExtendThread testThread1 = new ExtendThread();
        //调用start()方法,开启线程
        testThread1.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("我是主线程...");
        }
    }
}
