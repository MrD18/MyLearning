package com.yss.other.动态代理;

/**接口   用户管理接口(真实主体和代理主题的共同接口)
 * 这样在任何可以使用真实主题的地方都可以使用动态代理主题代理
 * @author: duhao
 * @date: 2020/6/29 9:30
 */
public interface IUserManager {
    void addUser(String id,String password);
}
