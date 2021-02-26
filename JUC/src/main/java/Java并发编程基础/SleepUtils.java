package Java并发编程基础;

import java.util.concurrent.TimeUnit;

/**
 * @author: duhao
 * @date: 2021/2/25 15:42
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
