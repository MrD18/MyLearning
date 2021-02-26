package com.yss;

import com.yss.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: duhao
 * @date: 2020/12/10 12:00
 */
public class TestMybatis {


    /*增加后主键回显*/
    @Test
    public  void testAddRebackKey() throws IOException {

        //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 构建SqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        /*openSession(): 获取是不可以自动提交的SqlSession对象
          openSession(true): 获取可以自动提交的SqlSession对象*/
        // 执行CRUD

        //  2.增加
        User user = new User();
        user.setUsername("主键回显");
        user.setAge(55);
        // 写入数据库中
        sqlSession.insert("com.yss.mapper.UserMapper.addRebackKey", user);
     //   System.out.println(user.getId());
        // 如果修改了数据库,必须执行提交事务
      //   sqlSession.commit();  当openSession(true)时 就可以不同在提交了
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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行CRUD
        List<User> userList = sqlSession.selectList("com.yss.mapper.UserMapper.FindbyUsername","张");
        for (User user : userList) {
            System.out.println(user);
        }
        //释放资源
        sqlSession.close();

    }


   /*更新*/
    @Test
    public  void testUpdateById() throws IOException {

        //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 构建SqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行CRUD
        User user = new User();
        user.setId(3);
        user.setUsername("改王五");
        user.setAge(6);
        sqlSession.update("com.yss.mapper.UserMapper.update",user);
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
    /*删除*/
    @Test
    public  void testDeleteById() throws IOException {

        //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 构建SqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行CRUD
        sqlSession.delete("com.yss.mapper.UserMapper.deleteById",4);
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }


  /*增加*/
    @Test
    public  void testFindAll() throws IOException {

             //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 构建SqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行CRUD

        //  2.增加
        User user = new User();
        user.setUsername("老张头");
        user.setAge(45);
        // 写入数据库中
        sqlSession.insert("com.yss.mapper.UserMapper.add",user);
        // 如果修改了数据库,必须执行提交事务
        sqlSession.commit();


      /* 1. 查询
       List<User> userList = sqlSession.selectList("com.yss.mapper.UserMapper.findAll");
        for (User user : userList) {
            System.out.println(user);
        }*/
        //释放资源
        sqlSession.close();


    }
}










