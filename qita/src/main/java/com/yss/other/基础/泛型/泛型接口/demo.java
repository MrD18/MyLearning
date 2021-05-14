package com.yss.other.基础.泛型.泛型接口;

/**
 * @author: duhao
 * @date: 2021/4/22 17:28
 */
public class demo {
    public static void main(String[] args) {
        // 测试子类明确参数类型
        InterImpl inter = new InterImpl();
        inter.show("hello");
        // 测试子类不明确时
        InterImpl2<Integer> inter2 = new InterImpl2<>();
        inter2.show(100);

    }
}
