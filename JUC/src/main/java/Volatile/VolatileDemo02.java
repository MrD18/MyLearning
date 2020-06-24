package Volatile;

/** * Volatile Java虚拟机提供的轻量级同步机制
 *
 * 可见性（及时通知）
 * 不保证原子性
 * 禁止指令重排
 *
 * @author: duhao
 * @date: 2020/6/11 15:37
 */
public class VolatileDemo02 {
    /**
     * 验证原子性问题
     */
    public static void main(String[] args) {
        MyData myData = new MyData();
        // 创建20个线程, 线程里面进行1000次循环
        for(int i=1;i<=20;i++){
               new Thread(()->{
                   for (int j = 0; j < 1000; j++) {
                       myData.addPlusPlus();
                       myData.addAtomic();
                   }
               },"Thread:"+i).start();   
        }
        while (Thread.activeCount()>2){
            // yield 表示不执行
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t finally number value:"+myData.atomicInteger);
    }
}

