package com.yss.other.ArrayList;

/**
 * 阅读源码的话，我们就会发现 ArrayList 中大量调用了这两个方法。比如：
 * 我们上面讲的扩容操作以及add(int index, E element)、toArray() 等方法中都用到了该方法！
 * @author: duhao
 * @date: 2021/2/22 15:09
 */
public class ArraycopyTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        /**
         * arraycopy()方法实现数组自己复制自己
         * elementData:源数组;index:源数组中的起始位置;elementData：目标数组；index + 1：目标数组中的起始位置； size - index：要复制的数组元素的数量；
         * System.arraycopy(elementData, index, elementData, index + 1, size - index);
         */
        System.arraycopy(a, 2, a, 3, 3);
        a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}

