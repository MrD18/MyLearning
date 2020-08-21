package com.yss.java8.函数式处理数据2;

/**
 * @author: duhao
 * @date: 2020/8/21 14:45
 */

/**
 * 消息传输格式化转换接口
 */
@FunctionalInterface
public interface IMessageFormat {
    /**
     * 消息转换方法
     *
     * @param message 要转换的消息
     * @param format  转换的格式[xml/json..]
     * @return 返回转换后的数据
     */
    String format(String message, String format);

    /**
     * 消息合法性验证方法
     * @param msg 要验证的消息
     * @return 返回验证结果
     */
    static boolean verifyMessage(String msg) {
    //静态方法必须有方法的实现
        if (msg != null) {
            return true;
        }
        return false;
    }
}
