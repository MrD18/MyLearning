import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * 重点掌握拷贝
 *
 * @author: duhao
 * @date: 2020/7/2 21:57
 */
public class CommonsIOTest04 {
    public static void main(String[] args) throws IOException {
        //复制文件
            FileUtils.copyFile(new File("1.jpeg"),new File("1.1-copy.png"));
        // 复制文件到目录   后面那个new File("目录名字")
        //  FileUtils.copyFileToDirectory(new File("1.jpeg"),new File("IO"));
        //复制目录到目录   这个牛逼  直接复制整个目录   --这个是从新起一个名字为IO2的  将IO内容全部放到IO2中
        //  FileUtils.copyDirectoryToDirectory(new File("IO"),new File("IO2"));
       // 复制目录  这个是直接将IO 内容 复制为IO2 没有层级目录
       //     FileUtils.copyDirectory(new File("IO"),new File("IO2"));
       // 拷贝URL内容
//        String url="https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=佟丽娅电脑壁纸&step_word=&hs=2&pn=6&spn=0&di=56980&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=1610012917%2C2442077275&os=3795837158%2C2143591531&simid=3356079846%2C282311327&adpicid=0&lpn=0&ln=2300&fr=&fmq=1593699348795_R&fm=rs3&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=wallpaper&bdtype=0&oriquery=佟丽娅%20写真&objurl=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2018-06-20%2F5b29f2b35394d.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Botg9aaa_z%26e3Bv54AzdH3Fowssrwrj6_1jpwts_890can_d_z%26e3Bip4s&gsm=7&rpstart=0&rpnum=0&islist=&querylist=&force=undefined";
//      FileUtils.copyURLToFile(new URL(url),new File("佟丽娅.png"));
     // 爬一个网站的内容
        String datas = IOUtils.toString(new URL("https://www.cmdy5.com/dongman/dldl.html"), "utf-8");
        System.out.println(datas);
    }
}
