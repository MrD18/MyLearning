package com.yss;

/**创建线程方式二  实现Runnable接口
 * 1. 创建:实现Runabble+ 重写Run
 * 2. 启动; 创建实现类对象+Thread对象_+start
 *
 * 推荐:避免单继承的局限性, 方便资源共享
 * @author: duhao
 * @date: 2020/7/4 17:10
 */
public class StartRun implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是实现了Runnable接口");

        }
    }


    public static void main(String[] args) {
        StartRun startRun= new StartRun();
        new Thread(startRun).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("我是主线程");

        }
    }
}
