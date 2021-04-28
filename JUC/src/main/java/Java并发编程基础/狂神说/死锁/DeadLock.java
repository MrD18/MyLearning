package Java并发编程基础.狂神说.死锁;

/**测试死锁
 * @author: duhao
 * @date: 2021/4/22 10:56
 */
// 死锁: 多个线程互相拿着对方所需要的资源, 然后形成僵持
public class DeadLock {

    public static void main(String[] args) {
        // 弄2个线程
        Makeup g1 = new Makeup(0,"灰姑娘");
        Makeup g2 = new Makeup(1,"白雪公主");

        g1.start();
        g2.start();
    }

}
// 资源 1 口红
class Lipstick{ }
// 资源 2  镜子
class Mirror{ }

class  Makeup extends Thread{
   // 所需要的资源只有一份, 用static修饰
   static   Lipstick lipstick= new Lipstick();
   static   Mirror mirror= new Mirror();

   int choice;//选择
    String girlNmae; //使用化妆品的人

   Makeup(int choice,String girlNmae){
        this.choice=choice;
        this.girlNmae=girlNmae;
   }


   @Override
    public void run() {
       // 化妆的逻辑
       makeup();
    }

    // 化妆的方法,拿着自己的锁,还想拿对方的资源
    private void makeup(){
       if (choice==0){
           synchronized (lipstick){ // 获得口红的锁
               System.out.println(this.girlNmae+":获得口红的锁");
                try{Thread.sleep(1000*1);}catch(InterruptedException e){e.printStackTrace();}
                 /* synchronized (mirror){// 获取口红的锁
                      System.out.println(this.girlNmae+":获取镜子的锁");
                  }*/
           }
           // 放在外面,解决死锁问题
           synchronized (mirror){// 获取口红的锁
               System.out.println(this.girlNmae+":获取镜子的锁");
           }
       }else {
           synchronized (mirror){ // 获得口红的锁
               System.out.println(this.girlNmae+":获取镜子的锁");
               try{Thread.sleep(1000*1);}catch(InterruptedException e){e.printStackTrace();}
               /*synchronized (lipstick){// 获取口红的锁
                   System.out.println(this.girlNmae+":获得口红的锁");
               }*/
           }
           // 放在外面,解决死锁问题
           synchronized (lipstick){// 获取口红的锁
               System.out.println(this.girlNmae+":获得口红的锁");
           }
       }
    }
/** 发生死锁, 等待对方释放
 * 灰姑娘:获得口红的锁
 * 白雪公主:获取镜子的锁
 */
}