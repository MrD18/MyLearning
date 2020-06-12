package NIO;


import java.nio.ByteBuffer;

/**
 * - capacity：容量，表示缓冲区中最大存储数据的容量，一旦申明不可改变。
 * - limit：界限，表示缓冲区中的可以操作数据的大小。（limit 后数据不能进行读写）
 * - position：位置，表示缓冲区中正在操作的位置
 * - mark：标记，表示记录当前 position 的位置，可以通过reset() 恢复到 mark的位置
 * 最后它们之间的关系是：0 <= mark <= position <= limit <= capacity
 * @author: duhao
 * @date: 2020/6/12 14:09
 */
public class BufferDemo {
    public static void main(String[] args) {
          // 分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("初始化");
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());
        // 存入数据到缓冲区
        java.lang.String str="abcde";
        buffer.put(str.getBytes());
        System.out.println("存入数据");
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());
        // 切换读取数据
        buffer.flip();
        System.out.println("切换读取数据模式");
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());
        // 切换读取数据
        System.out.println("开始读取数据");
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println( new String(dst,0,dst.length));
        System.out.println("读取数据完毕");
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());
        // 重复读
        buffer.rewind();
        System.out.println("rewind:重复读");;
        System.out.println( new String(dst,0,dst.length));
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());
        //清空缓冲区
        buffer.clear();
        System.out.println("clear:清空缓冲区");
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());

    }
}
