package com.yss;

import com.yss.domain.User;
import com.yss.entity.bo.AccountBO;
import com.yss.entity.dto.AccountUserDTO;
import com.yss.mapper.AccountMapper;
import com.yss.mapper.UserMapper;
import com.yss.utils.CopyUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**测试查询:
 * 1对1
 * 1对多
 * 多对多
 * @author: duhao
 * @date: 2020/12/11 13:27
 */
public class TestMybatisDao3 {




    @Test
    public void test1() throws IOException {
           //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
       //使用SqlSessionFactoryBuilder 构建SqlSessionFactory对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAllo2m();
        System.out.println(userList);
    }


    @Test
    public void test2() throws IOException {
        //获取流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //使用SqlSessionFactoryBuilder 构建SqlSessionFactory对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        List<AccountBO> accountBOList = accountMapper.findAll();
    //    List<AccountUserDTO> respList = new ArrayList<>();
        System.out.println(accountBOList);
        //没有复制成功
        List<AccountUserDTO> accountUserDTOList = CopyUtil.copyList(accountBOList, AccountUserDTO.class);

        System.out.println(accountUserDTOList);


    }


}
