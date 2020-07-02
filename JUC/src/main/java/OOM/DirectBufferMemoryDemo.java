package OOM;

import java.nio.ByteBuffer;

/** Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
 * 堆外内存不够,再试尝试分配本地内存时,导致报异常: Direct buffer memory
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * @author: duhao
 * @date: 2020/7/2 16:05
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);// 分配OS内存,不属于GC回收范围
        System.out.println(byteBuffer);
    }
}
