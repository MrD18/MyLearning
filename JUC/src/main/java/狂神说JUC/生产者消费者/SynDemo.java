package 狂神说JUC.生产者消费者;

/** 我们用Synchronized 来实现生产者消费者模式
 *  1.注意资源类(属性 方法)
 *  2.资源里面的书写: 判断等待->业务->通知
 * @author: duhao
 * @date: 2021/5/12 11:13
 */
public class SynDemo {
    public static void main(String[] args) {

        A a = new A();

        new Thread(()->{

            for (int i = 0; i < 10; i++) {
                try {
                    a.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    a.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    a.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    a.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }
}

//资源类
//判断等待 业务 通知
class A{
    private int number=0;
    // +1 方法
   public synchronized  void increment() throws InterruptedException {
       // 判断  如果使用if 的话,会粗存在虚假唤醒
       while (number!=0){
           // 等待
           this.wait();
       }
       // 业务
       number++;
       System.out.println(Thread.currentThread().getName()+"=>"+number);
       // 通知其他线程, 我+1完毕了
       this.notifyAll();

   }
    // -1 方法
    public synchronized void decrement() throws InterruptedException {
      while (number==0){
         //等待
           this.wait();
       }
       // 业务
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
       //通知其他线程,我-1完毕了
        this.notifyAll();
    }
}
