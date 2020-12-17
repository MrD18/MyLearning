package Synchronized和Lock区别与好处;

/**
 * @author: duhao
 * @date: 2020/12/4 11:18
 * 2个线程轮流打印1 A 2 B
 * 基于Synchornized实现
 */
public class SynchornizedDemo {


    public static void main(String[] args) {
       final  Object o = new Object();

        char[] a="1234567890".toCharArray();
        char[] b="ABCDEFGHIJ".toCharArray();
        new Thread(() -> {
            synchronized(o){
                for (char c : a) {
                    System.out.println(c);
                    try {
                        o.wait();
                        o.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
                }, "AA").start();


        new Thread(() -> {
            synchronized (o){

                for (char c : b) {
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

                }, "BB").start();


    }
}
