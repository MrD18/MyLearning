package NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/** 利用通道完成文件复制
 * 使用非直接缓冲区,完成文件的复制
 * @author: duhao
 * @date: 2020/6/12 14:58
 */
public class FileCopyDemo {

    public static void main(String[] args) {
        FileInputStream ino=null;
        FileOutputStream out=null;
        FileChannel inoChannel=null;
        FileChannel outChannel=null;


        try {
            String file="C:/Users/yss/Desktop/01.png";
                 ino = new FileInputStream(file);
                 out = new FileOutputStream("02.png");
            // 获取通道
                inoChannel = ino.getChannel();
               outChannel = out.getChannel();
            //分配指定大小
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (inoChannel.read(buf)!=-1){
                // 切换读的数据
                  buf.flip();
                  // 将缓冲区的数据写入到通道
                outChannel.write(buf);
                // 清空缓冲区
                 buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ino!=null){
                    ino.close();
                }
                if (out!=null){
                    out.close();
                }
                if (inoChannel!=null){
                    inoChannel.close();
                }
                if (outChannel!=null){
                    outChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }


    }


}
