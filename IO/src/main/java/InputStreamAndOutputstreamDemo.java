
import java.io.*;

/**文件复制
 * @author: duhao
 * @date: 2020/6/26 10:54
 */
public class InputStreamAndOutputstreamDemo {

    public static void main(String[] args) {
        copyOnWrite("src/main/java/IOTest01.java","ceshi.txt");
    }

    public static void copyOnWrite(String srcPath, String destPath){
        File src = new File(srcPath);
        File dest = new File(destPath);
        //选择流
        InputStream in = null;
        OutputStream out=null;
        try {
            in = new BufferedInputStream(new FileInputStream(src));
            out  = new BufferedOutputStream(new FileOutputStream(dest));
            // 操作
            //分段读取
            byte[] datas = new byte[1024];
            int len;
            while ((len=in.read(datas))!=-1){
                out.write(datas,0,len);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源 先打开的后关闭
            try {

               if (null!=out){
                   out.close();
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null!=in){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
