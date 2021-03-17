package com.yss.other.ArrayList;



import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;

/**
 * @author: duhao
 * @date: 2021/3/11 14:14
 */
public class CollectionUtilsDemo {
    public static void main(String[] args) {

        Object o = testCollectionUtils();
        System.out.println(o);

    }

    private static Object testCollectionUtils() {
        ArrayList<Object> arrayList = new ArrayList<>();
       /* arrayList.add("测试");
        arrayList.add("CollectionUtils");*/
        if (CollectionUtil.isNotEmpty(arrayList)){
          return arrayList.get(0);
        }
        return null;
    }
}
