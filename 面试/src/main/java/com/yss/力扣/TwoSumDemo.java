package com.yss.力扣;

import java.util.HashMap;
import java.util.Map;

/**给定一个数组nums和一个目标值target,请在该数组中找出和为目标值的那两个整数,并返回他们的数组下标
 * nums=[2,7,11,15], target =9
 * nums[0]+nums[1]=2+7=9
 * 返回[0,1]
 *
 * @author: duhao
 * @date: 2020/12/9 16:39
 */
/*传统双循环解决  时间复杂度:O(n)2*/
public class TwoSumDemo {
     public static int[] twoSum1(int[]nums,int target){
         for (int i = 0; i < nums.length; i++) {
             for (int j = 0; j < nums.length; j++) {
                  if (target-nums[i]==nums[j]){
                      return new int[]{i,j};
                  }
             }
         }
          return null;
     }

     // 哈希(更优解法)
    public static int[] twoSum2(int[]nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
                 int param=target-nums[i];//2  7
            // 如果这个map中含有这个key
            if (map.containsKey(param)){
                //有就
                 return new int[]{map.get(param),i};
            }
            // 没有就放入这个map中
            //  k值   v下标
            //  2     i
             map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,7,11,15};
        int target=9;
        int[] ints = twoSum2(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }


    }


}
