package com.yss.other.ArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**看看都继承了啥 实现了啥
 * @author: duhao
 * @date: 2021/2/19 15:01
 */
public class ArrayListDemo01 {

    /**
     * public class ArrayList<E> extends AbstractList<E>
     *         implements List<E>, RandomAccess, Cloneable, java.io.Serializable
     *
     *   RandomAccess:  标志接口,ArrayList支持随机访问,根本原因是底层接口是数组,可以通过元素的序号快速获取元素对象
     *   实现Cloneable接口: 覆盖函数clone(),能被克隆
     *   实现java.io.Serializable 接口: 这意味着ArrayList支持序列化，能通过序列化去传输。
     *
     *
     */

    public static void main(String[] args) {
        HashMap<String, String> map1 = new HashMap<>();

        HashMap<String, Map<String,String>> map = new HashMap<>();

        List<Object> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add("测试");

      //  map.put("现场经营",arrayList);

        System.out.println(map);


    }
}
