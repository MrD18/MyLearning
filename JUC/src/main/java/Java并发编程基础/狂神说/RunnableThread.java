package Java并发编程基础.狂神说;

/** 建议实现Runnable接口, 避免单继承的局限性, 方便同一个对象被多个线程使用
 * @author: duhao
 * @date: 2021/4/16 17:17
 */
public class RunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("...子线程...."+i);
        }
    }


    public static void main(String[] args) {

        RunnableThread runnableThread = new RunnableThread();
        new Thread(runnableThread).start();

        for (int i = 0; i < 200; i++) {
            System.out.println("主线程..."+i);
        }
    }
}
