package com.yss.dao.Impl;

import com.yss.dao.SqlSession;
import com.yss.domain.Configuration;
import com.yss.domain.Mapper;
import com.yss.utils.Executor;

import java.util.List;


/**
 * @author: duhao
 * @date: 2020/12/10 10:54
 */
public class SqlSessionImpl implements SqlSession {

      private Configuration cfg;

       private Executor executor;

       // 添加构造方法, 用就需要传参
    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
    }

    @Override
    public List selectList(String mapperId) {
        // 根据mapperId获取Mapper对象(返回值和Sql语句)
        Mapper mapper = cfg.getXmMap().get(mapperId);
        String resultType = mapper.getResultType();
        String sql = mapper.getSql();
        //调用工具类执行sql语句
        return executor.executeQuery(resultType,sql);
    }

    @Override
    public void close() {
        executor.close();
    }
}
