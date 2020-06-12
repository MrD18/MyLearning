package java锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**ReentrantReadWriteLock其读锁是共享，其写锁是独占
 *  读写锁
 *  多个线程 同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行
 *  但是，如果一个线程想去写共享资源，就不应该再有其它线程可以对该资1源进行读或写
 *
 *
 *  new ReentrantLock();  当加入的是独占锁的话, 写是一个一个的写,但是读的时候也是一个一个读,并不是并发的读
 *  new ReentrantReadWriteLock();  写的时候一个一个写,读的时候则是并发的读,并不是一个一个的读
 * @author: duhao
 * @date: 2020/6/12 9:18
 */
public class ReadAndWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        //创建5个线程进行写的操作
        for(int i=1;i<=5;i++){
            int finalI = i;
            new Thread(()->{
                    myCache.put(finalI +" ", finalI +" ");
               },"Thread:"+i).start();
        }

        // 线程操作资源类, 5个线程读
        for(int i=1;i<=5;i++){
            int finalI = i;
            new Thread(()->{
                 myCache.get(finalI +" ");
               },"Thread:"+i).start();
        }

    }

}

/*资源类
 */
class MyCache{
       private  volatile Map<String,Object> map= new HashMap<>();
     // 定义一个独占锁
      private Lock lock = new ReentrantLock();

    /**
     * 创建一个读写锁
     * 它是一个读写融为一体的锁，在使用的时候，需要转换
     */
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
       // 定义写操作
    public void put(String key,Object value){
     //   lock.lock();
//         rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入:"+key);
            // 模拟说0.3s
            try{Thread.sleep(500);}catch(InterruptedException e){e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写操作完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         //   lock.unlock();
       //    rwLock.writeLock().unlock();
        }
    }
     //  定义读的操作
    public  Object get(String key){
      //  lock.lock();
       // rwLock.readLock().lock();

            System.out.println(Thread.currentThread().getName()+"\t 正在读取");
            try{Thread.sleep(500);}catch(InterruptedException e){e.printStackTrace();}
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+value);


     //        lock.unlock();
//          rwLock.readLock().unlock();
        return value;
    }

    /**
     * 清空缓存
     */
    public  void clean() {
   map.clear();

    }

}