package OOM;

/**java.lang.OutOfMemoryError:unable to create new native thread
 * 不能创建更多的新线程了, 达到线程的创建上线, 高并发场景会应用
 * 这个异常和平台有关系
 * 导致原因:
 *     -- 应用创建了很多的线程, 超过了系统的承载极限
 *     -- 服务器不允许创建这么多线程, Linux系统默认运行单个进程创建1024个线程,超过就报这个异常
 *   解决方法:
 *     -- 降低应用程序的线程数量,分析是否需要创建这么多线程,不是,就改代码降级线程数
 *     -- 确实需要这么多线程,那就该Linux服务配置,扩大限制
 *
 * @author: duhao
 * @date: 2020/7/2 16:23
 */
public class UnableCreateNewThreadDemo {
    public static void main(String[] args) {
        for(int i=1;;i++){
            System.out.println("*******i="+i);
               new Thread(()->{
                  try{Thread.sleep(Integer.MAX_VALUE);}catch(InterruptedException e){e.printStackTrace();}

               },String.valueOf(i)).start();
        }
    }



}
