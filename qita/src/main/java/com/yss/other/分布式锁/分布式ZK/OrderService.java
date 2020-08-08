package com.yss.other.分布式锁.分布式ZK;

/**
 * 订单业务逻辑
 *
 * @author: duhao
 * @date: 2020/7/29 14:53
 */
public class OrderService {
    private OrderNumberCreateUtil orderNumberCreateUtil = new OrderNumberCreateUtil();

    public void getOrderNumber() {
        ZKLock zkLock = new ZkDistributedLock();
        zkLock.zkLock();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkLock.zkUnLock();
        }
        System.out.println(orderNumberCreateUtil.getOrderNumber());
    }


}
