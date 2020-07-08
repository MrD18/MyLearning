import java.io.*;

/**封装拷贝
 * @author: duhao
 * @date: 2020/6/29 21:53
 */
public class FileUtils {
    public static void main(String[] args) {
    // 文件到文件
        try {
            InputStream is = new FileInputStream("abc.txt");
              OutputStream os=new FileOutputStream("abc-copy.txt");
              copy(is,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

      //文件到字节数组
        byte[] datas=null;
        try {
            InputStream is = new FileInputStream("1.jpeg");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is,os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("1-copy.png");
            copy(is,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * 对接输入输出流
     * @param is
     * @param os
     */
    public static void copy(InputStream is, OutputStream os){
        //3.操作(分段读取)
        try {
            byte[] flush = new byte[1024];//缓冲容器
            int len=-1;// 接收长度
            while ((len=is.read(flush))!=-1){
                 os.write(flush,0,len);//分段写出
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(is, os);
        }

    }
// 关闭封装方法
    private static void close(InputStream is, OutputStream os) {
        try {
            if (null!=os){
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (null!=is){
                is.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 释放资源
    public  static  void close(Closeable... ios){
        for (Closeable io : ios) {
            try {
                io.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
