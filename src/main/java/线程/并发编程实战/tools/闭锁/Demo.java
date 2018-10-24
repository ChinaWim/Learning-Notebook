package 线程.并发编程实战.tools.闭锁;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;

/**
 * @author m969130721@163.com
 * @date 18-6-13 下午6:13
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new MyThread(countDownLatch)).start();
        }
        countDownLatch.await();
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }

}

class MyThread implements Runnable {
    private CountDownLatch countDownLatch;

    public MyThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}




