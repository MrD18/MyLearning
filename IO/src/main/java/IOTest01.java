
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**读取一个文件吧
 * @author: duhao
 * @date: 2020/6/23 22:22
 */
public class IOTest01 {
    public static void main(String[] args) throws IOException {
        File file = new File("1.txt");
        FileInputStream inputStream = new FileInputStream(file);
        /**
         *   int temp = 0;
         *         while ((temp=inputStream.read())!=-1){
         *             System.out.print((char) temp);
         *         }
         *         inputStream.close();
         */
        // 分段读取
        byte[] car = new byte[30]; // 缓冲容器
        int len=-1; //接收长度
        while ((len=inputStream.read(car))!=-1){
            //字节数组-->字符串(解码)
            String string = new String(car, 0, len);
            System.out.print(string);
        }
        inputStream.close();
    }
}
