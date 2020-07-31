package com.yss.other.Hutool;

import cn.hutool.core.map.MapUtil;

import java.util.Map;

/**Map操作工具类，可用于创建Map对象及判断Map是否为空。
 * @author: duhao
 * @date: 2020/7/13 17:53
 */
public class TestMapUtil {
    public static void main(String[] args) {
        //将多个键值对加入到Map中
        Map<Object, Object> map = MapUtil.of(new String[][]{
                {"key1", "value1"},
                {"key2", "value2"},
                {"key3", "value3"}
        });
//判断Map是否为空

        System.out.println(MapUtil.isEmpty(map));//false
        System.out.println(MapUtil.isNotEmpty(map));//true

    }
}
