package com.yss.other.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** 为了避免出现异常,使用迭代器进行删除操作
 * @author: duhao
 * @date: 2021/4/13 15:59
 */
public class ArrayListRemone {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("关羽");
        Iterator<Object> it = list.iterator();
          while (it.hasNext()){
              Object next = it.next();
              if ("关羽".equals(next)){
                  it.remove();
              }
          }
        System.out.println(list);

    }
}
