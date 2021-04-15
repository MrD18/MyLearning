package com.yss.mybatisplugin;

import java.lang.reflect.Field;

/**
 * 定义加密接口及其实现类
 * @author: duhao
 * @date: 2021/4/12 17:07
 */
public interface EncryptUtil {


    /**
     * 加密
     *
     * @param declaredFields paramsObject所声明的字段
     * @param paramsObject   mapper中paramsType的实例
     * @return T
     * @throws IllegalAccessException 字段不可访问异常
     */
    <T> T encrypt(Field[] declaredFields, T paramsObject) throws IllegalAccessException;
}
