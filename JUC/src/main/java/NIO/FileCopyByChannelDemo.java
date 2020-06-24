package NIO;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**利用通道进行数据传输
 * @author: duhao
 * @date: 2020/6/12 15:44
 */
public class FileCopyByChannelDemo {
    public static void main(String[] args) throws IOException {
        // 获取通道
        // 获取通道
        FileChannel inChannel = FileChannel.open(Paths.get("02.png"),
                StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("04.jpg"),
                StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);
              // 从inChannel 通道到 outChannel通道
        inChannel.transferTo(0,inChannel.size(),outChannel);
             inChannel.close();
             outChannel.close();
    }
}
