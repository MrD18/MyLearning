package OOM;

/**
 * java.lang.OutOfMemoryError: Java heap space
 * 创建了很多的对象,导致堆空间不够
 * @author: duhao
 * @date: 2020/6/30 15:31
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        /**
         *  堆空间的大小 -Xms10m -Xmx10m
         *  创建一个 80M的字节数组
         */
        byte[] bytes = new byte[80 * 1024 * 1024];
    }
}
