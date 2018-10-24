package 线程.并发编程实战.线程池;

import org.junit.Test;
import 语法.Student;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * @author m969130721@163.com
 * @date 18-6-11 下午9:21
 */
class Task implements Runnable {
    private int p;

    public Task(int p) {
        this.p = p;
    }

    @Override
    public void run() {
        System.out.println(p++);
    }
}

public class DemoAll {
    public Student returnMethod(Student student) {
        System.out.println(student.hashCode());
        return student;
    }

    //fixedThreadPool
    @Test
    public void method2() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int p = 1;
        String s = new String("!@3");
        Task task = new Task(p);
        for (int i = 0; i < 10; ++i) {
            executorService.execute(task);
        }
//        executorService.shutdown();
    }

    //cachedThreadPool
    @Test
    public void method() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int p = 1;
        Task task = new Task(p);
        for (int i = 0; i < 10; ++i) {
            executorService.execute(task);
        }
        executorService.shutdown();
    }


    //singleThreadExecutor
    @Test
    public void method3() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        int p = 1;
        Task task = new Task(p);
        executorService.execute(task);
        for (int i = 0; i < 10; ++i) {
            executorService.execute(task);
        }
        executorService.shutdown();
    }


    /**
     * 先判断corePoolSize,再判断阻塞队列,最后判断maximumPoolSize
     * corePolSize 和　maximumPoolSize之间的线程在 keepAliveTime后会自动关闭
     */
    @Test
    public void method4() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,10,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        threadPoolExecutor.execute(()->{
            while (true){

            }
        });
    }




    @Test
    public void copyOnWrite() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            list.add(88);
        }
        System.out.println(list);

    }

}


