package 线程.并发编程实战.生产者消费者.多种实现方式;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用阻塞队列实现
 *
 * @author m969130721@163.com
 * @date 18-10-14 上午11:10
 */
public class BlockingQueueDemo {


    public static void main(String[] args) {

        BlockingQueue blockingQueue = new LinkedBlockingQueue(1);
        ProductFactory productFactory = new ProductFactory(blockingQueue);
        Customer customer = new Customer(blockingQueue);
        Thread productFactoryThread = new Thread(productFactory);
        Thread customerThread1 = new Thread(customer);
        Thread customerThread2 = new Thread(customer);

        productFactoryThread.start();
        customerThread1.start();
        customerThread2.start();

    }

}

/**
 * 生产者
 */
class ProductFactory implements Runnable {

    private BlockingQueue<Product> blockingQueue;

    ProductFactory(BlockingQueue<Product> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
            while (true) {
                Product product = new Product("产品");
                try {
//                    System.out.println(Thread.currentThread().getName() + " 生产者生产准备开始.............");
                    blockingQueue.put(product);
                    System.out.println(Thread.currentThread().getName() + " 添加一个产品:" + product);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}

/**
 * 消费者
 */
class Customer implements Runnable {
    private BlockingQueue<Product> blockingQueue;

    Customer(BlockingQueue<Product> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
            try {
//                System.out.println(Thread.currentThread().getName() + " 消费者消费准备开始..............");
                Product product = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + " 取出一个产品:"+product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}


class Product {
    private String name;

    Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}