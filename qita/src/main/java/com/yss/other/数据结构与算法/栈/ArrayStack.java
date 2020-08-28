package com.yss.other.数据结构与算法.栈;

import lombok.Data;

/** 基于数组实现的顺序栈
 * @author: duhao
 * @date: 2020/8/28 16:06
 */
@Data
public class ArrayStack {
    private String[] items; // 数组
    private  int count;// 栈中元素个数
    private  int n; // 栈的大小

    // 初始化数组, 申请一个大小为n的数组空间

    public  ArrayStack(int n){
        this.items= new String[n];
        this.n=n;
        this.count=0;
    }
    // 入栈操作
    public boolean push(String item){
        //判断空间是否够,不够返回fals, 入栈失败
        if (count==n){
            return false;
        }else {
            // 将item 放到下标为count的位置,并且count+1
            items[count]=item;
            ++count;
            return true;
        }
    }
    // 出栈操作
    public  String pop(){
        //判断栈是否我空,则直接返回null
        if (count==0){
            return null;
        }else {
            //返回下标为count-1的数组元素,并且栈中元素-1
            String tmp = items[count - 1];
            --count;
            return tmp;
        }
    }



}
