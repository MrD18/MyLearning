package Java并发编程基础.狂神说;

import Java并发编程基础.狂神说.utils.WebDownLoader;

/**
 * @author: duhao
 * @date: 2021/4/16 16:31
 */
public class DownTest extends Thread {

    private  String url; //网略图片地址
    private String name; // 保存的文件名

    public DownTest(String url, String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downLoader(url,name);
        System.out.println("下载图片为:"+name);
    }

    public static void main(String[] args) {
        DownTest th1 = new DownTest("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fspider.nosdn.127.net%2Feaadc294456f1b215c51037291f7e862.jpeg&refer=http%3A%2F%2Fspider.nosdn.127.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1621154674&t=888a64c0ac433200618b1e57131c0ac2","1.jpg");
      //  TestThread2 th2 = new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fspider.nosdn.127.net%2Feaadc294456f1b215c51037291f7e862.jpeg&refer=http%3A%2F%2Fspider.nosdn.127.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1621154674&t=888a64c0ac433200618b1e57131c0ac2","1.jpg");
      //  TestThread2 th3 = new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fspider.nosdn.127.net%2Feaadc294456f1b215c51037291f7e862.jpeg&refer=http%3A%2F%2Fspider.nosdn.127.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1621154674&t=888a64c0ac433200618b1e57131c0ac2","1.jpg");

        th1.start();
      //  th2.start();
      //  th3.start();
    }

}
