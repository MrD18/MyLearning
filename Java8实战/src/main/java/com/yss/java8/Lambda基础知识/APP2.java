package com.yss.java8.Lambda基础知识;

/**
 * Lambda表达式测试
 *
 * @author: duhao
 * @date: 2020/8/21 17:08
 */
public class APP2 {
    public static void main(String[] args) {

        // 1.没有参数,没有返回值的接口
        ILambda i1 = () -> {
            System.out.println("测试Lambda表达式,没有参数+执行代码块有多行的写法");
            System.out.println("测试Lambda表达式,没有参数+执行代码块有多行的写法...");
        };
        i1.test();

        ILambda i2 = () -> System.out.println("测试Lambda表达式,没有参数+执行代码块只有一行的写法");
        i2.test();

        //2.有参数, 没有返回值的接口
        ILambda2 i3 = (String name, int age) -> {
            System.out.println("姓名是:" + name + " 年龄是:" + age);
        };
        i3.test("dddd", 28);

        // 3. 有参数,有返回值
        ILambda3 i4 = (a, b) -> {
            int z = a + b;
            return z;
        };
        System.out.println(i4.test(1, 3));

        // 简化后的写法
        ILambda3 i5 = (a, b) -> a + b;
        System.out.println(i5.test(100, 200));
    }

}


// 1.定义一个没有参数没有返回值的接口
interface ILambda {
    void test();
}

// 2.有参数, 没有返回值的接口
interface ILambda2 {
    void test(String name, int age);
}

// 3. 有参数,有返回值
interface ILambda3 {
    Integer test(int a, int b);

}