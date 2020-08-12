package com.yss.java8.Lambda表达式3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: duhao
 * @date: 2020/8/10 16:42
 */
public class ConsumerTest {

    public static void main(String[] args) {

       forEach(Arrays.asList(1,2,3,4,5), System.out::println);
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        list.forEach(System.out::println);
//
   }

    public  static <T> void  forEach(List<T> list, Consumer<T> c){
        for (T i : list) {
              c.accept(i);
        }
    }

}
