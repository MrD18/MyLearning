package com.yss.other.基础.泛型.类型通配符;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果在方法上传一个List
 * @author: duhao
 * @date: 2021/4/22 17:34
 */
public class Demo {
       // 通配符的使用
    public void test1(List<?> list){ //(List<Object> list, 那么该test()方法只能遍历装载着Object的集合
         // 泛型中的<Object>并不是像以前那样有继承关系的，也就是说List<Object>和List<String>是毫无关系的！！！！
        for (Object o : list) {
            System.out.println(o);
        }
    }
     //设定通配符上限 List<? extends Number> list:List集合装载的元素只能是Number的子类或自身
    public void test2(List<? extends Number> list){

    }

    public static void main(String[] args) {
        List<String> arrayList1 = new ArrayList<>();
        arrayList1.add("1");
        arrayList1.add("2");
        arrayList1.add("测试");
        Demo demo = new Demo();
        demo.test1(arrayList1);
        //List集合装载的是Integer，可以调用该方法
        List<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        demo.test2(arrayList2);
        //List集合装载的是String，在编译时期就报错了
        List<String> strings = new ArrayList<>();
        strings.add("1");
      //  demo.test2(strings);
    }
}
