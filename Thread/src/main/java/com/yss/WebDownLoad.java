package com.yss;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/** 下载图片
 * @author: duhao
 * @date: 2020/7/4 16:44
 */
public class WebDownLoad {

    /**
     * 下载工具,从网上下载的那种
     * @param url
     * @param name
     */
    public void download(String url,String name){
        //CommonsIO
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载失败");
        }

    }

}
