package 线程.并发编程实战.生产者消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显示锁进行线程通信
 *
 * @author m969130721@163.com
 * @date 18-6-13 下午5:51
 */
public class Demo2 {
    public static void main(String[] args) {
        Worker worker = new Worker(0);
        Consumers consumers = new Consumers(worker);
        Proctor proctor = new Proctor(worker);
        new Thread(consumers, "消费者Ａ").start();
        new Thread(consumers, "消费者Ｂ").start();
        new Thread(proctor, "生产者Ａ").start();
        new Thread(proctor, "生产者Ｂ").start();


    }

}

class Worker {
    private int count;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public Worker(int count) {
        this.count = count;
    }

    /**
     * 供给
     */
    public void get() {
        try {
            lock.lock();
            while (count >= 1) {
                System.out.println("(等待)" + Thread.currentThread().getName() + ":当前count" + count);
                condition.await();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + ":当前count" + count);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 销售
     */
    public void sale() {
        try {
            lock.lock();
            while (count <= 0) {
                System.out.println("(等待)" + Thread.currentThread().getName() + ":当前count" + count);
                condition.await();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + ":当前count" + count);
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

class Proctor implements Runnable {
    private Worker worker;

    public Proctor(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        worker.get();
    }
}

class Consumers implements Runnable {
    private Worker worker;

    public Consumers(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        worker.sale();
    }
}



