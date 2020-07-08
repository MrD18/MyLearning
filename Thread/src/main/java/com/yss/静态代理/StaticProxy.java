package com.yss.静态代理;

/** 静态代理,可以记录日志
 * 接口:  Marry(方法 happyMarry..)
 * 1. 真实角色 you实现 Marry
 * 2. 代理角色   WeddingCompany 实现 Marry
 *       必须有目标角色  代理谁?
 *          new Marry()
 *             重写了方法   -->前后干一些事情
 * @author: duhao
 * @date: 2020/7/4 21:47
 */
public class StaticProxy {

    public static void main(String[] args) {
         new WeddingCompany(new You()).happyMarry();
      //   new Thread(线程对象).start();
    }
}
//定义接口
interface Marry{
    //方法
    void happyMarry();
}
// 真实角色
class  You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("you and 嫦娥奔月" );
    }
}
// 代理角色  婚庆公司
class  WeddingCompany implements Marry{
   // 必须有目标对象  代理谁--> 真实角色
    private Marry target;
    public  WeddingCompany(Marry target){
    this.target=target;
    }
    @Override
    public void happyMarry() {
         ready();// 前置干些事情  谁登录了
         this.target.happyMarry();
         after();// 后置干些事情   谁退出了
    }

    private void after() {
        System.out.println("闹洞房.....");
    }


    private void ready() {
        System.out.println("布置场景.....");
    }


}