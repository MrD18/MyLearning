package com.yss.other.布隆过滤;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**redis缓存穿透-布隆过滤器
 * 缓存穿透问题: 访问redis中,没有,直接跳过redis 去查数据库,产生穿透问题
 * 解决方法:我们让查这条数据,我们让该key缓存一空数据,这样再次以该key请求后台的时候,会直接返回null,
 * 避免再次请求数据库
 *布隆过滤器:
 * 作用" 迅速判断一个元素是否存在一个集合中,将所有数据缓存到布隆过滤器中,当黑客访问不存在的时候,
 * 迅速返回避免DB挂掉
 *
 * 原理: 当一个元素被加入集合时,通过k个散列函数将这个元素映射成一个位数组中的K个点,把他们置为1,
 * 检索时, 我们只要看这些点是不是都是1,  1就代表有, O代表肯定没有
 *
 * @author: duhao
 * @date: 2020/7/10 13:34
 */
public class BloomFilterDemo {
    private static  int size=1000000; //预计要插入的数
    private  static  double fpp=0.01; // 期望的误判率
    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, fpp);

    public static void main(String[] args) {
        //插入数据
        for (int i = 0; i < 1000000; i++) {
            bloomFilter.put(i);
        }
        int count = 0;
        for (int i = 1000000; i < 2000000; i++) {
             if (bloomFilter.mightContain(i)){
                  count++;
                 System.out.println(i+"误判了");
             }
        }
        System.out.println("总共的误判数:"+count);

    }
}
/**
 * 现在有100万不存在的数据, 误判了10314次, 计算下误判率
 * 10314/10000000=0.010314
 *
 * 我们之前设定的误判率为0.01
 */