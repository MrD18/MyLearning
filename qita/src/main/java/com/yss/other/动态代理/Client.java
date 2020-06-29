package com.yss.other.动态代理;

import com.yss.other.动态代理.Impl.IUserManagerImpl;

/**
 * @author: duhao
 * @date: 2020/6/29 10:01
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("**********************CGLibProxy**********************");
        CGLibProxy cgLibProxy = new CGLibProxy();
        IUserManagerImpl userManager =(IUserManagerImpl) cgLibProxy.createProxyObject(new IUserManagerImpl());
        userManager.addUser("qqwqw","12212");

        System.out.println("**********************JDKProxy**********************");
        JDKProxy jdkProxy = new JDKProxy();
        IUserManager userManagerJDK = (IUserManager) jdkProxy.newProxy(new IUserManagerImpl());
         userManagerJDK.addUser("wewwewe","123456");
    }
}
// 测试了下  不让IUserManagerImpl 实现 IUserManager   只有CGLib能实现代理
/**
 * **********************CGLibProxy**********************
 * ======检查权限checkPopedom()======
 * ======调用了UserManagerImpl.addUser()方法======
 * **********************JDKProxy**********************
 * Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to com.yss.other.动态代理.IUserManager
 * 	at com.yss.other.动态代理.Client.main(Client.java:18)
 */