package com.yss.java8.Lambda表达式3;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * @author: duhao
 * @date: 2020/8/12 16:54
 */
public class testAll {

    public static void main(String[] args) {

        sortString();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
          int predicate1 =  3;

        BiPredicate<List<Integer>, Integer> contains = List::contains;
        System.out.println( contains.test(list,predicate1));


    }
    // 使用λ 排序
    private static void sortString() {
        List<String> stringList = Arrays.asList("a", "b", "A", "B");
        stringList.sort(String::compareToIgnoreCase);
        stringList.forEach(System.out::println);
    }
}
