package com.yss.mapper;

import com.yss.domain.QueryVo;
import com.yss.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author: duhao
 * @date: 2020/12/10 14:26
 */
public interface UserMapper {

    public Integer  addRebackKey();
    public List<User> findbyUsername(String username);
    public   List<User> findAll();
    public  void  add();
    public  void  deleteById(Integer id);
    public void  update(User user);
    /*多参数传入, 使用 vo*/
    List<User> findByCondition(QueryVo queryVo);
    /*多参数传入, 使用 Map*/
    List<User> findByCondition2(HashMap<String, Object> map);
    /*多参数传入, 参数位置固定*/
    List<User> findByCondition3(String username, int startIndex, int pageSize);
   /*多参数传入, 参数位置不固定*/
    List<User> findByCondition4(@Param("username") String username, @Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

   /*动态sq--if*/
    List<User> findAge(User user);
    /*动态sq--set*/
    void updateSet(User user);
    /*动态sql foreach*   集合*/
    void delByIdList(List<Integer> ids);
    /*动态sql foreach*   数组*/
    void delByIdArray(Integer[] ids);

       List<User> findAllo2m();

}
