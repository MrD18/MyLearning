
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**读取一个文件吧, 字节输入流
 * @author: duhao
 * @date: 2020/6/23 22:22
 */
public class IOTest01 {
    public static void main(String[] args) throws IOException {
         // 1. 创建源
        File file = new File("1.txt");
        // 2. 选择流
        FileInputStream inputStream = new FileInputStream(file);
        /**
         *   int temp = 0;
         *         while ((temp=inputStream.read())!=-1){
         *             System.out.print((char) temp);
         *         }
         *         inputStream.close();
         */
        //3. 操作(读取)
        // 分段读取
        byte[] car = new byte[30]; // 缓冲容器
        int len=-1; //接收长度
        while ((len=inputStream.read(car))!=-1){
            //字节数组-->字符串(解码)   就是构建字符串
            String string = new String(car, 0, len);
            System.out.print(string);
        }
        //4. 释放
        inputStream.close();
    }
}
