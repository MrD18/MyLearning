package com.yss.other.数据结构与算法.二分查找;

/**
 * @author: duhao
 * @date: 2021/3/18 17:33
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] array = { 30,20,50,10,80,9,7,12,100,40,8};
        int num= 11;
        int searchWord=12;
        int i = binarySearch(array, num, searchWord);
        System.out.println(searchWord+"元素的索引:"+i);
    }

    /**
     *
     * @param array 待查序列
     * @param n  序列中的元素个数
     * @param target  要查的目标元素
     * @return 目标元素在序列中的索引或-1
     */
    static int binarySearch(int array[], int n, int target){
      /**
       * 定义并初始化low和high  声明mid
       */
      int low=0;
      int high=n-1;
      int mid;
      /**
       * 如果low小于或等于high,则说明待查询序列不为空
       * 需要将其中间元素和目标元素进行匹配
       */
      while (low<=high){
          // 计算中间元素的索引
          mid=(low+high)/2;
          if (array[mid]==target){
              // 查找成功,返回该中间元素的索引
              return mid;
          }else if (array[mid]>target){
              high=mid-1;
          }else {
              // array[mid]< target
              low=mid+1;
          }
      }
 // 没有匹配上元素
return -1;
  }

}
