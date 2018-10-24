package 线程.并发编程实战.生产者消费者;

/**
 * @author m969130721@163.com
 * @date 18-6-13 下午4:33
 */
public class Demo1 {

    public static void main(String[] args) {
        Boss boss = new Boss(0);
        Consumer consumer = new Consumer(boss);
        Predictor predictor = new Predictor(boss);
        new Thread(predictor, "供给者A").start();
        new Thread(consumer, "消费者A").start();
        new Thread(predictor, "供给者B").start();
        new Thread(consumer, "消费者B").start();
    }


}


class Boss {
    private Integer product;

    public Boss(Integer product) {
        this.product = product;
    }

    /**
     * 消费
     */
    public synchronized void saleProduct() {
        try {
            while (product <= 0) {
                //使用while去掉虚假唤醒问题（
                // 防止notifyAll的时候product--多或＋多，所以循环判断一下product!）
                System.out.println(Thread.currentThread().getName() + "----(等待状态)----产品缺少");
                this.wait();
            }
            product--;
            System.out.println(Thread.currentThread().getName() + "------" + product);
            this.notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生产
     */
    public synchronized void inProduct() {
        try {
            while (product >= 1) {
                System.out.println(Thread.currentThread().getName() + "----(等待状态)----产品已满");
                this.wait();
            }
            product++;
            System.out.println(Thread.currentThread().getName() + "-------" + product);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}


class Consumer implements Runnable {
    private Boss boss;

    public Consumer(Boss boss) {
        this.boss = boss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            boss.saleProduct();
        }
    }
}


class Predictor implements Runnable {
    private Boss boss;

    public Predictor(Boss boss) {
        this.boss = boss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            boss.inProduct();
        }
    }
}

