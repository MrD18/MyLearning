package com.yss.other.分布式锁.分布式;

/**模板模式:
 * 我们首先定义一个zkLock的接口
 * @author: duhao
 * @date: 2020/7/29 14:10
 */
public interface ZKLock {
    public  void zkLock();
    public  void  zkUnLock();
}
