package com.yss.other.时间与日期;

import org.junit.Test;

import java.time.LocalDate;

/**
 * @author: duhao
 * @date: 2020/8/20 16:40
 */
public class DateTest {

    @Test
    public void testDate01() {
        // 获取今年的天数
        int daysOfThisYear1 = LocalDate.now().lengthOfYear();
        System.out.println(daysOfThisYear1);
        // 获取指定天数
        int daysOfThisYear2 = LocalDate.of(2011, 1, 1).lengthOfYear();
        System.out.println(daysOfThisYear2);
    }

}
