package 强软弱虚;

/**软引用和弱引用的使用场景
 * @author: duhao
 * @date: 2020/6/30 13:21
 */

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * 场景: 假如有一个应用需要读取大量的本地图片
 * - 如果每次读取图片都从硬盘读取则会严重影响性能
 * - 如果一次性全部加载到内存中，又可能造成内存溢出
 *此时使用软引用可以解决这个问题
 * 设计思路：使用HashMap来保存图片的路径和相应图片对象关联的软引用之间的映射关系，
 * 在内存不足时，JVM会自动回收这些缓存图片对象所占的空间，从而有效地避免了OOM的问题
 *
 * Map<String, SoftReference<String>> imageCache = new HashMap<String, SoftReference<Bitmap>>();
 */
// WeakHashMap和HashMap类似, 只不过key是使用软引用, 也就会说,当执行GC的时候,HashMap中的key会进行回收
public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value="WeakHashMap";
        map.put(key,value);
        System.out.println(map);
        key=null;
        System.gc();
        System.out.println(map);
    }

    private static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value="HashMap";
        map.put(key,value);
        System.out.println(map);
        key=null;
        System.gc();
        System.out.println(map);
    }
}
/**
 * 从这里我们看到，对于普通的HashMap来说，key置空并不会影响，HashMap的键值对，因为这个属于强引用，不会被垃圾回收。
 * 但是WeakHashMap，在进行GC操作后，弱引用的就会被回收
 */
