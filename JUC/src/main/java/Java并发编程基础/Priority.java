package Java并发编程基础;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**既然是多线程,那么就应该有优先级
 *
 * 在Java线程中，通过一个整型成员变量priority来控制优先级，优先级的范围从1~10，在线
 * 程构建的时候可以通过setPriority(int)方法来修改优先级，默认优先级是5，优先级高的线程分
 * 配时间片的数量要多于优先级低的线程。
 * @author: duhao
 * @date: 2021/2/20 16:19
 */
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<Job>();
        for (int i = 0; i < 10; i++) {
            int priority=i<5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
             jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart=false;
        TimeUnit.SECONDS.sleep(10);
        notEnd=false;
        for (Job job : jobs) {
            System.out.println("Job Priority : " + job.priority + ", Count:" + job.jobCount);
        }

    }
    static class Job implements Runnable {
        private int priority;
        private long jobCount;
        public Job(int priority) {
            this.priority = priority;
        }
        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}


