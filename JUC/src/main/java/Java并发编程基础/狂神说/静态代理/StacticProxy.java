package Java并发编程基础.狂神说.静态代理;

/**
 * @author: duhao
 * @date: 2021/4/20 10:05
 *
 * 静态代理总结:
 * 1.真实对象和代理对象都要实现同一个接口
 * 2.代理对象要代理真实角色
 *
 * 好处:
 * 1.代理对象可以做很多真实对象做不了的事情
 * 2.真实对象专注自己的事情
 */
public class StacticProxy {

    public static void main(String[] args) {
        //之前我们是这样调的
     /*   You you = new You();
        you.HappyMarry();*/
        // 使用静态代理做
        new WeddingCompany(new You()).HappyMarry();
        // 和线程做个对比
        new Thread(()-> System.out.println("简单的多线程写法...")).start();


      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("原始的多线程写法...");
            }
        },"线程A").start();*/
    }
}



//3. 代理对象也要实现接口,并且要传入真实的对象,且可以做一些增强的处理
class WeddingCompany implements Marry{

     // 这就是目标对象
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        //可以前后增加一些方法
        before();
      this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后的增强方法...");
    }

    private void before() {
        System.out.println("结婚之前的增强方法...");
    }
}
//2.真实对象去实现这个接口
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("我要结婚了...");
    }
}

//1.定义一个共同的接口
interface Marry{
    void HappyMarry();
}

