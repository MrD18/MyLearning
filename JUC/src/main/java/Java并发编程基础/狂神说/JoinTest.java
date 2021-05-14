package Java并发编程基础.狂神说;

/** 插队方法测试
 * @author: duhao
 * @date: 2021/4/20 17:08
 *
 * 当主线程执行到i==50的时候, 子线程插队执行,直到全部执行完, 主线程才会执行
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        MyJoin myJoin = new MyJoin();

        Thread thread = new Thread(myJoin);
               thread.start();

        for (int i = 0; i < 100; i++) {
            if (i==50){
                thread.join();
            }
            System.out.println("main-->"+i);
        }
    }

}

class MyJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("子线程开始执行"+i);
        }
    }
}