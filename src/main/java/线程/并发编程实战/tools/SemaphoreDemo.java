package 线程.并发编程实战.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**信号量
 * 可以控制某个资源可被同时访问的个数，通过构造函数设定一定数量的许可
 * 通过acquire()获取一个许可，如果没有就等待，而release()释放一个许可．
 *　下面的例子只允许5个线程同时进入执行acquire()和release()之间的代码
 * @author m969130721@163.com
 * @date 18-10-11 下午2:03
 */
public class SemaphoreDemo {


    public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        //只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = () -> {
                try {
                    //获取许可
                    semp.acquire();
                    System.out.println("Accessing: "+NO);
                    Thread.sleep(3000L);
                    //访问完后，释放，如果屏障下面的语句，则在控制台只能
                    //打印５条记录，之后线程一直阻塞
                    semp.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executorService.execute(run);
        }
        executorService.shutdown();
    }

}
