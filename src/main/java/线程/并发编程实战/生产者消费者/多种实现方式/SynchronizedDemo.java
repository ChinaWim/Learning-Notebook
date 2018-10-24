package 线程.并发编程实战.生产者消费者.多种实现方式;

/**
 * @author m969130721@163.com
 * @date 18-10-14 下午1:59
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
        Food food = new Food("offer",12*14,false);
        FoodFactory foodFactory = new FoodFactory(food);
        EatFood eatFood = new EatFood(food);
        Thread createThread = new Thread(foodFactory);
        Thread eatThread1 = new Thread(eatFood);
        Thread eatThread2 = new Thread(eatFood);

        createThread.start();
        eatThread1.start();
        eatThread2.start();
    }
}

class Food {
    private String name;
    private float price;
    private boolean flag;

    Food(String name,float price,boolean flag){
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
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", flag=" + flag +
                '}';
    }
}

/**
 * 生产者
 */
class FoodFactory implements Runnable {
    private Food food;

    FoodFactory(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (food) {
                //存在
                if (food.isFlag()) {
                    try {
                        food.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                food.setFlag(true);
                System.out.println("生产商品:" + food.getName() + ",价格:" + food.getPrice());
                food.notify();
            }
        }
    }
}

/**
 * 消费者
 */
class EatFood implements Runnable {
    private Food food;

    EatFood(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        synchronized (food) {
            //不存在
            if (!food.isFlag()) {
                try {
                    food.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            food.setFlag(false);
            System.out.println("消费商品:" + food.getName() + ",价格:" + food.getPrice());
            food.notify();
        }
    }
}
