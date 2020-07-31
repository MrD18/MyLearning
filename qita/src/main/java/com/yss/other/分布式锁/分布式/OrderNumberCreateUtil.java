package com.yss.other.分布式锁.分布式;

/**订单生成工具类
 * @author: duhao
 * @date: 2020/7/29 13:35
 */
public class OrderNumberCreateUtil {
    private static int num = 0;

    public String getOrderNumber() {
        return "\t 生成订单号：" + (++num);
    }


}
