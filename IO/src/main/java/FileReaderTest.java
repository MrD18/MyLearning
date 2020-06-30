
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**文件字符输入流
 * @author: duhao
 * @date: 2020/6/27 10:14
 */
public class FileReaderTest {
    public static void main(String[] args) {
        //1. 创建流
        File src = new File("1.txt");
        //2. 选择流
        FileReader reader=null;
        try {
            reader = new FileReader(src);
            //3.操作  这一块就不是字节了 而是字符
            char[] flush = new char[1024];
            int len=-1;
            while ((len=reader.read(flush))!=-1){
                //字符-->字符串
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.关流
            try {
                if (null!=reader){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
