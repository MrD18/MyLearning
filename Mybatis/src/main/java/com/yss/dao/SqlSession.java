package com.yss.dao;

import java.util.List;

/**框架的入口
 * @author: duhao
 * @date: 2020/12/10 10:48
 */
public interface SqlSession {
    /**
     * mapperId = namespace + id
     *
     * 根据mapperId，执行sql语句，返回结果

     */

    List selectList(String mapperId);

    /**
     * 释放资源
     */
    public void close();

}
