package com.yss.other.基础.泛型.泛型接口;

/**子类明确泛型类的类型参数变量:
 * @author: duhao
 * @date: 2021/4/22 17:24
 */
public class InterImpl implements Inter<String> {
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}
