package 线程.并发编程实战.生产者消费者.多种实现方式;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 两个Condition实现
 *
 * @author m969130721@163.com
 * @date 18-10-14 下午3:11
 */
public class LockDemo {


    public static void main(String[] args) {
        Gift gift = new Gift("礼物", 998, false);
        ReentrantLock reentrantLock = new ReentrantLock();

        //读写分离锁，生产一个，消费者一个
        Condition productCondition = reentrantLock.newCondition();
        Condition customerCondition = reentrantLock.newCondition();


        GiftFactory factory = new GiftFactory(gift, reentrantLock, productCondition, customerCondition);
        SendGift sendGift = new SendGift(gift, reentrantLock, productCondition, customerCondition);


        Thread giftFactory = new Thread(factory);
        Thread sendGift1 = new Thread(sendGift);
        Thread sendGift2 = new Thread(sendGift);
        giftFactory.start();
        sendGift1.start();
        sendGift2.start();

    }


}

class Gift {
    private String name;
    private float price;
    private boolean flag;

    Gift(String name, float price, boolean flag) {
        this.name = name;
        this.price = price;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", flag=" + flag +
                '}';
    }
}


/**
 * 消费者
 */
class GiftFactory implements Runnable {
    private Gift gift;
    private ReentrantLock reentrantLock;
    private Condition productCondition;
    private Condition customerCondition;

    GiftFactory(Gift gift, ReentrantLock reentrantLock, Condition productCondition, Condition customerCondition) {
        this.gift = gift;
        this.reentrantLock = reentrantLock;
        this.productCondition = productCondition;
        this.customerCondition = customerCondition;
    }

    @Override
    public void run() {
        while (true) {
            try {
                reentrantLock.lock();
                //有礼物
                if (gift.isFlag()) {
                    productCondition.await();
                }
                System.out.println("生产gift:" + gift.getName() + ",price:" + gift.getPrice());
                gift.setFlag(true);
                customerCondition.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

}

class SendGift implements Runnable {

    private Gift gift;

    private ReentrantLock reentrantLock;

    private Condition productCondition;

    private Condition customerCondition;

    SendGift(Gift gift, ReentrantLock reentrantLock, Condition productCondition, Condition customerCondition) {
        this.reentrantLock = reentrantLock;
        this.gift = gift;
        this.productCondition = productCondition;
        this.customerCondition = customerCondition;
    }

    @Override
    public void run() {
        try {
            reentrantLock.lock();
            //没有礼物
            if (!gift.isFlag()) {
                customerCondition.await();
            }
            System.out.println("发送gift:" + gift.getName() + ",price:" + gift.getPrice());
            gift.setFlag(false);
            productCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}