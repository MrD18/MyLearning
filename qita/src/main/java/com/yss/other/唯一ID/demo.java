package com.yss.other.唯一ID;

import cn.hutool.core.util.IdUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: duhao
 * @date: 2021/4/8 13:37
 */
public class demo {

    public static void main(String[] args) {
        String s = unRepeatSixCode();
        System.out.println(s);
        long id = getId();
        System.out.println(id);
        String stringID = getStringID();
        System.out.println(stringID);
    }


    /**使用了 hutool
     *  String serialNumber = IdUtil.simpleUUID();
     * @return
     *
     */
    public static String getStringID(){

        String serialNumber = IdUtil.simpleUUID();
        return serialNumber;
    }

    public static long getId(){
          int inc = 0;
        long id = Long.parseLong(String.valueOf(System.currentTimeMillis())
                .substring(1,10)
                .concat(String.valueOf(inc)));
        inc = (inc+1)%10;
        return id;
    }


    /**字符串
     * 生成一个6位不可重复的字符编码是：L48DeV
     * L48DeV
     * @return
     */
    public static String unRepeatSixCode() {
        String sixChar = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        Date date = new Date();
        String time = sdf.format(date);
        for (int i = 0; i < time.length() / 2; i++) {
            String singleChar;
            String x = time.substring(i * 2, (i + 1) * 2);
            int b = Integer.parseInt(x);
            if (b < 10) {
                singleChar = Integer.toHexString(Integer.parseInt(x));
            } else if (b >= 10 && b < 36) {
                singleChar = String.valueOf((char) (Integer.parseInt(x) + 55));
            } else {
                singleChar = String.valueOf((char) (Integer.parseInt(x) + 61));
            }
            sixChar = sixChar + singleChar;

        }
        System.out.println("生成一个6位不可重复的字符编码是：" + sixChar);
        return sixChar;

    }
}