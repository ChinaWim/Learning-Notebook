package 线程.并发编程实战;

/**
 * 线程安全问题又叫缓存一致性问题
 *
 * @author m969130721@163.com
 * @date 18-10-7 下午1:26
 */
public class ThreadSafeQuestion {
    public int num = 100;

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeQuestion a = new ThreadSafeQuestion();
        new Thread(new Runnable1(a)).start();
        new Thread(new Runnable1(a)).start();
        Thread.sleep(2000);


    }

}


class Runnable1 implements Runnable {
    ThreadSafeQuestion a;

    Runnable1(ThreadSafeQuestion a) {
        this.a = a;
    }
    @Override
    public void run() {
        synchronized (a){
            while(a.num >= 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(a.num);
                a.num --;
            }
        }
    }
}
