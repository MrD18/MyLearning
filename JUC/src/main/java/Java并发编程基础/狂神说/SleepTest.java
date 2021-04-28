package Java并发编程基础.狂神说;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Sleep的使用
 *
 * @author: duhao
 * @date: 2021/4/20 13:29
 * <p>
 * 1. 睡上几秒,模拟网略延迟
 * 2. 当倒计时使用
 * 3. 每个对象都有一把锁,sleep 不会释放锁
 */
public class SleepTest {
    public static void main(String[] args) {
      //  tenDown();
         tenDown2();

    }
     //方法2: 使用系统时间进行倒计时
    public static void tenDown2(){
        // 打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis());// 获取当前系统时间
        System.out.println("直接打印的-->"+startTime);
        while (true){
            try {
                Thread.sleep(1000);
                //打印当前时间
                String formatDate = new SimpleDateFormat("HH:mm:ss").format(startTime);
                System.out.println("String formatDate-->"+formatDate);
                startTime = new Date(System.currentTimeMillis());

            } catch (InterruptedException e) {
            }
        }


    }


    //方法1: 模拟倒计时
    public static void tenDown() {
        int num = 10;
        while (true) {
            try {
                // 睡 1s
                Thread.sleep(1000);
                System.out.println(num--);
                // 当num<0时 跳出循环
                if (num < 0) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
