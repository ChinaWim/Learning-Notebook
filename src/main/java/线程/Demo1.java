package 线程;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Demo1 {


    @Test
    public void m(){





        double result = 0.1 * 0.1;
        System.out.println(0.1 * 0.1);



    }

    @Test
    public void method() throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println("Hello World");


        };
//        new Thread(runnable).start();

        Callable<String> callable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
            return "Hello World";
        };
        Callable<String> callable2 = new Callable<String>() {
            @Override
            public String call() throws Exception {

                return "123";
            }
        };
        FutureTask future = new FutureTask(callable);
        System.out.println(future.isDone());
        new Thread(future).start();
        Thread.sleep(1000);
        Object o = null;
        try {
            o = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(o);
        System.out.println(future.isDone());
    }

    @Test
    public void method2() throws Exception {

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        FutureTask ftk = new FutureTask(() -> {
            System.out.println("Executor!");
            return "Hello world";
        });
        ses.submit(ftk);
//        ses.shutdown();


    }

    @Test
    public void method3() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 1, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        ExecutorService es = Executors.newFixedThreadPool(10);
        FutureTask futureTask = new FutureTask(() -> {
            System.out.println("123");
            return "Hello World";
        });
        es.submit(futureTask);
        long l = TimeUnit.MILLISECONDS.toMillis(1000);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(l);

       /* es.submit(() -> {
            System.out.println("Hello World!2");
            for (int i = 0; i < 10; i++) {

                System.out.println(Thread.currentThread().getName() +" " +i);
            }
            return "1234";
        });*/
      /*  es.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() +" " +i);
            }
            System.out.println("Hello World!5");
            return "1234";
        });*/


        /*        System.out.println(future.get());*/

    }

    @Test
    public void method4() {

        //intern() 可以理解为拿常量池里的字符串，若有则返回池里的字符串，没有则加入到池里，返回此String对象的引用
        String string1 = new String("123");

//        String string6 = "123";


        System.out.println(string1.intern() == string1);
//        String string2 = "123";
        String string2 = new String("123");
        System.out.println(string1.intern() == string2);
        String string3 = new StringBuilder("软件").append("硬件").toString();
        System.out.println(string3.intern() == string3);

        String string4 = new StringBuilder("java").append("hello").toString();

    }


}
