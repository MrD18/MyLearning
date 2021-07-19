package com.yss.other.yunzhihui;

import java.lang.annotation.*;

/**
 * @Author: dhao
 * @Date: 2021/6/8 6:27 下午
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SensitiveInfo {
    public SensitiveUtils.sensitiveType type();
}
