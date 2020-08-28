package 类加载机制;

/***初始化的各种场景
 * 通过VM参数可以观察操作是否会导致子类的加载 -XX:+TraceClassLoading
 * @author: duhao
 * @date: 2020/8/27 11:15
 */
public class Initialization {
    public static void main(String[]args){
        Initialization initialization = new Initialization();
   //      initialization.M1();//打印子类的静态字段
	//	initialization.M2();//使用数组的方式创建
	// initialization.M3();//打印一个常量
		initialization.M4();//如果使用常量去引用另外一个常量
    }
    public void M1(){
        //如果通过子类引用父类中的静态字段，只会触发父类的初始化，而不会触发子类的初始化(但是子类会被加载)

        System.out.println(SubClaszz.value);
    }
    public void M2(){
        //使用数组的方式， 不会触发初始化(触发父类加载，不会触发子类加载)
        SuperClazz[]sca = new SuperClazz[10];

    }
    public void M3(){
        //打印一个常量,不会触发初始化(同样不会触类加载、编译的时候这个常量已经进入了自己class的常量池)
        System.out.println(SuperClazz.HELLOWORLD);
    }
    public void M4(){
        //如果使用常量去引用另外一个常量(会不会初始化SuperClazz  1  不会走2)
        System.out.println(SuperClazz.WHAT);
    }
}

class SubClaszz extends SuperClazz {
    static{
        System.out.println("SubClass init！"); // 子类静态代码块
    }


}

class SuperClazz {
    static 	{
        System.out.println("SuperClass init！");// 父类静态代码块
    }
    public static int value=123;  // 静态变量
    public static final String HELLOWORLD="hello kingdom"; // 被final修饰的 常量
    public static final int WHAT = value; // 一个常量引用另一个常量
}

