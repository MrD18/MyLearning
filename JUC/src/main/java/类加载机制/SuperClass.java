package 类加载机制;

/**
 * @author: duhao
 * @date: 2020/8/26 11:13
 */
public class SuperClass {
    static {
        System.out.println("SuperClass（父类）被初始化了。。。");
    }
    public static int value = 66;
}

 class Subclass extends SuperClass {
    static {
        System.out.println("Subclass（子类）被初始化了。。。");
    }
}

 class Test1 {

    public static void main(String[] args) {

        // 1:通过子类调用父类的静态字段不会导致子类初始化
       //  System.out.println(Subclass.value);//SuperClass（父类）被初始化了。。。
        // 2:通过数组定义引用类，不会触发此类的初始化
       // SuperClass[] superClasses = new SuperClass[3];
        // 3:通过new 创建对象,可以实现类初始化，必须把1下面的代码注释掉才有效果不然经过1的时候类已经初始化了，下面这条语句也就没用了。
       // SuperClass superClass = new SuperClass();
        Subclass subclass = new Subclass();// 子类初始化前,父类先必须完成初始化
    }

}
