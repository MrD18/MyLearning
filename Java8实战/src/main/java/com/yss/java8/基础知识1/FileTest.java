package com.yss.java8.基础知识1;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

/**方法引用
 * 筛选隐藏文件
 * @author: duhao
 * @date: 2020/7/31 9:58
 */
public class FileTest {
    public static void main(String[] args) {

//        File[] files = new File("C:/Users/yss/Desktop/学习").listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.isHidden(); //  筛选隐藏文件
//            }
//        });
//        if (files != null) {
//            Arrays.stream(files).forEach(System.out::print);
//        }

        // 采用方法引用
       // Arrays.stream(Objects.requireNonNull(new File("C:/Users/yss/Desktop/学习").listFiles(File::isHidden))).forEach(System.out::println);

        File[] files = new File("C:/Users/yss/Desktop/学习").listFiles(File::isHidden);
        if (files != null) {
            Arrays.stream(files).forEach(System.out::println);
        }
         // Collectors.toList()：转换成List集合。/ Collectors.toSet()：转换成set集合。
         Arrays.stream(files).collect(Collectors.toList()).forEach(System.out::println);
    }
}
