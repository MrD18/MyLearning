package 强软弱虚;

/**强引用
 * @author: duhao
 * @date: 2020/6/29 11:00
 */

/** 强引用的对象, 即便OOM了也不会进行回收,打死不回收
 * 强引用是我们最常见的普通对象引用, 只要有一个强引用指向一个对象, 就能表明对象还活着
 * 垃圾收集器不会收集
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        //定义一个强引用
        Object obj1 = new Object();
        // 使用第二个引用, 指向刚刚创建的object对象
        Object obj2=obj1;
        //置空
        obj1=null;
        //垃圾回收
        System.gc();
        System.out.println("obj1:"+obj1);
        System.out.println("obj2:"+obj2);
    }


}
/** 已经把obj1 至为null,按道理垃圾回收应该会进行回收,这是obj2 也是null,  但是并不是这样,发现obj2
 * 还是执行对象,所有没有回收掉
 * obj1:null
 * obj2:java.lang.Object@4554617c
 */