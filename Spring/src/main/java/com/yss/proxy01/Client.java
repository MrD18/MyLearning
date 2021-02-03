package com.yss.proxy01;

/**
 * @author: duhao
 * @date: 2020/12/25 9:47
 */
// 租房子的人,我要租房子
public class Client {
    public static void main(String[] args) {
        /*最直接的方式,new 房东对象,获得租房子的方法*/
      /*  Host host = new Host();
        host.rent();*/
         //房东要出租房子
        Host host = new Host();
        //中介代理房东出租房子,  代理角色会有附属操作!!
        Proxy proxy = new Proxy(host);
        //你不用面对房东,直接找中介租房即可!
        proxy.rent();
    }
}
