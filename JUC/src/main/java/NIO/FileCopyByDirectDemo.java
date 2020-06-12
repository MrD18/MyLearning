package NIO;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**利用通道完成文件的复制
 * 利用直接缓冲区,完成文件复制
 * @author: duhao
 * @date: 2020/6/12 15:26
 */
public class FileCopyByDirectDemo {
    public static void main(String[] args) throws Exception {

        // 获取通道
        FileChannel inChannel = FileChannel.open(Paths.get("02.png"),
                StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("03.png"),
                StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);
         // 得到的一个内存映射文件
        // 这个的好处是，直接将文件存储在内存中了
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        // 直接对缓冲区进行数据的读写操作
        byte [] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);
        inChannel.close();
        outChannel.close();
    }
}