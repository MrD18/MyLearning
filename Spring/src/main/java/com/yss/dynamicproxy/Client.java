package com.yss.dynamicproxy;

/**
 * @author: duhao
 * @date: 2020/12/25 11:46
 */
public class Client {
    public static void main(String[] args) {
        //真是角色
        UserSericeImpl userSerice = new UserSericeImpl();
        //代理角色-- 生成的
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 通过调用程序处理角色来处理我们要调用的接口对象
        pih.setTarget(userSerice);
        // 动态生成代理类
        UserService proxy = (UserService) pih.getProxy(userSerice);
        //调用方法
         proxy.add();


         
    }
}
