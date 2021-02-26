package com.yss.other;

import cn.hutool.core.bean.BeanUtil;
import com.yss.other.BeanUtils.User;
import com.yss.other.BeanUtils.UserVO;
import org.junit.Test;

/**
 * @author: duhao
 * @date: 2020/12/12 11:23
 */
public class TestBeanUtils {
    @Test
    public  void test(){
        User user = new User();
        user.setId("66");
        user.setUsername("zj");
        user.setPassword("aaa");
        user.setRole( "aaa" );
        user.setLimitTimes( 11 );
        user.setNumber( 1 );
        user.setQuestions( "aaa" );
        user.setStartTime( (long) 22 );
        user.setEndTime( (long) 33 );
        user.setTestUrl( "url" );
        user.setCreateTime( (long) 77 );

// 方法一: new VO一个一个的注入

// 方法二:
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(user,userVO);
        System.out.println(userVO);
        UserVO userVO1 = BeanUtil.copyProperties(user, UserVO.class);
        System.out.println(userVO1);

    }

}
