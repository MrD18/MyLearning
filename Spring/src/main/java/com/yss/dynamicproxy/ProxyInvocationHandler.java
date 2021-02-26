package com.yss.dynamicproxy;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**会中这个类自动生成代理类,
 * 动态代理工具类
 * @author: duhao
 * @date: 2020/12/25 11:37
 */
@Data
public class ProxyInvocationHandler implements InvocationHandler {

         // 被代理的对象
    private Object target;
    /*生成代理类的方法*/
    public  Object getProxy(Object target){
        /**
         * ClassLoader loader 类加载器
         * Class<?>[] interfaces  这个接口
         * InvocationHandler
         */
       return   Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    /*处理代理实例,并返回结果*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 切面中添加日志
        log(method.getName());
        // 动态代理的本质， 就是使用反射机制实现！
        Object result = method.invoke(target, args);
        return result;
    }

    /*代理类中自己的方法*/
    public void log(String msg){
        System.out.println("日志功能:执行了"+msg+"方法");
    }
}
