package 线程.死锁;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author m969130721@163.com
 * @date 18-9-14 下午8:25
 */
public class Demo1 {
    private static  final Object left = new Object();

    private static final Object right = new Object();

    private static void left(){
        synchronized(left) {
            synchronized(right) {
                System.out.println("left啦");
            }
        }
        System.out.println("left结束啦");
    }

    private static void right(){
        synchronized(right) {
            synchronized(left) {
                System.out.println("right啦");
            }
        }
        System.out.println("right结束啦");
    }


    public static void main(String[] args) throws InterruptedException {
//        我们都知道 keepAliveTime 指的是当当前线程池中线程大于 corePoolSize 的时候，
//        如果超过 keepAliveTime 还没有新的任务，则释放大于 corePoolSize 部分的线程。
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 2L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));

        executor.execute(()->{
            System.out.println("123");
        });
        executor.execute(()->{
            System.out.println("1234");
        });



/*
        for (int i  =0; i < 10; i++){
            executor.execute(()->{
                left();
            });
            executor.execute(()->{
                right();
            });
        }
        executor.shutdown();
*/

    }
}
