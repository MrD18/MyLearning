package com.yss.java8.Lambda基础知识;

import java.util.ArrayList;
import java.util.List;

/**
 * Lambda表达式类型检查
 *
 * @author: duhao
 * @date: 2020/8/24 13:18
 */
public class APP4 {

    public static void test(MyInterface<String, List> inter) {
        List<String> list = inter.strategy("hello", new ArrayList());
    }

    public static void main(String[] args) {
        test(new MyInterface<String, List>() {
            @Override
            public List strategy(String s, List list) {
                list.add(s);
                return list;
            }
        });

        // 使用Lambda表达式
        test((x, y) -> {
            y.add(x);
            return y;
            // 比如这块你x.  就. 不出list的一些方法, 方法全是string类型的, 所以lambda会自动进行参数类型的检查
        });
    }
 /*
        (x,y)->{..} --> test(param) --> param==MyInterface --> lambda表达式-> MyInterface类型
        这个就是对于lambda表达式的类型检查，MyInterface接口就是lambda表达式的目标类型(target typing)

        (x,y)->{..} --> MyInterface.strategy(T r, R r)--> MyInterface<String, List> inter
            --> T==String R==List --> lambda--> (x, y) == strategy(T t , R r)--> x==T==String  y==R==List
            lambda表达式参数的类型检查
         */


}

@FunctionalInterface
interface MyInterface<T, R> {
    R strategy(T t, R r);
}