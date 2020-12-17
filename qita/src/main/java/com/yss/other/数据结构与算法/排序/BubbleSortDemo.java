package com.yss.other.数据结构与算法.排序;

import java.util.Arrays;

/**冒泡排序
 * @author: duhao
 * @date: 2020/9/9 17:40
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] ints = new int[6];
          ints[0]=2;
          ints[1]=1;
          ints[2]=5;
          ints[3]=3;
          ints[4]=7;
          ints[5]=8;
        Arrays.stream(ints).forEach(System.out::print);
        System.out.println();
     bubbleSort(ints,5);
       Arrays.stream(ints).forEach(System.out::print);


    }


    // 冒泡排序，a表示数组，n表示数组大小
    public  static  void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) {
                break;  // 没有数据交换，提前退出
            }
        }
    }
}