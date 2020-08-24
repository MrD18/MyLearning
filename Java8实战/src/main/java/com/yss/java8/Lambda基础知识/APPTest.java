package com.yss.java8.Lambda基础知识;

/**反编译测试
 * @author: duhao
 * @date: 2020/8/24 14:18
 */
public class APPTest {

    public static void main(String[] args) {
        IMarkUp mu=(message)-> System.out.println(message);
        mu.markUp("Lambda测试....");

    }
}
interface IMarkUp{
    void markUp(String msg);
}