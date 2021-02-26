package com.yss.other.统一异常处理;

/**自定义异常，为了区分系统异常和更方便系统的特定一些处理
 * @author: duhao
 * @date: 2021/1/30 10:25
 */
public class MyException extends RuntimeException{
    // 错误码
    private  Integer code;

    public Integer getCode(){
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public MyException(String message) {
        super(message);
    }

    /**
     * 构造器重载，主要是自己考虑某些异常自定义一些返回码
     * @param code
     * @param message
     */
    public MyException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
