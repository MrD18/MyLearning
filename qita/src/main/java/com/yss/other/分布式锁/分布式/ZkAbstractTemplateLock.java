package com.yss.other.分布式锁.分布式;

/** ZKLock 抽象类
 * 这就是模板设计模式
 * @author: duhao
 * @date: 2020/7/29 14:14
 */
public abstract class ZkAbstractTemplateLock implements ZKLock {

    @Override
    public void zkLock() {
        // 尝试获取锁
        if (tryLock()){
            System.out.println(Thread.currentThread().getName()+"\t 占用锁成功");
        }else {
            //等待锁
            try {
                waitZKLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //重新调用获取锁的方法
           zkLock();
        }
    }

    /**
     * 定义两个抽象方法, 一个尝试锁,一个是等待锁
     */


    /**
     * 同时我们在抽象类里，又定义了两个抽象方法，zkWaitLock()  和 tryLock
     * 最后我们是具体的实现方法
     */
   public  abstract boolean tryLock();
   public  abstract void  waitZKLock() throws InterruptedException;



    @Override
    public void zkUnLock() {

    }
}
