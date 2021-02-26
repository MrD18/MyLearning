package com.yss.other.统一异常处理;

/**异常处理实体包装类，自己用泛型进行写，扩展性强点
 * @author: duhao
 * @date: 2021/1/30 10:29
 */
public class Result<T> {
    // 返回码
    private Integer code;
    //返回消息
    private String msg;
    //返回数据
    private  T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
