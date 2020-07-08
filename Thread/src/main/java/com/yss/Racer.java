package com.yss;

/**模拟龟兔赛跑
 * @author: duhao
 * @date: 2020/7/4 17:35
 */
public class Racer implements  Runnable {
    // 定义胜利者
    private  static  String winner;
    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            // 模拟休息
            if ("兔子".equals(Thread.currentThread().getName())){
             try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
               
            }
            System.out.println(Thread.currentThread().getName()+"-->"+i);
               // 判断比赛是否结束
            boolean flag=gameOver(i);
            if (false){
                break;
            }
        }
    }

    private  boolean gameOver(int i){
        //如果有胜利者跳出循环
        if (winner!=null){ // 存在胜利者,比赛结束
               return true;
        }else {
            if (i==100){
                winner=Thread.currentThread().getName();
                System.out.println("胜利者:"+winner);
                return  true;
            }
        }
        return false;
    }

    // main
    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"兔子").start();
        new Thread(racer,"乌龟").start();
    }
}
