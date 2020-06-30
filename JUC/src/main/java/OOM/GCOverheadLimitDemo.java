package OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: duhao
 * @date: 2020/6/30 15:37
 */
public class GCOverheadLimitDemo {
    public static void main(String[] args) {
        int i=0;
        List<String> list = new ArrayList<>();
        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println("************i:"+i);
            e.printStackTrace();
        }

    }
}
/** 发现 PSYoungGen 每次回收都未清理出空间来, 多次执行GC后,就抛出异常GC overhead limit
 *  过长的定义: 超过98%的时间都用来做GC, 并且回收不到2%的堆空间,连续多次GC都是这种情况,就抛出异常
 *  如果不抛出异常会是怎么个情况: 每次GC后的那么一点空间就被又填满,迫使在进行GC, 一直这样循环这,CPU的使用率很高,但是GC还没效果
 *
 * [Full GC (Ergonomics) [PSYoungGen: 2047K->2047K(2560K)] [ParOldGen: 7106K->7106K(7168K)] 9154K->9154K(9728K), [Metaspace: 3456K->3456K(1056768K)], 0.0367840 secs] [Times: user=0.33 sys=0.00, real=0.04 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 2047K->2047K(2560K)] [ParOldGen: 7108K->7107K(7168K)] 9156K->9155K(9728K), [Metaspace: 3456K->3456K(1056768K)], 0.0382578 secs] [Times: user=0.13 sys=0.00, real=0.04 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 2047K->0K(2560K)] [ParOldGen: 7165K->665K(7168K)] 9213K->665K(9728K), [Metaspace: 3507K->3507K(1056768K)], 0.0060503 secs] [Times: user=0.08 sys=0.00, real=0.01 secs]
 * Heap
 *  PSYoungGen      total 2560K, used 69K [0x00000000ffd00000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 2048K, 3% used [0x00000000ffd00000,0x00000000ffd116e0,0x00000000fff00000)
 *   from space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
 *   to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
 *  ParOldGen       total 7168K, used 665K [0x00000000ff600000, 0x00000000ffd00000, 0x00000000ffd00000)
 *   object space 7168K, 9% used [0x00000000ff600000,0x00000000ff6a67b8,0x00000000ffd00000)
 *  Metaspace       used 3566K, capacity 4502K, committed 4864K, reserved 1056768K
 *   class space    used 387K, capacity 390K, committed 512K, reserved 1048576K
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 * 	at java.lang.Integer.toString(Integer.java:403)
 * 	at java.lang.String.valueOf(String.java:3099)
 * 	at OOM.GCOverheadLimitDemo.main(GCOverheadLimitDemo.java:16)
 */