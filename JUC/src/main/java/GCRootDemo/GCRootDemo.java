package GCRootDemo;

/**
 *
 * 在Java中，可以作为GC Roots的对象有：
 * - 虚拟机栈（栈帧中的局部变量区，也叫做局部变量表）中的引用对象
 * - 方法区中的类静态属性引用的对象
 * - 方法区中常量引用的对象
 * - 本地方法栈中的JNI（Native方法）的引用对象
 * @author: duhao
 * @date: 2020/6/28 16:37
 */
public class GCRootDemo {
    //方法区的静态属性引用对象
   // private  static  GCRootDemo2 t2;



    public static void main(String[] args) {

    }


}
