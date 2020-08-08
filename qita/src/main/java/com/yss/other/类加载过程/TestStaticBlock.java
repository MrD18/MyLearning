package com.yss.other.类加载过程;

/**
 * @author: duhao
 * @date: 2020/8/7 16:48
 */
public class TestStaticBlock {

    static{
        System.out.println("static block init");
    }




}
//自定义一个类加载器从指定磁盘目录加载类
 class MyClassLoader extends ClassLoader {
    // 破坏双亲委派
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
  // 不破坏双亲委派
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
