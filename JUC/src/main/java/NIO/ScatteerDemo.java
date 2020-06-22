package NIO;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.lang.String.*;

/**分散读取(Scatter): 将通道中的数据分散到多个缓冲区中
 * @author: duhao
 * @date: 2020/6/15 14:22
 *
 *我们定义了两个缓冲区，然后通过通道将我们的内容分别读取到两个缓冲区中，这就实现了分散读取
 */
public class ScatteerDemo {

    public static void main(String[] args) throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("1.txt","rw");
        // 获取通道
        FileChannel channel = raf1.getChannel();
        //分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(10);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        // 分散读取
        ByteBuffer[] bufs= {buf1,buf2};
        channel.read(bufs);
        for (ByteBuffer byteBuffer : bufs) {
            // 切换成读模式
            byteBuffer.flip();
        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
       System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));
     Gather("1.txt");

    }


  // 聚集写入
    private  static  void Gather(String str1) throws IOException {
        FileInputStream fin = new FileInputStream(str1);
        FileChannel inchannel = fin.getChannel();
        RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
        FileChannel channel2 = raf2.getChannel();

        // 分配指定大小
 //
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        while (inchannel.read(buf2)!=-1){
            buf2.flip();
        }
        channel2.write(buf2);

    }
}

