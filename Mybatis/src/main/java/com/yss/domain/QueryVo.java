package com.yss.domain;

import lombok.Data;

/**查入的值对象,都要查那些值都封装到一块
 * @author: duhao
 * @date: 2020/12/10 15:48
 */
@Data
public class QueryVo {
    //姓名
    private  String username;
    //当前页的起始索引
    private  Integer startIndex;
    //每页条数
    private  Integer pageSize;
}
