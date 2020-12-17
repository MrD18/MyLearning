package Synchronized和Lock区别与好处;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: duhao
 * @date: 2020/12/4 11:18
 * 2个线程轮流打印1 A 2 B
 * 基于Synchornized实现
 */
public class SynchornizedDemo2 {

    static   Thread t1=null,t2=null;
    public static void main(String[] args) {
    //   final  Object o = new Object();

        char[] a="1234567890".toCharArray();
        char[] b="ABCDEFGHIJ".toCharArray();
      t1 =  new Thread(() -> {

                for (char c : a) {
                    System.out.println(c);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                 }
                }, "t1");


    t2 =   new Thread(() -> {

                for (char c : b) {
                    System.out.println(c);
                    LockSupport.park();
                    LockSupport.unpark(t1);
            }
                }, "t2");
        t2.start();
   t1.start();

    }
}
