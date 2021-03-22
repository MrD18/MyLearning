package com.yss.other.如何进行测试;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * @author: duhao
 * @date: 2021/3/19 9:29
 */
public class Demo01 {


    //验证行为是否发生
    @Test
   public void test1(){
        // 模拟创建一个List对象
        List<Integer> mock = mock(List.class);
        //调用mock对象的方法
        mock.add(1);
        mock.clear();
        //验证方法是否执行
        Mockito.verify(mock).add(1);
        Mockito.verify(mock).clear();
    }

    //多次触发返回不同值
    @Test
    public void test2(){

        //mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        //预设当iterator调用next()时第一次返回hello，第n次都返回world
        Mockito.when(iterator.next()).thenReturn("hello").thenReturn("world");
        //使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        //验证结果
        Assert.assertEquals("hello world world",result);
    }

    //模拟抛出异常
   @org.junit.Test(expected = IOException.class)//期望报IO异常
    public void when_thenThrow() throws IOException{
        OutputStream mock = Mockito.mock(OutputStream.class);
        //预设当流关闭时抛出异常
        Mockito.doThrow(new IOException()).when(mock).close();
        mock.close();
    }

     //使用默认Answer模拟对象
    /*
     * RETURNS_DEEP_STUBS 是创建mock对象时的备选参数之一
     * 以下方法deepstubsTest和deepstubsTest2是等价的
     */
     @Test
     public void deepstubsTest(){
         A a=Mockito.mock(A.class,Mockito.RETURNS_DEEP_STUBS);
         Mockito.when(a.getB().getName()).thenReturn("Beijing");
         Assert.assertEquals("Beijing",a.getB().getName());
     }

    @Test
    public void deepstubsTest2(){
        A a=Mockito.mock(A.class);
        B b=Mockito.mock(B.class);
        Mockito.when(a.getB()).thenReturn(b);
        Mockito.when(b.getName()).thenReturn("Beijing");
        Assert.assertEquals("Beijing",a.getB().getName());
    }

    }
class A{
    private B b;
    public B getB(){
        return b;
    }
    public void setB(B b){
        this.b=b;
    }
}
class B{
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSex(Integer sex){
        if(sex==1){
            return "man";
        }else{
            return "woman";
        }
    }
}
