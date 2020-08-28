package com.yss.other.数据结构与算法.栈;

/**
 * @author: duhao
 * @date: 2020/8/28 16:18
 */
public class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
          arrayStack.push("测");
          arrayStack.push("试");
          arrayStack.push("栈");
          arrayStack.push("的");
          arrayStack.push("push");
          arrayStack.push("方法");
        System.out.println(arrayStack);
        String pop = arrayStack.pop();
        System.out.println(pop);
        System.out.println(arrayStack.pop());
    }
}
