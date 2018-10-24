package 面试.秋招.OPPO;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author m969130721@163.com
 * @date 18-10-12 下午7:46
 */


class MyThread1 implements Runnable{
    private  ThreadDemo threadDemo;
    public MyThread1(ThreadDemo threadDemo){
        this.threadDemo = threadDemo;
    }
    @Override
    public void run() {
        synchronized (threadDemo){
            while(threadDemo.i < 10){
                if(threadDemo.i % 2 != 0){
                    try {
                        threadDemo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+" "+threadDemo.i);
                threadDemo.i ++;
                threadDemo.notify();
            }
        }

    }


}
class MyThread2 implements Runnable{
    private  ThreadDemo threadDemo;
    public MyThread2(ThreadDemo threadDemo){
        this.threadDemo = threadDemo;
    }

    @Override
    public void run() {
        synchronized (threadDemo){
            while(threadDemo.i < 10){
                if(threadDemo.i % 2 == 0){
                    try {
                        threadDemo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+" "+threadDemo.i);
                threadDemo.i ++;
                threadDemo.notify();
            }
        }

    }
}


public class ThreadDemo {
    public int i = 0;
    ThreadDemo(int i){
        this.i = i;
    }
    public static void main(String[] args) {
        for(int i = 1; i <= 12; i ++){
            for(int j = 1; j <= 30 ; j ++){
                if(i*29 + j *24 == 900){
                    System.out.println(i +" "+j);
                }
            }
        }
        ThreadDemo threadDemo = new ThreadDemo(1);
        Thread thread1 = new Thread(new MyThread1(threadDemo));
        Thread thread2 = new Thread(new MyThread2(threadDemo));
        thread1.start();
        thread2.start();


    }
}
