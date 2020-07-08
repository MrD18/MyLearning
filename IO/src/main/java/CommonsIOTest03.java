import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**写出类容
 * FileUtils.write(new File("xxx"),"xxxx","UTF-8") // 指定个文件, 内容, 字符集
 *  FileUtils.writeStringToFile(new File("xxx"),"xxx","UTF-8") //
 *
 * @author: duhao
 * @date: 2020/7/1 23:00
 */
public class CommonsIOTest03 {
    public static void main(String[] args) throws IOException {
        //写出文件
        FileUtils.write(new File("happy.sxt"),"学习是一件很辛苦的事情\r\n","UTF-8"); // 可以加true   后面继续写
        FileUtils.writeStringToFile(new File("happy.sxt"),"学习是一件很辛苦的事情\r\n","utf-8",true);
        FileUtils.writeByteArrayToFile(new File("happy.sxt"),"学习是一件很幸福的事情\r\n".getBytes(),true);

     // 写出列表
        List<String> strings = Arrays.asList("码云", "马化腾", "弼马温");
        FileUtils.writeLines(new File("happy.sxt"),strings,"/",true );
        // 有点意思, writeLines 可以看下方法里面的参数,   "/"  这一块会给每一个,字符串后面加一个 /, 你也可以设置成别的


    }
}
