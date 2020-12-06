package 线程.慕课并发教程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 线程安全的的并发模拟请求
 */
public  class  AtumoicBooleanThreadSafe {
    /**
     * 客户总数
     */
    private static final Integer CLIENT_COUNT = 100;
    /**
     * 线程总数
     */
    private static final Integer THREAD_COUNT = 5000;

    private static  AtomicBoolean atomicBoolean  = new AtomicBoolean(false);


    private static  void test(){

//        getAndSet和compareAndSet都是线程安全的，适合只需要执行一次的场景
//        if(!atomicBoolean.getAndSet(true)){
//            System.out.println("HelloWorld");
//        }
        if(atomicBoolean.compareAndSet(false,true)){
            System.out.println("HelloWorld");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
        final Semaphore semaphore = new Semaphore(CLIENT_COUNT);
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0; i < THREAD_COUNT; i++){
            executor.execute(()->{
                try{
                    semaphore.acquire();
                    test();
                }catch (Exception e){
                    System.out.println("Exception:"+e);
                }finally {
                    semaphore.release();
                    countDownLatch.countDown();
                }

            });
        }

        countDownLatch.await();
        executor.shutdown();

    }


}
