package 狂神说JUC;

/**还是景点的买票问题
 * 真正的多线程开发, 公司中的开发,降低耦合性
 * 线程就是一个单独的资源类,没有任何附属的操作!
 * 1. 属性,方法
 * @author: duhao
 * @date: 2021/5/11 10:04
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        // 并发,多线程操作同一个资源类,把资源类丢入到线程
        Ticket ticket = new Ticket();
        // @FunctionalInterface 函数式接口, jdk1.8 可以使用lambda表达式()->{}
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                ticket.sale();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                ticket.sale();
            }
        },"C").start();


    }
}

// 资源类 OOP
class Ticket{
   // 属性
    private  int number =50;
   // 方法
   public  synchronized  void sale(){
       if (number>0){
           System.out.println(Thread.currentThread().getName()+"卖出去了"+(number--)+"票,剩余:"+number);
       }
   }
}
