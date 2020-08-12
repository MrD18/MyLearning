package com.yss.java8.Lambda表达式3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/11 13:40
 */
public class FunctionTest {
    public static void main(String[] args) {

       map(Arrays.asList("lambdas","in","action"),String::toString).forEach(System.out::print);

    }

    public  static  <T,R>  List<R> map(List<T> list,Function<T,R> f){
        List<Object> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return (List<R>) result;
    }

}

@FunctionalInterface
interface Function<T,R>{
    R apply(T t);

}