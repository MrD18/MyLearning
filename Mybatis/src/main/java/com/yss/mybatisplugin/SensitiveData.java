package com.yss.mybatisplugin;

import java.lang.annotation.*;

/**注解敏感信息类的注解
 * @author: duhao
 * @date: 2021/4/12 17:03
 */
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SensitiveData {
}
