package java锁;

/**
 * @author: duhao
 * @date: 2020/7/23 17:02
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        int a=1;
        int b=3;
        System.out.println(a-b);
        test1();
        test2();
    }
    public static synchronized void test1(){
    }
    public  static void test2(){
        synchronized (SynchronizedTest.class){
        }
    }
}
