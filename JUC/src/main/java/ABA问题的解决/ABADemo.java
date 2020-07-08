package ABA问题的解决;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;

/**ABA问题的描述:
 *  CAS导致ABA问题的产生, CAS算法实现的前提就是,需要从主存中取出某时刻的数据,
 *   并在当下的时刻比较并替换, 这个时间差引出了一系列问题!!!1
 *
 *   线程one 从主存V中取出A, 线程two也从主存中取A, 然后,one将A变为B,在将B又变回A,
 *   这个时候two进行CAS操作时,发现主存中扔是A, 然后线程two操作成功!
 *   这个过程中 主存中的数据A 已经被修改了一次,但是two并不知道
 *   解决问题: AtomicStampedReference
 * @author: duhao
 * @date: 2020/7/8 13:23
 */
public class ABADemo {
    /**
     * 解决ABA问题,引入时间戳,
     * AtomicStampedReference,用于变版本的更新
     */
    // 普通的原子包装
    static AtomicReference<Integer> atomicReference =new AtomicReference<>(100);
    // 带版本的 传递2个值,一个是初始值,一个是初始版本号
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        System.out.println("===ABA问题的产生===");

        new Thread(() -> {
                  // A线程改101,在改回来   也就是ABA问题
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
                }, "t1").start();

        new Thread(() -> {
                   // 睡1s 保证A能完成 ABA
                   try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
                      atomicReference.compareAndSet(100,2020);
            System.out.println(atomicReference.get());
                }, "t2").start();

        System.out.println("===================ABA问题的解决====");
        
        new Thread(() -> {     
                  // 获取版本号
             try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}

            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号:"+stamp);
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
           // 再次获取版本号
            System.out.println(Thread.currentThread().getName()+"\t 第二次版本号:"+atomicStampedReference.getStamp());
          //改回去
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
          //第三次版本号
            System.out.println(Thread.currentThread().getName()+"\t 第三次版本号"+atomicStampedReference.getStamp());
            }, "t3").start();


        new Thread(() -> {
            // 获取版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号:"+stamp);
            // 暂停3s 保证C 能实现ABA
             try{Thread.sleep(1000*3);}catch(InterruptedException e){e.printStackTrace();}
            boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+"\t 修改成功否:"+result+"\t 当前最新版本号:"+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t 当前实际最值:"+atomicStampedReference.getReference());

        }, "t4").start();

    }
}
/**
 * 我们能够发现，线程t3，在进行ABA操作后，版本号变更成了3，
 * 而线程t4在进行操作的时候，就出现操作失败了，因为版本号和当初拿到的不一样
 *===ABA问题的产生===
 * ===================ABA问题的解决====
 * t4	 第一次版本号:1
 * 2020
 * t3	 第一次版本号:1
 * t3	 第二次版本号:2
 * t3	 第三次版本号3
 * t4	 修改成功否:false	 当前最新版本号:3  --------修改不了
 * t4	 当前实际最值:100
 */