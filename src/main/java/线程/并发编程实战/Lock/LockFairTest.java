package 线程.并发编程实战.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 一、公平锁
 *
 * 1、为什么有公平锁
 *
 * 　　CPU在调度线程的时候是在等待队列里随机挑选一个线程，由于这种随机性所以是无法保证线程先到先得的（synchronized控制的锁就是这种非公平锁）。但这样就会产生饥饿现象，即有些线程（优先级较低的线程）可能永远也无法获取cpu的执行权，优先级高的线程会不断的强制它的资源。那么如何解决饥饿问题呢，这就需要公平锁了。
 *
 * 　　产生饥饿的另一个原因是：某个线程占据资源不释放，那其他需要该资源的线程只能处于无限等待中。在这里我们主要解决第一种饥饿问题。
 *
 * 2、什么是公平锁
 *
 * 　　公平锁可以保证线程按照时间的先后顺序执行，避免饥饿现象的产生。但公平锁的效率比较地，因为要实现顺序执行，需要维护一个有序队列。
 */
public class LockFairTest implements Runnable {
    /**
     *创建公平锁
     */
    private static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockFairTest lft = new LockFairTest();
        Thread th1 = new Thread(lft);
        Thread th2 = new Thread(lft);
        Thread th3 = new Thread(lft);
        th1.start();
        th2.start();
        th3.start();
    }
}