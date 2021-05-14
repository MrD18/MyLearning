package Java并发编程基础;

/** 测试线程的状态
 * new  尚未启动
 * Runable .stat了
 * Blocked  被阻塞了
 * waiting  等待另一个线程执行特定动作
 * Time_waiting 正在等待另一个线程执行动作达到指定等待时间的线程处于此状态
 * terminated  退出
 * @author: duhao
 * @date: 2021/4/20 17:27
 */
public class StateTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("/////");
        });


        // 观察状态
        Thread.State state = thread.getState();
        System.out.println(state); // new
        // 观察启动状态
        thread.start();
        state = thread.getState();
        System.out.println(state); //runable

        while (state!=Thread.State.TERMINATED){ // 只要线程不终止,就一直输出
            Thread.sleep(1000);
            state = thread.getState(); // 更新线程状态
            System.out.println(state);
        }
    }
}
