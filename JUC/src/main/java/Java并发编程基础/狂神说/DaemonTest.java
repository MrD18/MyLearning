package Java并发编程基础.狂神说;

/**守护线程测试:
 * 1.线程分为用户线程和守护线程
 * 2.虚拟机必须确保用户线程执行完毕,后才会停止守护线程
 * @author: duhao
 * @date: 2021/4/21 10:32
 */
public class DaemonTest {

    public static void main(String[] args) {

        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认是false表示是用户线程,正常都是用户线程
        thread.start();// 开始守护线程

        new Thread(you).start();
    }


}

// 守护线程 god
class God implements Runnable {

    @Override
    public void run() {
        System.out.println("上帝线程一直守护着你...");
    }
}

// 用户线程 你
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 360; i++) {
        //     try{Thread.sleep(1000*1);}catch(InterruptedException e){e.printStackTrace();}
            System.out.println("你开开心心的活着...");
        }
        System.out.println("你挂了....");
    }
}