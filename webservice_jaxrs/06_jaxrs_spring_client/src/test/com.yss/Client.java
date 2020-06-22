import com.yss.entity.User;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**测试客户端 调用远程服务端
 * @author: duhao
 * @date: 2020/6/22 13:28
 */
public class Client {
    @Test
    public  void testSave(){
        // 基于restful风格的webservice开发的客户端调用,直接通过一个类:WebClient类完成
        WebClient.create("http://localhost:8080/ws/userService/userService/user")//地址
                .type(MediaType.APPLICATION_JSON_TYPE)
                .post(new User(100,"Kobe","gz",null));//请求类型

    }

    @Test
    public void testOne(){
        // 查询一个
        User user =
                WebClient
                        .create("http://localhost:8080/ws/userService/userService/user/1")
                        .accept(MediaType.APPLICATION_JSON)
                        // .accept(MediaType.APPLICATION_XML_TYPE)
                        .get(User.class);
        System.out.println(user);
    }
    @Test
    public void testfindAll(){
        Collection<? extends User> collection =
                WebClient
                        .create("http://localhost:8080/ws/userService/userService/user")
                        .accept(MediaType.APPLICATION_JSON)
                        .getCollection(User.class);
        System.out.println(collection);
    }
}
