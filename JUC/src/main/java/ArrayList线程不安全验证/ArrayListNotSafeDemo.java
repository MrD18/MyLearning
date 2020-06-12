package ArrayList线程不安全验证;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: duhao
 * @date: 2020/6/11 11:10
 * 出现并发修改异常：java.util.ConcurrentModificationException
 * 解决方法：
 *   1. 使用 Vector  底部使用  public synchronized boolean add(E e) {}
 *   2. 使用Collections 工具类 调用加锁的方法 Collections.synchronizedList
 *   3. 使用juc 并发包CopyOnWriteArrayList<>()
 */
public class ArrayListNotSafeDemo {
    public static void main(String[] args) {
        // 单线程下
//       List<String> list = new ArrayList<>();
//            list.add("a");
//            list.add("b");
//            list.add("c");
//             list.forEach(System.out::print);

        // 多线程下 测试
        // 报错： java.util.ConcurrentModificationException  并发修改异常
//        List<String> list = new Vector<>();
//        List<Object> list = Collections.synchronizedList(new ArrayList<>());
//        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();
//        for(int i=1;i<=30;i++){
//                 new Thread(()->{
//              list.add(UUID.randomUUID().toString().substring(0,8));
//               System.out.println(list);
//                 },String.valueOf(i)).start();
//          }
//----------------------------------------------------------------------------------------------
         // 看一下Hashset,底层就是HashMap， 肯定不安全， 至于为什么只有key 而不存value, 因为value
         // 存储的是一个object类型的常量值，
         // 解决方法：
         //   1.    Collections.synchronizedSet(new HashSet<>());
        //   2.new CopyOnWriteArraySet<>() ，底层 al = new CopyOnWriteArrayList<E>();
        Set<Object> hashSet = new HashSet<>();
        Set<Object> set1 = Collections.synchronizedSet(new HashSet<>());
        CopyOnWriteArraySet<Object> set = new CopyOnWriteArraySet<>();

        //-------------------------------------------------------------------------------
        /*
            HashMap是不安全问题
          1. Collections.synchronizedMap(new HashMap<>());
          2. new ConcurrentHashMap<>();
         */

     //   Map<Object, Object> map= Collections.synchronizedMap(new HashMap<>());
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        for(int i=1;i<=20;i++){
                     new Thread(()->{
                        map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                         System.out.println(map);
                        },"Thread:"+i).start();
              }

    }

}
