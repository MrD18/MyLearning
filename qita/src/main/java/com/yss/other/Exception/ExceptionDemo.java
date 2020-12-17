package com.yss.other.Exception;

import lombok.extern.slf4j.Slf4j;

/**验证几个打印日志
 * @author: duhao
 * @date: 2020/11/6 11:14
 */
@Slf4j
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("开始正常");

        try {
            String str=null;
            str.length();// 将抛出异常
            System.out.println("结束正常");
        } catch (Exception e) {
            System.out.println("==========");
            log.error("出现异常2",e);
            System.out.println("=========");
            log.error("异常信息3:{}",e.getMessage());
            System.out.println("============");
            log.error("异常信息4:{}",e.getMessage(),e);
            System.out.println("=============");
            log.error("异常信息5:{}",e.getStackTrace(),e);

        } finally {
            System.out.println("最终执行");
        }


    }
}









