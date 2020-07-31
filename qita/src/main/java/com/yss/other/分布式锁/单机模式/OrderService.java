package com.yss.other.分布式锁.单机模式;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 订单业务逻辑
 * @author: duhao
 * @date: 2020/7/29 13:36
 */
public class OrderService {
  private OrderNumberCreateUtil orderNumberCreateUtil=  new OrderNumberCreateUtil();
// 为了避免1订单出现2次,进行加锁处理

    public String getOrderNumber() {

//        synchronized(this){
//            return orderNumberCreateUtil.getOrderNumber();
//        }
        Lock lock= new ReentrantLock();
         lock.lock();
        /**
         * 复习前面的知识: ReentrantLock 相比于Synchronized
         *  lock.newCondition(条件); //指定唤醒某一个线程
         *  lock.lockInterruptibly();// 中断等待锁的线程机制
         */


        try {
            return orderNumberCreateUtil.getOrderNumber();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
 return null;
    }
}
