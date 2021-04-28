package com.yss.other.基础.泛型.泛型类;

/** 泛型类
 * 1:把泛型定义在类上
 * 2:类型变量定义在类上,方法中也可以使用
 * @author: duhao
 * @date: 2021/4/22 17:02
 */
public class ObjectTool<T> {
    private  T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }




    public static void main(String[] args) {
        // 创建对象并制定元素类型
        ObjectTool<String> tool = new ObjectTool<>();
         tool.setObj(new String("测试"));
        String s = tool.getObj();
        System.out.println(s);


        //创建对象并指定元素类型
        ObjectTool<Integer> objectTool = new ObjectTool<>();
        /**
         * 如果我在这个对象里传入的是String类型的,它在编译时期就通过不了了.
         */
        objectTool.setObj(10);
        int i = objectTool.getObj();
        System.out.println(i);



    }
}
