package com.yss;

/** 创建线程方式一
 * 1. 继承Thread  重写run
 * 2. 创建线程对象   调用start()方法   不会立即执行,需要等待CPU调度
 *     run 方法是普通方法
 * @author: duhao
 * @date: 2020/7/4 16:23
 */
public class StartThread extends Thread{
    /**
     * 线程入口点
     */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌");
   try{Thread.sleep(1000*1);}catch(InterruptedException e){e.printStackTrace();}

        }
    }

    public static void main(String[] args) {
        // 创建子类对象
        StartThread startThread = new StartThread();
        // 启动  , 子类对象.start, 不保证立即执行,由CPU调用
         startThread.start();    // 开启线程交给CPU  继续往下走,和main方法没有关系
        //  startThread.run();   // run方法就是一个普通方法, 按照从上到下的顺序执行, 就是歌听完了 再会执行敲代码
       // 这是main方法自己的, 自己执行自己的
        for (int i = 0; i < 20; i++) {
            System.out.println("一边敲代码");
             try{Thread.sleep(1000*1);}catch(InterruptedException e){e.printStackTrace();}

        }
    }


}
/**
 * 这个main方法里面的代码和线程对象代码的顺序 还是有关系的,
 *  for (int i = 0; i < 20; i++) {
 *             System.out.println("一边敲代码");
 *              try{Thread.sleep(1000*1);}catch(InterruptedException e){e.printStackTrace();}
 *         }
 *
 *         StartThread startThread = new StartThread();
 *          startThread.start();
 *      那么就是敲代码20次后,  才创建的线程,
 *
 */