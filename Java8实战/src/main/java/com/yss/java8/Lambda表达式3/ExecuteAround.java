package com.yss.java8.Lambda表达式3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: duhao
 * @date: 2020/8/10 16:04
 */
public class ExecuteAround {
    public static void main(String[] args) throws Exception {
        String result = ProcessFileLimited();
        System.out.println(result);
        System.out.println("------------------");
        // String oneLines = processFile((BufferedReader b) -> b.readLine())
        String oneLines = processFile(BufferedReader::readLine);
        System.out.println(oneLines);
        String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);
    }


    public  static  String ProcessFileLimited() throws Exception {

       try( BufferedReader br= new BufferedReader(new FileReader("abc-copy.txt"))){
           return br.readLine();
       }

    }

 // 传递行为 就是下面定义的这个函数式接口
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("abc-copy.txt"))){
            return p.process(br);
        }

    }

    /**
     * Lambda仅可用于上下文是函数式接口的情况。你需要创建一个能匹配
     * BufferedReader -> String，还可以抛出IOException异常的接口。让我们把这一接口叫作
     * BufferedReaderProcessor吧。
     */
    public interface BufferedReaderProcessor{
        public String process(BufferedReader b) throws IOException;

    }

}
