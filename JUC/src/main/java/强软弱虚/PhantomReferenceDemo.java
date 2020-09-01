package 强软弱虚;

/**虚引用
 * @author: duhao
 * @date: 2020/6/30 13:37
 */

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 又叫幽灵引用,`java.lang.ref.PhantomReference` 类来实现
 * 与其他的引用不同,不会决定对象的生命周期
 * 有和没有一样,任何时候都会被当做垃圾回收, 不能单独使用也不能通过它访问对象,虚引用必须和引用队列ReferenceQueue联合使用。
 * 主要作用: 跟踪对象垃圾的回收状态,做些能做的事情,
 *         就是在对象被收集器回收的时候,收到系统或者后续添加进一步的处理
 *         相当于Spring AOP 中的后置通知
 * 使用场景: 回收的时候做通知相关操作
 * 需要借助引用队列: ReferenceQueue
 *     软 弱  虚 在回收之前,需要在引用队列保存一下
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        //创建引用队列
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        //创建一个弱引用
        // WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);
        //创建虚引用
        PhantomReference<Object> weakReference = new PhantomReference<>(o1, referenceQueue);
        System.out.println(o1);
        System.out.println(weakReference.get());
        o1=null;
        System.gc();
        System.out.println("执行GC操作");
         try{Thread.sleep(Integer.MAX_VALUE
         );}catch(InterruptedException e){e.printStackTrace();}
        System.out.println(o1);
        System.out.println(weakReference.get());
        //取队列中的内容
        System.out.println(referenceQueue.poll());
    }
}
/**
 * 在进行垃圾回收后,我们弱引用对象,被设置为null,但是在队列中还能够导出该引用的实例，
 * 这就说明在回收之前，该弱引用的实例被放置引用队列中了，我们可以通过引用队列进行一些后置操作
 */
