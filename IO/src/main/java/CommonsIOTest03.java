import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**写出类容
 * @author: duhao
 * @date: 2020/7/1 23:00
 */
public class CommonsIOTest03 {
    public static void main(String[] args) throws IOException {
        //写出文件
        FileUtils.write(new File("happy.sxt"),"学习是一件很辛苦的事情\r\n","UTF-8"); // 可以加true   后面继续写
        FileUtils.writeStringToFile(new File("happy.sxt"),"学习是一件很辛苦的事情\r\n","utf-8");
    }
}
