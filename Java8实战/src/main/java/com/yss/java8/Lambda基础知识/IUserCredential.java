package com.yss.java8.Lambda基础知识;

/**
 * 用户身份认证标记接口
 * 函数式接口:  接口中只有一个抽象方法
 *
 * @author: duhao
 * @date: 2020/8/21 14:41
 */
@FunctionalInterface
public interface IUserCredential {

    /**
     * 通过用户账号，验证用户身份信息的接口
     *
     * @param username 要验证的用户账号
     * @return 返回身份信息[系统管理员、用户管理员、普通用户]
     */
    String verifyUser(String username);
    // boolean test();

    /**
     * 函数式接口中,写一个默认方法,实现用户身份的判断
     *
     * @param username
     * @return
     */
    default String getCredential(String username) {
        //模拟方法
        if ("admin".equals(username)) {
            return "admin + 系统管理员";
        } else if ("manager".equals(username)) {
            return "manager + 用户管理员用户";
        } else {
            return "commons + 普通会员用户";
        }
    }

}
