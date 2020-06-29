import javafx.scene.chart.PieChart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**文件字符输出流
 * @author: duhao
 * @date: 2020/6/27 10:24
 */
public class FileWriterTest {
    public static void main(String[] args) {
        //1. 创建源文件
        File dest = new File("dest.txt");
        //2. 选择流
        FileWriter writer=null;
        try {
            writer = new FileWriter(dest);
            //3. 操作 写出
            //写法一
//            String mesg="我爱Java,做梦都在敲代码";
//            char[] datas = mesg.toCharArray();// 字符串-->字符数组
//            writer.write(datas,0,datas.length);
            //写法二  字符串就是字符数组  直接丢进去
//            String mesg="我爱Java,做梦都在敲代码,然而....";
//            writer.write(mesg);

            //写法三
            writer.append("我爱Java\r\n").append("没办法的拉");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4. 关闭
            try {
                if (null!=writer){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
