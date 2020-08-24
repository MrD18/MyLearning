package com.yss.java8.Lambda基础知识;

import com.yss.java8.Lambda基础知识.Impl.IMessageFormatImpl;
import com.yss.java8.Lambda基础知识.Impl.IUserCredentialImpl;

import java.util.UUID;
import java.util.function.*;

/**
 * 测试
 *
 * @author: duhao
 * @date: 2020/8/21 15:02
 */
public class APP {
    public static <Comsumer> void main(String[] args) {


        //1. 默认方法
        IUserCredentialImpl iUserCredential = new IUserCredentialImpl();
        // 这个方法是实现了子类中的方法
        System.out.println(iUserCredential.verifyUser("admin"));
        // 实现了接口中的默认方法,不像上面的,在实现类中写了逻辑,要是其他类要有这个方法的话,还得继续写
        System.out.println(iUserCredential.getCredential("admin"));

        // 2.静态方法
        // 这一块先调用接口进行了判断, 然后才执行后面的方法
        String msg = "hello world";
        if (IMessageFormat.verifyMessage(msg)) {
            IMessageFormatImpl messageFormat = new IMessageFormatImpl();
            messageFormat.format(msg, "json");
        }
        // 3. 匿名内部类
        // 匿名内部类, 相当于重写了里面的verifyUser方法
        IUserCredential iUserCredential1 = new IUserCredential() {
            @Override
            public String verifyUser(String username) {
                return "admin".equals(username) ? "管理员" : "会员";
            }
        };
        System.out.println(iUserCredential1.verifyUser("admin"));

        // 4.Lambda表达式
        //针对上面的匿名内部类使用λ表达式,
        IUserCredential iUserCredential2 = (String username) -> {
            return "admin".equals(username) ? "λ表达式的管理员" : "λ表达式的会员";
        };
        System.out.println(iUserCredential2.verifyUser("admin"));
        System.out.println();
        System.out.println();
        System.out.println();
        //5. Java8 提供的几种函数式接口
        // 5.1 Predicate<T> 函数,收参数对象T,返回一个boolen类型的结果
        Predicate<String> pre = (String username) -> {
            return "admin".equals(username);
        };
        System.out.println(pre.test("admin"));
        System.out.println(pre.test("manger"));
        System.out.println();
        // 5.2 Consumer<T> 收参数对象T,不返回结果
        Consumer<String> con = (String msg2) -> {
            System.out.println("要发送的消息:" + msg2);
            System.out.println("发送成功....");
        };
        con.accept("λ测试函数式接口...1");
        con.accept("λ测试函数式接口...2");
        // 5.3 Function<T,R> 接收参数对象T, 返回结果对象R
        // 应用于计算
        Function<String,Integer> fun=(String gender)->{
            return "male".equals(gender)? 0:1;
        };
        System.out.println(fun.apply("male")); //0---相同就是0
        System.out.println(fun.apply("maleeeeee"));//1---不同是1
        //5.4 Supplier<T> 不接受参数, 提供T对象的创建工厂
        Supplier<String> sup=()->{
            return UUID.randomUUID().toString();
        };
        System.out.println(sup.get());
        System.out.println(sup.get());
        System.out.println(sup.get());

        //5.5 UnaryOperator<T> 接收参数对象T,返回结果对象T--对给定的变量进行处理,后返回处理后的变量
        UnaryOperator<Integer> un=(Integer a)->{
            return a+=1;
        };
        System.out.println(un.apply(1));//2
        System.out.println(un.apply(12));//13
        System.out.println(un.apply(13));//14
        System.out.println();
        System.out.println();

        //5.6 BinaryOperator<T> 接收两个T对象,返回一个T对象结果
        BinaryOperator<Integer> bin=(Integer a,Integer b)->{
         return a>b?a:b;
        };
        System.out.println(bin.apply(1,2));//2
        System.out.println(bin.apply(3,7));//7
        System.out.println(bin.apply(4,2));//4
    }
}
