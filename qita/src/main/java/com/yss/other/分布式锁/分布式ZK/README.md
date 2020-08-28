### 模板模式

#### 概念

在模板模式（Template Pattern）设计模式中，用一个抽象类公开定义了执行它的方法的方式、模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行

意图：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构，即可重定义该算法的某些特定步骤：

主要解决：一些方法通用，却在每个子类都重新写了这一方法

何时使用：在一些通用的方法

如何解决：将这些通用算法抽象出来

关键代码：在抽象父类中实现通用方法，其它步骤下放到子类中实现

#### 应用实例

- 西游记里面菩萨定义好了81难，不管是女儿国，或者蜘蛛精，只需要有81劫难，这就是一个顶层的逻辑骨架
- spring中对Hibernate的支持，将一些定好的方法封装起来，比如开启事务，获取Session，关闭Session，程序要不需要重复写那些已经规范好的代码，直接丢一个实体就可以保存。

#### 优缺点

- 封装不变部分，扩展可变部分
- 提取公共代码，便于维护
- 行为由父类控制，子类实现
- 缺点是：每一个不同的实现，都需要一个子类来实现，导致类的个数增加，使得系统变庞大

#### 使用场景

- 有很多子类共有的方法，且逻辑相同
- 重要的、复杂的方法，可以考虑模板方法

### 代码

例如，我们首先定义一个zkLock的接口
/**
 * ZkLock
 * @author: 陌溪
 * @create: 2020-04-03-23:05
 */
public interface ZkLock {

    public void zkLock();

    public void zkUnlock();
}
然后在抽象类中继承该接口，同时实现zkLock 和 zkUnLock的方法

/**
 * ZkLock抽象类
 * 这就是模板设计模式
 *
 * @author: 陌溪
 * @create: 2020-04-03-23:06
 */
public abstract class ZkAbstractTemplateLock implements ZkLock{

    @Override
    public void zkLock() {
        // 尝试获取锁
        if(tryLock()) {
            System.out.println(Thread.currentThread().getName() + "\t 占用锁成功");
        } else {
            // 等待锁
            waitZkLock();
            // 重新调用获取锁的方法
            zkLock();
        }
    }

    /**
     * 定义两个抽象方法，一个是尝试锁，一个是等待锁
     * @return
     */
    public abstract boolean tryLock();

    public abstract void waitZkLock();

    @Override
    public void zkUnlock() {

    }
}
同时我们在抽象类里，又定义了两个抽象方法，zkWaitLock() 和 tryLock

最后我们是具体的实现方法

/**
 * 分布式锁
 *
 * @author: 陌溪
 * @create: 2020-04-03-23:21
 */
public class ZkDistributedLock extends ZkAbstractTemplateLock{
    @Override
    public boolean tryLock() {
        // 判断节点是否存在，如果存在则返回false，否者返回true
        return false;
    }

    @Override
    public void waitZkLock() throws InterruptedException {
        // 等待锁的时候，需要加监控，查询这个lock是否释放

        CountDownLatch countDownLatch = new CountDownLatch(1);

        countDownLatch.await();

        // 解除监听
    }
然后我们通过ZkDistributedLock进行加锁

/**
 * 订单业务逻辑
 *
 * @author: 陌溪
 * @create: 2020-04-03-22:47
 */
public class OrderService {
    private OrderNumberCreateUtil orderNumberCreateUtil = new OrderNumberCreateUtil();

    public void getOrderNumber() {
        ZkLock zkLock = new ZkDistributedLock();
        zkLock.zkLock();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkLock.zkUnlock();
        }
        System.out.println(orderNumberCreateUtil.getOrderNumber());
    }
}
然后在使用多个线程进行操作，而且是在线程里面实例化对象，来进行创建，最终保证每个对象再获取订单的时候，都是唯一的


/**
 * 客户端
 *
 * @author: 陌溪
 * @create: 2020-04-03-22:48
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                new OrderService().getOrderNumber();
                System.out.println(str);
            }, String.valueOf(i)).start();
        }
    }
}