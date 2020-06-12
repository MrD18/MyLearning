package Volatile;

/** *Volatile Java虚拟机提供的轻量级同步机制
 * 可见性（及时通知）
 * 不保证原子性
 * 禁止指令重排
 * @author: duhao
 * @date: 2020/6/11 16:38
 */
public class SingletonDemo {
    // Volatile的应用
    private static  volatile SingletonDemo instance = null;
    private SingletonDemo () {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");}
    public  static   SingletonDemo getInstance() {
   if(instance==null){
       synchronized ( SingletonDemo.class) {
           if (instance==null) {
               instance = new SingletonDemo();
           }
       }
   }
    return  instance;
    }

    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
                new Thread(()->{
                    SingletonDemo.getInstance();
                },String.valueOf(i)).start();
         }
    }
}
