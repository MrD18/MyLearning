package com.yss.other.读写并发异常;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**list的这种读取后删除的情况:
 * 增强for循环会报错,   普通的循环就不会
 * 问题:
 *   1. 普通for循环 会出现遗漏元素的问题
 *         -- 因为删除元素后, 索引会自动变化,list.size()获取到list长度会更新,所以会造成漏掉被删除元素后一个索引的元素。
 *   2. 增强for循环 会报并发修改异常
 *         -- ArrayList的remove源码中,一般会走fastRemove方法,那么就会把modCount+1, 但在ArrayList返回
 *            的迭代器内部修改次数检查,发现不同, 就会报异常
 *  了解: foreach 写法实际是对Iterable, hasNext,next的简写
 * 解决方法:
 *  1. 使用迭代器时, 不要使用list的remove, 改为iterator的remove方法
 *  2. 使用迭代器删除, 也是用迭代器中的remove方法,
 *  3. 使用removeIf和方法引用
 *      JDK1.8 Collection以及其子类新加入了removeIf方法，作用是按照一定规则过滤集合中的元素。
 *      方法引用是也是JDK1.8的新特性之一。方法引用通过方法的名字来指向一个方法，
 *      使用一对冒号 :: 来完成对方法的调用，可以使语言的构造更紧凑简洁，减少冗余代码。
 *       list.removeIf("1"::equals);
 * @author: duhao
 * @date: 2020/7/20 14:58
 */
public class ListDemo {
    public static void main(String[] args) {
       List<Object> list = new ArrayList<>();
   //  List<Object> list = new Vector<>();
     list.add("1");
     list.add("2");
     list.add("3");
     list.add("4");
     // 使用 removeIf
     list.removeIf("1"::equals);
     list.forEach(System.out::println);


        Iterator<Object> iterator = list.iterator();
        // 方法 removeIf 的底层就是这个方法, 没必要自己写
           while (iterator.hasNext()){
              if ("1".equals(iterator.next())){
                  iterator.remove();
              }
           }
        list.forEach(System.out::println);

        //解决方法: 单线程使用CopyOnArrayList
//        CopyOnWriteArrayList<Object> clist = new CopyOnWriteArrayList<>();
//        clist.add("1");
//        clist.add("2");1
//        clist.add("3");
//        clist.add("4");
//        clist.add("5");
//
//        for (Object o : clist) {
//            if ("2".equals(o)){
//                clist.remove(o);
//            }
//        }
//        clist.forEach(System.out::print);

        // 多线程解决方法: 使用并发包 CopyOnWriteArrayList代替ArrayList和Vector。

    }
}
