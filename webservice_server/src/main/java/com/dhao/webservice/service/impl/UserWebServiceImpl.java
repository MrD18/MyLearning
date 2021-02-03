package com.dhao.webservice.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.dhao.webservice.entry.User;
import com.dhao.webservice.service.UserWebService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**服务端创建一个接口的实现类
 * @author: duhao
 * @date: 2021/1/7 12:20
 */
@WebService
public class UserWebServiceImpl implements UserWebService {
    @WebMethod
    @Override
    public String getUserById(Integer id) {

        //一般数据都是从数据库查找，我这里直接伪造一下
        User user1 = new User(1, "Tom", 20);
        User user2 = new User(2, "Mary", 18);
        User user3 = new User(3, "Lucy", 19);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        for (int i = 0; i < userList.size(); i++) {
            //判断一下用户输入的id是否可以匹配上某个User的id
            if (userList.get(i).getId() == id) {
                //找到用户直接转成json返回去
                String json = JSONArray.toJSON(userList.get(i)).toString();
                return json;
            }
        }
        //未找到直接返回一个错误消息
        return "该id用户不存在";
    }


}

