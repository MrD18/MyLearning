package com.yss;

import com.yss.domain.QueryVo;
import com.yss.domain.User;
import com.yss.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author: duhao
 * @date: 2020/12/10 14:32
 */
public class TestMybatisDao {


    /*多值查询 多参数实现,值的顺序是固定的*/
    @Test
    public  void testFindByCondition4() throws IOException {

        //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 构建SqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行CRUD
        // 获取的是userDao的动态代理对象(也就是他的实现类)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
      /*
      姓名
      当前页的起始索引
      每页条数
       */
        List<User> userList= userMapper.findByCondition4("张",0,4);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }



    /*多值查询 多参数实现,值的顺序是固定的*/
    @Test
    public  void testFindByCondition3() throws IOException {

        //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 构建SqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行CRUD
        // 获取的是userDao的动态代理对象(也就是他的实现类)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
      /*
      姓名
      当前页的起始索引
      每页条数
       */
        List<User> userList= userMapper.findByCondition3("张",0,3);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }




    /*多值查询 map实现*/
    @Test
    public  void testFindByCondition2() throws IOException {

        //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 构建SqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行CRUD
        // 获取的是userDao的动态代理对象(也就是他的实现类)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
      /*
      姓名
      当前页的起始索引
      每页条数
       */
      //定义一个map来实现
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","张");
        map.put("startIndex",0);
        map.put("pageSize",3);

        List<User> userList= userMapper.findByCondition2(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }

   /*多值查询
   定义一个查询的VO*/
    @Test
    public  void testFindByCondition() throws IOException {

        //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 构建SqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行CRUD
        // 获取的是userDao的动态代理对象(也就是他的实现类)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
      /*
      姓名
      当前页的起始索引
      每页条数
       */
        QueryVo queryVo = new QueryVo();
        queryVo.setUsername("张");
        queryVo.setStartIndex(0);
        queryVo.setPageSize(7);
       List<User> userList= userMapper.findByCondition(queryVo);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }


    /*模糊查询*/
    @Test
    public  void testFindbyUsername() throws IOException {

        //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 构建SqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);  /*openSession(): 获取是不可以自动提交的SqlSession对象
                                                                    openSession(true): 获取可以自动提交的SqlSession对象*/
        // 执行CRUD
       // 获取的是userDao的动态代理对象(也就是他的实现类)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }

}
