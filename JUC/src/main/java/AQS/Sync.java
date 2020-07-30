package AQS;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**AQS
 * @author: duhao
 * @date: 2020/7/30 13:53
 */
public class Sync extends AbstractQueuedLongSynchronizer {

    /**
     * 独占方式, 尝试获取资源,成功则返回true，失败则返回false。
     * @param arg
     * @return
     */
    @Override
    protected boolean tryAcquire(long arg) {
        //使用自旋锁, 同时CAS必须保证原子性
        // 目前的CPU底层汇编都有这条指令了，即支持原语操作
        if (compareAndSetState(0,1)){
            // 设置排它的拥有者，也就是互斥锁
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    /**
     * 独占方式，尝试释放资源，成功则返回true，失败则返回false
     * @param arg
     * @return
     */
    @Override
    protected boolean tryRelease(long arg) {
        assert  arg==1;
        if (!isHeldExclusively()){
             throw new IllegalMonitorStateException();
        }
        //释放锁
        setExclusiveOwnerThread(null);
        setState(0);
        return super.tryRelease(arg);
    }

    /**
     * 共享方式，尝试获取资源。负数表示失败，0表示成功，但没有剩余可用资源；正数表示成功，且有剩余资源。
     * @param arg
     * @return
     */
//    @Override
//    protected long tryAcquireShared(long arg) {
//        return super.tryAcquireShared(arg);
//    }

    /**
     * 共享方式。尝试释放资源，如果允许释放后允许唤醒后续等待节点返回true，否则返回false。
     * @param arg
     * @return
     */
//    @Override
//    protected boolean tryReleaseShared(long arg) {
//        return super.tryReleaseShared(arg);
//    }

    /**
     * 该线程是否是正在独占资源,
     * @return
     */
    @Override
    protected boolean isHeldExclusively() {
        // 判断当前线程 是不是和排它锁的线程一样
       return  getExclusiveOwnerThread()==Thread.currentThread();
    }
}
