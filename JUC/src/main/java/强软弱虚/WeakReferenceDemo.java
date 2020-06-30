package 强软弱虚;

import java.lang.ref.WeakReference;

/**弱引用
 * 不管内存是否够用, 只要有GC操作就会进行回收
 * 弱引用需要用 `java.lang.ref.WeakReference` 类来实现，它比软引用生存期更短
 * 对于只有弱引用的对象来说，只要垃圾回收机制一运行，不管JVM的内存空间是否足够，都会回收该对象占用的空间。
 * @author: duhao
 * @date: 2020/6/30 13:16
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        o1=null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
/**内存并没有溢出  ,只要存在gc 的动作,就会将弱引用进行回收
 * java.lang.Object@4554617c
 * java.lang.Object@4554617c
 * null
 * null
 */