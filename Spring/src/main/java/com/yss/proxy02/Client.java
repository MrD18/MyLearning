package com.yss.proxy02;

import com.yss.dynamicproxy.UserSericeImpl;

/**
 * @author: duhao
 * @date: 2020/12/25 10:32
 */
// 客户调用
public class Client {
    public static void main(String[] args) {
        /*UserSericeImpl userSerice = new UserSericeImpl();
        userSerice.add();*/
        UserSericeImpl userSerice = new UserSericeImpl();
        UserPoxy userPoxy = new UserPoxy(userSerice);
        userPoxy.add(); // 代理模式将add方法 包了一层
    }
}
