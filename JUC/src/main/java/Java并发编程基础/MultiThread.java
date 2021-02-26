package Java并发编程基础;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**下面使用JMX来查看一个普通的Java程序包含哪些线程
 * @author: duhao
 * @date: 2021/2/20 16:05
 */
public class MultiThread {
    public static void main(String[] args) {
        // 获取Java 线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName());
        }

/**  可以看出java程序运行时不仅仅是main()方法运行,还有其他线程同时运行
 * [6]Monitor Ctrl-Break
 * [5]Attach Listener
 * [4]Signal Dispatcher // 分发处理发送给JVM信号的线程
 * [3]Finalizer  // 调用对象finalize方法的线程
 * [2]Reference Handler   // 清除Reference的线程
 * [1]main   // main线程，用户程序入口
 */


    }
}
