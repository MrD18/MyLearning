package Java并发编程基础.狂神说;

/**
 * 龟兔赛跑
 * @author: duhao
 * @date: 2021/4/19 10:08
 */
public class Race implements Runnable{
    // 胜利者
    private static String winner;
    @Override
    public void run() {
        for (int i = 1; i <=100; i++) {
            // 让兔子休息下,名字是兔子
            if (Thread.currentThread().getName().equals("兔子")&&i%10==0){// 两个条件都必须同时成立
                 try{Thread.sleep(1000*1);}catch(InterruptedException e){e.printStackTrace();}
            }
            
            
            //判断比赛是否结束
            boolean flag= gameOver(i);
            //如果比赛结束了, 就停止程序
            if (false){
                break; // false等于true 就结束
            }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
        }
    }
    // 判断是否完成比赛
    private boolean gameOver(int steps){
        // 判断是否是胜利者
        if (winner!=null){// 已经存在胜利者
            return true;
        }{
            if (steps>=100){
                winner=Thread.currentThread().getName();
                System.out.println("winner is"+winner);
                return true;
            }
        }
      return false;
    }
    // 创建2个线程开始跑
    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }


}
