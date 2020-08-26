package 类加载机制;

/**
 * 类加载情况
 *
 * @author: duhao
 * @date: 2020/8/26 11:05
 */
public class Parent {
    static {
        System.out.println("父类加载...");
    }
}

class Child extends Parent {
    static {
        System.out.println("子类加载...");
    }

    public static void main(String[] args) {
        System.out.println("子类运行...");
    }

}
/*先执行父类的静态代码块, 在子类的静态,在子类的方法
父类加载...
子类加载...
子类运行...*/
