package com.yss.java8.函数式处理数据2.Impl;

import com.yss.java8.函数式处理数据2.IMessageFormat;

/**
 * @author: duhao
 * @date: 2020/8/21 15:43
 */
public class IMessageFormatImpl implements IMessageFormat {
    @Override
    public String format(String message, String format) {
        System.out.println("消息的转换...");
        return message;
    }
}
