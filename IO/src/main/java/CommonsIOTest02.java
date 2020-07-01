import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;
import java.util.List;

/**读取文件  读取类容
 * @author: duhao
 * @date: 2020/7/1 22:48
 */
public class CommonsIOTest02 {
    public static void main(String[] args) throws IOException {
        String msg = FileUtils.readFileToString(new File("emp.txt"),"UTF-8");
        System.out.println(msg);
        //转换成字节数组
        byte[] datas = FileUtils.readFileToByteArray(new File("emp.txt"));
        System.out.println(datas.length);
        //逐行读取
        List<String> msgList = FileUtils.readLines(new File("emp.txt"));
        for (String string : msgList) {
            System.out.println(string);
        }
        // 读取还可以这么写
        LineIterator it = FileUtils.lineIterator(new File("emp.txt"));
        while (it.hasNext()){
            System.out.println(it.nextLine());
        }
    }
}
