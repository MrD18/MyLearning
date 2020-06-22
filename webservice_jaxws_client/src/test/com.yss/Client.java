import com.yss.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author: duhao
 * @date: 2020/6/22 9:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Client {
    // 注入远程访问服务端的接口的代理对象
    @Resource
    private HelloService helloService;
    @Test
    public void test(){
        // 查看接口的代理对象类型
        // class com.sun.proxy.$Proxy44
        System.out.println(helloService.getClass());
        //远程访问服务端方法--(传参数给服务端,这里面提供的是 name)
        System.out.println(helloService.sayHello("dhao"));


    }


}
