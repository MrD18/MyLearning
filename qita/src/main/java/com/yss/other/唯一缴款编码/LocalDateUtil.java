package com.yss.other.唯一缴款编码;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 描述：LocalDate 日期工具类
 *
 * @author xinglei at 2019/7/16 17:17
 * @version 1.0.0
 */
public final class LocalDateUtil {

    /**
     * 描述：字符串转日期
     *
     * @param date    日期字符串
     * @param forment 格式
     * @return LocalDate
     * @author xinglei at 2019/7/16 17:19
     */
    public static LocalDate stringToLocalDate(String date, String forment) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(forment);
        return LocalDate.parse(date, df);
    }

    /**
     * 描述：字符串转时间
     *
     * @param date    日期字符串
     * @param forment 格式
     * @return LocalTime
     */
    public static LocalTime stringToLocalTime(String date, String forment) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(forment);
        return LocalTime.parse(date, df);
    }

    /**
     * LocalDate 转 字符串时间
     *
     * @param date 時間
     * @return 字符串时间
     */
    public static String localDateToString(LocalDate date) {
        return date.toString().replace("-", "");
    }


    /**
     * 根据传入开始和结束日期  校验 输入天数是否超过实际天数
     *
     * @param startDate 开始日期
     * @param endDate   截止日期
     * @param days      天数
     */
/*
    public static void checkDateRange(LocalDate startDate, LocalDate endDate, Long days) {

        Long thisDays = ChronoUnit.DAYS.between(startDate, endDate);
        if (thisDays.intValue() < days.intValue()) {
            throw new BusinessException("输入天数超出实际范围：" + (thisDays.intValue() + 1));
        }
    }
*/

    /**
     * 获取当前日期所在季度
     *
     * @param date 日期
     * @return 季度
     */
    public static int getQuarter(LocalDate date) {
        int month = date.getMonthValue();
        return ((month - 1) / 3 + 4) % 4 + 1;
    }

    /**
     * 获取季度起始日期
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate firstDayOfQuarter(LocalDate localDate) {
        int quarter = getQuarter(localDate);
        LocalDate date;
        if (1 == quarter) {
            date = LocalDate.parse(localDate.getYear() + "-01-01");
        } else if (2 == quarter) {
            date = LocalDate.parse(localDate.getYear() + "-04-01");
        } else if (3 == quarter) {
            date = LocalDate.parse(localDate.getYear() + "-07-01");
        } else {
            date = LocalDate.parse(localDate.getYear() + "-10-01");
        }
        return date;
    }

    /**
     * 获取季度截止日期
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate lastDayOfQuarter(LocalDate localDate) {
        int quarter = getQuarter(localDate);
        LocalDate date;
        if (1 == quarter) {
            date = LocalDate.parse(localDate.getYear() + "-03-31");
        } else if (2 == quarter) {
            date = LocalDate.parse(localDate.getYear() + "-06-30");
        } else if (3 == quarter) {
            date = LocalDate.parse(localDate.getYear() + "-09-30");
        } else {
            date = LocalDate.parse(localDate.getYear() + "-12-31");
        }
        return date;
    }

    /**
     * 获取半年起始日期
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate firstDayOfHalfYear(LocalDate localDate) {
        int month = localDate.getMonthValue();
        System.out.println("月：" + month);
        LocalDate date;
        if (6 >= month) {
            date = LocalDate.parse(localDate.getYear() + "-01-01");
        } else {
            date = LocalDate.parse(localDate.getYear() + "-07-01");
        }
        return date;
    }

    /**
     * 获取半年截止日期
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate lastDayOfHalfYear(LocalDate localDate) {
        int month = localDate.getMonthValue();
        LocalDate date;
        if (6 >= month) {
            date = LocalDate.parse(localDate.getYear() + "-06-30");
        } else {
            date = LocalDate.parse(localDate.getYear() + "-12-31");
        }
        return date;
    }

    /**
     * 校验日期当前报送范围
     *
     * @param subFrequency 频率
     * @param days         天数
     */
/*    public static void checkThisDate(String subFrequency, Long days) {
        days = days.intValue() > 0 ? days - 1L : days;
        LocalDate baseDate = LocalDate.now();

        LocalDate lastStart;
        LocalDate lastEnd;
        switch (Objects.requireNonNull(CommonSubTypeEnum.getByCode(subFrequency))) {
            case COMMON_1:
                // 默认为天
                lastStart = baseDate;
                lastEnd = baseDate;
                break;
            case COMMON_2:
                lastStart = baseDate.with(DayOfWeek.MONDAY);
                lastEnd = baseDate.with(DayOfWeek.SUNDAY);
                break;
            case COMMON_3:
                lastStart = baseDate.with(TemporalAdjusters.firstDayOfMonth());
                lastEnd = baseDate.with(TemporalAdjusters.lastDayOfMonth());
                break;
            case COMMON_4:
                lastStart = LocalDateUtil.firstDayOfQuarter(baseDate);
                lastEnd = LocalDateUtil.lastDayOfQuarter(baseDate);
                break;
            case COMMON_5:
                lastStart = LocalDateUtil.firstDayOfHalfYear(baseDate);
                lastEnd = LocalDateUtil.lastDayOfHalfYear(baseDate);
                break;
            case COMMON_6:
                lastStart = baseDate.with(TemporalAdjusters.firstDayOfYear());
                lastEnd = baseDate.with(TemporalAdjusters.lastDayOfYear());
                break;
            default:
                // 默认校验以为天
                lastStart = baseDate.with(TemporalAdjusters.firstDayOfYear());
                lastEnd = baseDate.with(TemporalAdjusters.lastDayOfYear());
        }
        checkDateRange(lastStart, lastEnd, days);
    }*/
}
