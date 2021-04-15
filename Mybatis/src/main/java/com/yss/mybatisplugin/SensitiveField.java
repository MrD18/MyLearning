package com.yss.mybatisplugin;

import java.lang.annotation.*;

/**
 *  注解敏感信息类中敏感字段的注解
 * @author: duhao
 * @date: 2021/4/12 17:06
 */

@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SensitiveField {
}
