package com.yss.jingdongpython.main;

import com.yss.jingdongpython.db.MYSQLControl;
import com.yss.jingdongpython.model.JdModel;
import com.yss.jingdongpython.util.URLFecter;
import lombok.SneakyThrows;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.List;

/**
 * @author: duhao
 * @date: 2020/6/17 16:38
 */
public class JdongMain {
    static final Log logger = LogFactory.getLog(JdongMain.class);

    @SneakyThrows
    public static void main(String[] args) {

        //初始化一个httpclient
        HttpClient client = new DefaultHttpClient();
        //我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
        String url = "https://pro.jd.com/mall/active/2Md1wHRuN9A7R19WQB2v2rvx86h7/index.html";
        //抓取的数据
        List<JdModel> bookdatas = URLFecter.URLParser(client, url);
        //循环输出抓取的数据
        for (JdModel jd : bookdatas) {
            logger.info("bookID:" + jd.getBookID() + "\t" + "bookPrice:" + jd.getBookPrice() + "\t" + "bookName:" + jd.getBookName());
        }
        //将抓取的数据插入数据库
        MYSQLControl.executeInsert(bookdatas);
    }
}