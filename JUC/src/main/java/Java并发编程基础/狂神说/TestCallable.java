package Java并发编程基础.狂神说;

import Java并发编程基础.狂神说.utils.WebDownLoader;

import java.util.concurrent.*;

/**使用线程池,进行图片下载
 * @author: duhao
 * @date: 2021/4/19 10:37
 */
public class TestCallable implements Callable<String> {
    private  String url; //网略图片地址
    private String name; // 保存的文件名

    public TestCallable(String url, String name){
        this.url=url;
        this.name=name;
    }
    // 重写里面的call方法, 是有返回体的
    @Override
    public String call() throws Exception {
        //线程体
        try {
            WebDownLoader webDownLoader = new WebDownLoader();
            webDownLoader.downLoader(url,name);
            System.out.println("下载图片为:"+name);
            return "下载成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "下载失败";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fspider.nosdn.127.net%2Feaadc294456f1b215c51037291f7e862.jpeg&refer=http%3A%2F%2Fspider.nosdn.127.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1621154674&t=888a64c0ac433200618b1e57131c0ac2","1.jpg");
        TestCallable t2 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdingyue.nosdn.127.net%2FqX2C6KsH%3D1O7IRKGlk7h7t3k7lnmb8buDIASI4wFpATs51535504102521compressflag.jpeg&refer=http%3A%2F%2Fdingyue.nosdn.127.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1621392216&t=f24cb4a023c4296a8b429df2eafc784c","2.jpg");


       // 创建线程池的方法与使用
       /* ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        singleThreadPool.execute(()-> {



        });
        singleThreadPool.shutdown();*/

        /**不同点在这里,线程池的创建,使用,关闭*/
        // 创建执行服务
         ExecutorService ser = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<String> r1 = ser.submit(t1);
        Future<String> r2 = ser.submit(t2);
        //获取提交结果
        System.out.println(r1.get());
        System.out.println(r2.get());
        //关闭服务
        ser.shutdownNow();

    }

}
