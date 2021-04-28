package Java并发编程基础.狂神说.生产者消费者;

/**
 * 测试生产者消费者: 信号灯法, 标志位解决
 *
 * @author: duhao
 * @date: 2021/4/22 15:10
 */
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者--->演员
class Player extends Thread {
    TV tv;
    public Player(TV tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                tv.play("快了大本营录制中..");
            }else {
                tv.play("抖音:正在录制中...");
            }
        }

    }
}

//消费者-->观众
class Watcher extends Thread {
    TV tv;
    public Watcher(TV tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }

    }
}
// 产品-->节目

class TV {
    // 演员表演, 观众等待  T
    // 观众观看,演员等到  F
    String voice; // 表演节目
    boolean flag = true;

    // 表演
    public synchronized void play(String voice) {

        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了:" + voice);
        // 通知观众观看
        this.notifyAll();// 通知唤醒
        this.voice = voice;
        this.flag = !this.flag;  // 取反
    }

    // 观看
    public synchronized void watch() {

        if (flag) { // flag等于真, 还没有表演, 就等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了:" + voice);
        // 看完了,通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }
}