package 线程.并发编程实战.生产者消费者.多种实现方式;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * 使用信号量实现大小为100的阻塞队列
 *
 * @author m969130721@163.com
 * @date 18-10-14 下午4:43
 */
public class SemaphoreDemo<T> {

    private Semaphore semaphore;

    private LinkedList<T> linkedList = new LinkedList<>();

    SemaphoreDemo(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public boolean put(T t) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = linkedList.add(t);
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public T take() {
        while(true){
            if (!linkedList.isEmpty()) {
                T value = linkedList.poll();
                semaphore.release();
                return value;
            }
        }
    }


    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(10);
        SemaphoreDemo<Integer> semaphoreDemo = new SemaphoreDemo(semaphore);



        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("take :"+semaphoreDemo.take());
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("put :"+i);
                semaphoreDemo.put(i);
            }
        }).start();

    }
}

