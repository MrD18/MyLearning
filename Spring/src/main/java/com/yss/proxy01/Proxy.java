package com.yss.proxy01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: duhao
 * @date: 2020/12/25 9:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proxy implements Rent {
    /*把房东注入进来*/
    private Host host;

    @Override
    public void rent() {
        /*代理房东去租房*/
        host.rent();
        seeHouse();
        fare();
        hetong();
    }
    /*中介的特有方法*/

    public void seeHouse() {
        System.out.println("中介带你去看房");
    }

    public void fare() {
        System.out.println("中介收租金");
    }
    public void hetong(){
        System.out.println("和中介签合同");
    }
}
