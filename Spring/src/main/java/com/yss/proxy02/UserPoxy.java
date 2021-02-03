package com.yss.proxy02;

import com.yss.dynamicproxy.UserSericeImpl;
import com.yss.dynamicproxy.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: duhao
 * @date: 2020/12/25 10:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPoxy  implements UserService {
    private UserSericeImpl userSerice;
    @Override
    public void add() {
        log("add");
        userSerice.add();
    }

    @Override
    public void delete() {
        log("delete");
    userSerice.delete();
    }

    @Override
    public void update() {
        log("update");
     userSerice.update();
    }

    @Override
    public void list() {
        log("list");
   userSerice.list();
    }
    //日志方法
    public void log(String msg){
        System.out.println("增加日志功能"+msg);
    }


}
