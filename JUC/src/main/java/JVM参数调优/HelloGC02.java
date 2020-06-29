package JVM参数调优;

/**工作中常用的参数
 * @author: duhao
 * @date: 2020/6/24 13:16
 */
public class HelloGC02 {
    public static void main(String[] args) {
        //返回java虚拟机中内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();

        //返回java虚拟机中试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory();


        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "(字节)、" + (totalMemory / (double)1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + "(字节)、" + (maxMemory / (double)1024 / 1024) + "MB");
/**
 * TOTAL_MEMORY(-Xms) = 255328256(字节)、243.5MB  -Xms 初始堆内存为: 物理内存的1/64
 * MAX_MEMORY(-Xmx) = 3780640768(字节)、3605.5MB  -Xmx 最大堆内存为：系统物理内存的 1/4
 * ### 打印JVM默认参数
 */

    }
}
