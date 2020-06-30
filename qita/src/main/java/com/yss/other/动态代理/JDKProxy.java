package com.yss.other.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** JDK 动态代理
 * @author: duhao
 * @date: 2020/6/29 9:34
 */

/** *  JDK 动态代理 */
public class JDKProxy implements InvocationHandler {
    // 1.需要代理的对象
    private  Object targetObject;
    // 2. 将目标对象传入进行代理
    public Object newProxy(Object targetObject){
        this.targetObject=targetObject;
        //返回代理对象
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                  targetObject.getClass().getInterfaces(),this);
    }

    // invoke 方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       // 一般我们进行逻辑处理的函数比如在这个地方进行模拟检查权限
        checkPopedom();
       //设置方法的返回值
        Object ret=null;
        //调用invoke方法.ret 存储该方法的返回值
         ret = method.invoke(targetObject, args);
        return ret;
    }

    private void checkPopedom() {
        System.out.println("======检查权限checkPopedom()======");
    }
}
