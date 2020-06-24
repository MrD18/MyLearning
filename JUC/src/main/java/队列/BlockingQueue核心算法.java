package 队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: duhao
 * @date: 2020/6/17 10:00
 */
public class BlockingQueue核心算法 {

    public static void main(String[] args) throws InterruptedException {
       BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        /**
         * 1.抛出异常
         * add方法,向已经满的队列中添加元素时,会抛出异常
         */
//        System.out.println(arrayBlockingQueue.add("a"));
//        System.out.println(arrayBlockingQueue.add("b"));
//        System.out.println(arrayBlockingQueue.add("c"));
//     //   System.out.println(arrayBlockingQueue.add("xxxxxxx")); // 因为已经满了,就抛出异常
//        System.out.println(arrayBlockingQueue.remove());
//        System.out.println(arrayBlockingQueue.remove());
//        System.out.println(arrayBlockingQueue.remove());
//        System.out.println(arrayBlockingQueue.remove());// 已经为空了,在移除就报错
        /**
         * 2.返回布尔类型
         * 使用offer方法进行添加,如果阻塞队列满了,会返回false,否则为true
         * poll方法 取得时候,如果队列为空, 那么就返回null
         */
//        System.out.println(arrayBlockingQueue.offer("a"));
//        System.out.println(arrayBlockingQueue.offer("b"));
//        System.out.println(arrayBlockingQueue.offer("c"));
//        System.out.println(arrayBlockingQueue.offer("dddddd"));// 返回false
//
//        System.out.println(arrayBlockingQueue.poll());
//        System.out.println(arrayBlockingQueue.poll());
//        System.out.println(arrayBlockingQueue.poll());
//        System.out.println(arrayBlockingQueue.poll()); // 取null
        /**
         * 3.阻塞队列组
         * put方法 添加时,如果阻塞队列满了,添加消息线程会一直阻塞,直到队列元素减少,会被清空,才会唤醒
         * RabbitMQ 会用到,保证消息100% 100% 不丢失, 让它阻塞
         */
//      arrayBlockingQueue.put("a");
//      arrayBlockingQueue.put("b");
//      arrayBlockingQueue.put("c");
//        System.out.println("===============");
//        System.out.println( arrayBlockingQueue.take());
//        System.out.println( arrayBlockingQueue.take());
//        System.out.println( arrayBlockingQueue.take());
//        System.out.println( arrayBlockingQueue.take());// 取第4个时候发生阻塞
        /**
         * 4. 不见不散系列
         * offer(), poll()加时间
         * 使用offer插入的时候，需要指定时间，如果2秒还没有插入，那么就放弃插入
         * 同时取的时候也进行判断,如果2秒内取不出来，那么就返回null
         *
         */
        System.out.println(arrayBlockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer("b",2L, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer("c",2L, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer("d",2L, TimeUnit.SECONDS));// 限制了3个,放入第4个时候阻塞2s 时,返回false
        System.out.println(arrayBlockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2L,TimeUnit.SECONDS));//等待2s 没有取出来 就返回null


    }

}
