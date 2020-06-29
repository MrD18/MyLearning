package JVM参数调优;

/** 查看运行java的程序,JVM参数是否开启,具体值为多少
 * @author: duhao
 * @date: 2020/6/23 17:02
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello GC");


        // new 一个大对象
      //jsp  byte[] bytes = new byte[1024 * 1024 * 30];
          Thread.sleep(Integer.MAX_VALUE);
    }
}
