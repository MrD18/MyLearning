package Java并发编程基础.狂神说.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**图片下载工具类
 * @author: duhao
 * @date: 2021/4/16 16:27
 */
public class WebDownLoader {

    public WebDownLoader() {

    }

    //定义一个下载方法
    public void downLoader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downLoader方法出现问题.");
        }

    }
}
