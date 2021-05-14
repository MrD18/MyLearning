package Java并发编程基础.狂神说.线程不安全的Demo;

/** 取钱不安全的方法
 * @author: duhao
 * @date: 2021/4/21 19:26
 */
public class UnSafeBank {
    public static void main(String[] args) {
        // 账户
        Account account = new Account(70,"结婚基金");

        Drawing you = new Drawing(account, 50, "你");
        Drawing girlFriend = new Drawing(account, 50, "你媳妇");

        you.start();
        girlFriend.start();

    }


}

// 账户
class Account{
    int money;//余额
    String name;//卡名
    public  Account( int money, String name){
        this.money=money;
        this.name=name;
    }
}

// 银行: 模拟取钱
class Drawing extends Thread{

    Account account; //账户
    int drawingMoney;// 取了多少钱
    int nowMoney;// 现在手里还有多少钱

   public Drawing(Account account,int drawingMoney,String name){
       super(name);
       this.account=account;
       this.drawingMoney=drawingMoney;

   }

    // 取钱
    // 同步方法: 锁的是这个this对象(这个类本身), 粒度比较大,
    @Override
    public void run() {
      // 同步代码块: 锁的是涉及要变化的量,需要增删改的对象,比如这里面的account
       synchronized (account){
           // 判断有没有钱
           if (account.money-drawingMoney<0){
               System.out.println(Thread.currentThread().getName()+"-->钱不够,取不了..");
               return;
           }

           // 来个延迟
           try{Thread.sleep(1000*1);}catch(InterruptedException e){e.printStackTrace();}

           // 卡内余额= 金额-你取的钱
           account.money=account.money-drawingMoney;
           // 你手里面的钱
           nowMoney=nowMoney+drawingMoney;
           System.out.println(account.name+"余额为:"+account.money);
           System.out.println(this.getName()+"手里面的钱:"+nowMoney);


       }

    }
}