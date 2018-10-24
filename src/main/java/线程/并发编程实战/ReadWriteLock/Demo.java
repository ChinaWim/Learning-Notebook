package 线程.并发编程实战.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 写写，读写，//互斥
 * 读读　//不会互斥
 *
 * @author m969130721@163.com
 * @date 18-6-13 下午10:22
 */
public class Demo {

    public static void main(String[] args) {


        ReadWrite readWrite = new ReadWrite();
     /*   //写
        new Thread(() -> {
            readWrite.set((int)(Math.random()*101));
        }).start();*/
        //并发读
        for (int i = 1; i <= 10; i++) {
            final int finalI = i;
            new Thread(() -> readWrite.get(finalI)).start();
        }


    }

}

class ReadWrite {
    private Integer number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get(Integer times) {
        lock.readLock().lock();
        try {
            if (times == 1) {
                Thread.sleep(1000); //读读能并发访问
            }
            System.out.println(Thread.currentThread().getName() + "---－读：" + number);
        } catch (InterruptedException e) {
        } finally {
            lock.readLock().unlock();
        }
    }

    public void set(Integer number) {
        try {
//            Thread.sleep(1000);
            lock.writeLock().lock();
//            Thread.sleep(1000);//放在这里的时候读锁也不能进入　读写互斥
            this.number = number;
            System.out.println(Thread.currentThread().getName() + "----写");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }

}


