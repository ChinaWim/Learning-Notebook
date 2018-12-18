package 线程.并发编程实战.tools;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author m969130721@163.com
 * @date 18-12-6 上午9:30
 */
public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(() -> {
            String a = "a";
            try {
                String result = (String) exchanger.exchange(a);
                System.out.println("a 交换数据了" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.execute(() -> {
            String b = "b";
            try {
                String result = (String) exchanger.exchange(b);
                System.out.println("b 交换数据了" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
