package 强软弱虚;

/**软引用
 * @author: duhao
 * @date: 2020/6/29 11:20
 */

import java.lang.ref.SoftReference;

/**Java.lang.ref.SoftReference类来实现
 * 软引用,通常对内存敏感的程序中, 比如告诉缓存应用到,内存不够时回收,够时保留
 * - 当系统内存充足时，它不会被回收
 * - 当系统内存不足时，它会被回收
 */
public class SoftReferenceDemo {
    // 内存够用的时候
    public static void softRefMemoryEnough(){
        //创建一个强引用
        Object o1 = new Object();
        //创建一个软引用
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());
        o1=null;
        //手动GC
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }
    /**
     * JVM配置，故意产生大对象并配置小的内存，让它的内存不够用了导致OOM，看软引用的回收情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRefMemoryNoEnough() {
        System.out.println("=============");
    //强引用
        Object o1 = new Object();
        //软引用
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());
        o1=null;

        //模拟OOM自定GC
        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

    public static void main(String[] args) {
        softRefMemoryEnough();
        softRefMemoryNoEnough();
    }
    }
/**   我们设置的new 大对象,且将内存设置为5m  肯定会内存撑爆
 *   发现 在内存不够的时候, 软引用的  全部都回收了
 * =============
 * java.lang.Object@74a14482
 * java.lang.Object@74a14482
 * [GC (Allocation Failure) [PSYoungGen: 31K->96K(1536K)] 678K->742K(5632K), 0.0004217 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 96K->64K(1536K)] 742K->710K(5632K), 0.0002319 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 64K->0K(1536K)] [ParOldGen: 646K->643K(4096K)] 710K->643K(5632K), [Metaspace: 3358K->3358K(1056768K)], 0.0069858 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
 * [GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] 643K->643K(5632K), 0.0003366 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] [ParOldGen: 643K->625K(4096K)] 643K->625K(5632K), [Metaspace: 3358K->3358K(1056768K)], 0.0069237 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 * null
 * null
 * Heap
 *  PSYoungGen      total 1536K, used 117K [0x00000000ffe00000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 1024K, 11% used [0x00000000ffe00000,0x00000000ffe1d780,0x00000000fff00000)
 *   from space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
 *   to   space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
 *  ParOldGen       total 4096K, used 625K [0x00000000ffa00000, 0x00000000ffe00000, 0x00000000ffe00000)
 *   object space 4096K, 15% used [0x00000000ffa00000,0x00000000ffa9c560,0x00000000ffe00000)
 *  Metaspace       used 3451K, capacity 4500K, committed 4864K, reserved 1056768K
 *   class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at 强软弱虚.SoftReferenceDemo.softRefMemoryNoEnough(SoftReferenceDemo.java:46)
 * 	at 强软弱虚.SoftReferenceDemo.main(SoftReferenceDemo.java:57)
 */