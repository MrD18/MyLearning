package com.yss;

/**
 * @author: duhao
 * @date: 2020/7/4 17:19
 */
public class RDownload implements  Runnable {
    private  String url;// 远程路径
    private  String name;// 存储名字

    public RDownload(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        // 下载图片的方法
        WebDownLoad downLoad = new WebDownLoad();
         downLoad.download(url,name);
    }
    //
    public static void main(String[] args) {
        RDownload r1 = new RDownload("https://c-ssl.duitang.com/uploads/blog/201306/26/20130626161523_zw25t.jpeg","pone1.jpeg");
        RDownload r2 = new RDownload("https://c-ssl.duitang.com/uploads/blog/201306/24/20130624175629_JHnms.thumb.700_0.png","pone2.png");
        RDownload r3 = new RDownload("https://c-ssl.duitang.com/uploads/blog/201306/24/20130624173606_QFV2U.thumb.700_0.jpeg","pone3.jpeg");
      new Thread(r1).start();
      new Thread(r2).start();
      new Thread(r3).start();

    }
}
