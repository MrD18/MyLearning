package com.yss.other.Hutool;

import cn.hutool.core.util.ReflectUtil;
import com.yss.other.动态代理.JDKProxy;

import java.lang.reflect.Method;

/**ReflectUtil
 * Java反射工具类，可用于反射获取类的方法及创建对象。
 * @author: duhao
 * @date: 2020/7/13 17:16
 */
public class TestReflectUtil {
    public static void main(String[] args) {
        //获取某个类的所有方法
        Method[] methods = ReflectUtil.getMethods(JDKProxy.class);
        for (Method method : methods) {
            System.out.println(method);
        }

        // 获取某个类的指定方法
        Method method = ReflectUtil.getMethod(JDKProxy.class, "checkPopedom");
        System.out.println(method);
        // 使用反射来创建对象
        JDKProxy jdkProxy = ReflectUtil.newInstance(JDKProxy.class); // 就可以调里面的方法了
      // 反射执行对象方法
        ReflectUtil.invoke(jdkProxy,"setID",1);// 这个类中没有这个方法, 可以使用其他

    }
}
