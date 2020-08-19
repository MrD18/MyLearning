package 垃圾回收;

import java.util.ArrayList;

/**-Xms8m -Xmx8m -XX:HeapDumpOnOutOfMemoryError
 * @author: duhao
 * @date: 2020/8/10 11:16
 */
public class HeapOOM {
    // 创建1M的文件
    byte [] buffer = new byte[1 * 1024 * 1024];

    public static void main(String[] args) {
        ArrayList<HeapOOM> list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {
                list.add(new HeapOOM());
                count++;
            }
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("count:" + count);
        }
    }
}

