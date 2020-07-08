package com.yss;

/**
 * @author: duhao
 * @date: 2020/7/4 16:50
 */
public class TDownload extends Thread {
   private  String url;// 远程路径
   private  String name;// 存储名字

    public TDownload(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        // 刚才那个工具类
        WebDownLoad wd = new WebDownLoad();
         wd.download(url,name);
    }

// main方法中调用
    // 直接从网上利用多线程抓到了图片
    public static void main(String[] args) {
        TDownload td1 = new TDownload("https://c-ssl.duitang.com/uploads/blog/201306/26/20130626161523_zw25t.jpeg","pone1.jpeg");
        TDownload td2 = new TDownload("https://c-ssl.duitang.com/uploads/blog/201306/24/20130624175629_JHnms.thumb.700_0.png","pone2.png");
        TDownload td3 = new TDownload("https://c-ssl.duitang.com/uploads/blog/201306/24/20130624173606_QFV2U.thumb.700_0.jpeg","pone3.jpeg");

        // 启动三个线程
        td1.start();
        td2.start();
        td3.start();

    }
}
