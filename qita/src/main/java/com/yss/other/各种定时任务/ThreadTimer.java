package com.yss.other.各种定时任务;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用Thread 真的能做定时任务
 * 说明: 1.这种方式做的定时任务，只能周期性执行，不能支持定时在某个时间点执行。
 *      2.此外，该线程可以定义成守护线程，在后台默默执行就好。
 * 场景: 比如项目中有时需要每隔10分钟去下载某个文件，或者每隔5分钟去读取模板文件生成静态html页面等等，一些简单的周期性任务场景。
 *
 * 优点: 这种定时任务非常简单，学习成本低，容易入手，对于那些简单的周期性任务，是个不错的选择
 * 缺点: 不支持指定某个时间点执行任务，不支持延迟执行等操作，功能过于单一，无法应对一些较为复杂的场景
 * @author: duhao
 * @date: 2021/4/14 9:06
 */
@Slf4j
public class ThreadTimer {

    public static void main(String[] args) {
        init();
    }
    public static void init(){
        new Thread(()->{
            while (true){
                try {
                    System.out.println("这是个定时任务");
                    Thread.sleep(1000*60*1);
                } catch (Exception e) {
                    log.error(String.valueOf(e));
                }
            }
        }).start();
    }
}
