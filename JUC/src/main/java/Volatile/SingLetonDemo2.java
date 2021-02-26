package Volatile;


/**
 * Volatile Java虚拟机提供的轻量级同步机制
 * 可见性（及时通知）
 * 不保证原子性
 * 禁止指令重排
 *
 * @author: duhao
 * @date: 2020/11/4 17:07
 * <p>
 * 饿汉式 单例
 */
public class SingLetonDemo2 {
    // 定义一个对象
    private static  volatile SingLetonDemo2 instance;

    // 私有 空参构造
    private SingLetonDemo2() {
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法SingletonDemo2");
    }

    //最主要的代码逻辑
    public static SingLetonDemo2 getInstance() {
        // 业务逻辑代码
        if (instance == null) {
            // 双重检查 + 锁
            synchronized(SingLetonDemo2.class){
                if (instance == null) {
                     try{Thread.sleep(1000*1);}catch(InterruptedException e){e.printStackTrace();}
                    instance = new SingLetonDemo2();
                }
            }

        }
        return instance;
    }
    public static void main(String[] args) {
        for(int i=1;i<=10000;i++){
            new Thread(()->{
                SingLetonDemo2.getInstance();
            },String.valueOf(i)).start();
        }


    }

}
