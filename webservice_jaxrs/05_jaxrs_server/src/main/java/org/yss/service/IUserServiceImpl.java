package org.yss.service;

import org.yss.entity.Car;
import org.yss.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: duhao
 * @date: 2020/6/22 10:31
 */
public class IUserServiceImpl implements IUserService {
    @Override
    public void saveUser(User user) {
        System.out.println("save user:" + user);
    }

    @Override
    public void updateUser(User user) {
        System.out.println("update user:" + user);
    }

    @Override
    public List<User> findAllUsers() {

        List<User>users=new ArrayList<>();

        // 汽车
        ArrayList<Car> carList1 = new ArrayList<>();
        Car car1 = new Car(101, "保时捷", 1000000d);
        Car car2 = new Car(102, "宝马", 4000000d);
        carList1.add(car1);
        carList1.add(car2);

        //用户
        User user1 = new User(1, "小明", "北京", carList1);
        User user2 = new User(2,"小李","广州");
       // 用户集合
        users.add(user1);
        users.add(user2);
        return users;
    }

    @Override
    public User finUserById(Integer id) {
        if (id==1){
            return new User(1,"小明","广州",null);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        System.out.println("delete user id :" + id);
    }
}
