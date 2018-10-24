package 线程.并发编程实战.BlockingQueue;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 缓存系统的设计。 缓存中的对象， 超过了有效时间， 需要从缓存中移出。 使用一个线程循
 * 环查询 DelayQueue， 一旦能从 DelayQueue 中获取元素时， 表示缓存有效期到了
 *
 * @author m969130721@163.com
 * @date 18-10-14 上午8:50
 */

class Student implements Delayed, Serializable {
    private String username;

    private long endTime;

    Student(String username, long endTime) {
        this.username = username;
        this.endTime = endTime;
    }

    /**
     * 用来判断是否到了截止时间,取数据的时候　底层会自动调用判断
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        long nowTime = Instant.now().toEpochMilli();
        return this.endTime - nowTime;
    }

    /**
     * 按延迟时间排序，然后取数据的时候判断队头元素
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        Student delayedStudent = (Student) o;
        return Long.compare(this.endTime, delayedStudent.endTime);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", endTime=" + endTime +
                '}';
    }
}


/**
 * DelayQueue 内部使用 PriorityQueue 实现的。DelayQueue 是一个使用 PriorityQueue
 * 实现的 BlockingQueue， 优先队列的比较基准值是时间。 本质上即： DelayQueue =
 * BlockingQueue +PriorityQueue + Delayed。
 */
class DelayedTask implements Runnable {

    private DelayQueue<Student> delayQueue = new DelayQueue<>();
    //任务是否上线
    private boolean flag = true;

    public void shangJi(String username, int money) {
        long currentTime = System.currentTimeMillis();
        long endTime = currentTime + 1000 * money;
        Student student = new Student(username, endTime);
        delayQueue.add(student);
        System.out.println(username + "开始上机啦，上机时间是:" + currentTime + "，上了" + money + "元");
    }

    public void xiaJi(Student student) {
        System.out.println(student.getUsername() + "下机啦，下机时间是:" + student.getEndTime());
    }
    @Override
    public void run() {
        while (flag) {
            try {
                System.out.println("检查ing............");
                //阻塞操作，直到队首元素超过有效期
                Student student = delayQueue.take();
                xiaJi(student);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class DelayQueueDemo {

    public static void main(String[] args) {
        System.out.println("任务开始................");
        DelayedTask taskRunnable = new DelayedTask();
        Thread thread = new Thread(taskRunnable);
        //启动一个线程一直去轮询取take
        thread.start();
        long endTime = Instant.now().toEpochMilli();

        taskRunnable.shangJi("Ming1",1);
        taskRunnable.shangJi("Ming2",2);
        taskRunnable.shangJi("Ming3",3);

    }




    private void timeUnitConvertMethod() {
        TimeUnit timeUnit = TimeUnit.DAYS;
        Instant instant = Instant.now();
        long time = instant.toEpochMilli();
        System.out.println(time);
        long convert = timeUnit.convert(time, TimeUnit.MILLISECONDS);
        System.out.println(convert);
    }


}
