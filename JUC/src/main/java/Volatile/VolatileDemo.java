package Volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * Volatile Java虚拟机提供的轻量级同步机制
 *
 * 可见性（及时通知）
 * 不保证原子性
 * 禁止指令重排
 *
 * @author: duhao
 * @date: 2020/6/11 15:00
 */
public class VolatileDemo {
    /**
     * 验证可见性
     */
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 开始了");
            // 睡上3秒
            try{Thread.sleep(1000*3);}catch(InterruptedException e){e.printStackTrace();}
                     myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t 修改了值:"+myData.number);
                },"AAA").start();
        while (myData.number==0){
           // 等于0 说明主线程拿到的内存中的数字是0 ,另一个线程已经改为了60,没有写会主内存中
            }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}
/*
 设置主内存
 */
class MyData{
       volatile int number =0;// 加上volatile 就能写会主内存,主线程拿到不为0,跳出循环
;

      public void addTo60(){
          this.number=60;
      }
      // 不保证原子性
   public void addPlusPlus(){
          number++;
   }
    /**
     *  创建一个原子Integer包装类，默认为0
     */
    AtomicInteger atomicInteger = new AtomicInteger();
  public void  addAtomic(){
      // 相当于 atomicInteger ++
      atomicInteger.getAndIncrement();

  }

}