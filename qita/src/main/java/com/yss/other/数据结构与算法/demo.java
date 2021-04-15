package com.yss.other.数据结构与算法;

/**
 * @author: duhao
 * @date: 2021/3/25 15:30
 */
public class demo {

    public static void main(String[] args) {
      String s="a1 123# abc";
        int count =0;
        int max=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                max=Math.max(count,max);
                count=0;
            }else {
                count++;
            }
            max=Math.max(count,max);
        }
        System.out.println(max);
    }
}
