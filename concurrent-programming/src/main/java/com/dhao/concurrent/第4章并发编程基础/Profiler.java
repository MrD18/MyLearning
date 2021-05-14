package com.dhao.concurrent.第4章并发编程基础;

import java.util.concurrent.TimeUnit;

/**4.3.6 ThreadLocal的使用
 * 1. ThreadLocal 即线程变量, 以ThreadLocal对象为键,任意对象为值的存储结构
 * 2. 可以set()一个值, 在当前线程下通过get() 获取原先绑定的这个值
 * 3. 此案例是使用 Profiler类, 被复用在方法调用耗时统计上, 在方法的入口执行begin()方法. 调用后执行end()方法
 *    优点: 两个方法不用再一个方法中或者类中, 可以应用到AOP
 * 4. 在之前的项目中, 统计方法的执行时间中就有应用
 *
 * @author: duhao
 * @date: 2021/5/8 15:33
 */
public class Profiler {

    // 第一次get()方法调用时会进行初始化(如果set方法没有调用),每个线程会调用一次
  private static final  ThreadLocal<Long>  TIME_THREADLOCAL= new ThreadLocal<Long>();
     protected  Long initialValue(){
         return System.currentTimeMillis();
     }

     public static final void begin(){
         TIME_THREADLOCAL.set(System.currentTimeMillis());
     }

     public  static final Long end(){
         return System.currentTimeMillis()-TIME_THREADLOCAL.get();
     }
    public static void main(String[] args) throws InterruptedException {
            Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost:"+Profiler.end()+"mills");
    }

}
