package com.yss.java8.Lambda基础知识;

/**
 * 方法重载的问题
 *
 * @author: duhao
 * @date: 2020/8/24 13:46
 */
public class App5 {
    interface Param1 {
        void outInfo(String info);
    }

    interface Param2 {
        void outInfo(String info);
    }

    // 定义重载的方法
    public void lambdaMethod(Param1 param) {
        param.outInfo("方法重载param1...");
    }

    public void lambdaMethod(Param2 param) {
        param.outInfo("方法重载param2...");

    }


    public static void main(String[] args) {
        App5 app5 = new App5();
        app5.lambdaMethod(new Param1() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });

        app5.lambdaMethod(new Param2() {
            @Override
            public void outInfo(String info) {
                System.out.println();
                System.out.println(info);
            }
        });

/* // 使用lambda报错, 原因是lambda表达式存在类型检查->自动会推导lambda表达式的目标类型
   // lambdaMethod() -> 方法 -> 重载方法
            且存在 Param1  Param2  函数式接口
            调用方法->传递Lambda表达式->自动推导识别出2个函数式接口,不能确定该用哪个
            所以,针对方法重载的参数类型都是函数式接口类型, 则需要使用匿名内部类的实现替代lambda表达式.
        app5.lambdaMethod((String info)->{
            System.out.println(info);
        });
*/
    }
}
