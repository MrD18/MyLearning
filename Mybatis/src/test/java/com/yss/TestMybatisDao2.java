package com.yss;

import com.yss.domain.User;
import com.yss.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试动态sql
 * if, where, sql片段,foreach
 * @author: duhao
 * @date: 2020/12/10 19:22
 */
public class TestMybatisDao2 {




    /*update的时候,测试set标签*/
    @Test
    public  void testForEach() throws IOException {

        //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 构建SqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 执行CRUD
        // 获取的是userDao的动态代理对象(也就是他的实现类)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

     /*   List<Integer> ids= Arrays.asList(11,12);
        userMapper.delByIdList(ids);*/
        Integer[] ids= new Integer[]{10,12,13};
         userMapper.delByIdArray(ids);


    }


    /*update的时候,测试set标签*/
    @Test
    public  void testSet() throws IOException {

        //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 构建SqlSessionFactory 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 执行CRUD
        // 获取的是userDao的动态代理对象(也就是他的实现类)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User().setUsername("测试set标签2").setId(2);
                   userMapper.updateSet(user);

    }




    /*测试if标签*/
    @Test
    public  void testIf() throws IOException {

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
        User user = new User().setAge(18);
        List<User> userList= userMapper.findAge(user);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }

}
