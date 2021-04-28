package Java并发编程基础.狂神说.生产者消费者;

/**
 * 管程法
 *
 * 使用Object中提供的  wait()/ notifyAll()
 * @author: duhao
 * @date: 2021/4/22 14:18
 */
// 生产者,消费者, 产品, 缓冲区
public class TestPC {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();

       new Productor(container).start();
      new Consumer(container).start();
        new Consumer(container).start();

    }

}

//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
         this.container=container;
    }
    //生产
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            //生产第i只鸡
            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container=container;
    }
    // 消费
    @Override
    public void run() {
       //消费掉这100只鸡
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+"消费了-->"+container.pop().id+"只鸡");
        }
    }
}
// 产品
class Chicken{
    int id; // 产品编号

    public Chicken(int id) {
        this.id = id;
    }
}
// 缓冲区
class SynContainer{
      // 需要一个容器大小
    Chicken[] chickens = new Chicken[10];
     // 容器计数器
    int count=0;
     // 生产者放入产品
    public synchronized void push(Chicken chicken){
        // 如果容器满了, 需要等待消费者来消费
        while (count==chickens.length){
            // 通知消费者消费,生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果没有满, 我们需要丢入产品
        chickens[count]=chicken;
        count++;
        // 可以通知消费者消费
        this.notifyAll();

    }

    // 消费者消费产品
    public  synchronized Chicken pop(){
        //判断能否消费
        while ( count==0){
            //等待生产者生产, 消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果可以消费
        count--;
        Chicken chicken = chickens[count];
        // 吃完了,通知生产者生生产
        this.notifyAll();
        return chicken;
    }












}

