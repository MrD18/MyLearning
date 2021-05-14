package com.yss.other.基础.泛型.泛型接口;

/**子类不明确
 *子类不明确泛型类的类型参数变量:实现类也要定义出<T>类型的
 * @author: duhao
 * @date: 2021/4/22 17:25
 */
public class InterImpl2<T> implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
