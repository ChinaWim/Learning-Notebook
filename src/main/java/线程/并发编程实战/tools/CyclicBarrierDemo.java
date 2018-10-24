package 线程.并发编程实战.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**CyclicBarrier翻译过来就是：循环的屏障，这个类是一个可以重复利用的屏障类.
 * 它允许一组线程相互等待，直到全部到达某个公共屏障点，然后所有的这组线程再同步往后执行．
 * await()函数每被调用依次，计数便会减少1,并阻塞当前线程．当计数减至0，阻塞解除，
 *
 *
 * CountDownLatch和CyclicBarrier的区别？
 * １．CountDownLatch的作用是允许１个线程等待其他线程执行完成之后，它才执行；
 *    而CyclicBarrier则是允许N个线程相互等待到某个公共屏障点，然后这一组线程再同时执行．
 * ２．CountDownLatch的计数器的值无法被重置，这个初始值只能被设置一次，是不能够重用的；
 *    CyclicBarrier是可以重用的．
 *
 *
 *
 * @author m969130721@163.com
 * @date 18-10-11 下午1:24
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3,new TotalTask());
        BillTask worker1 = new BillTask("111",barrier);
        BillTask worker2 = new BillTask("222",barrier);
        BillTask worker3 = new BillTask("333",barrier);
        worker1.start();worker2.start();worker3.start();
        System.out.println("Main thread end!");


    }

    /**
     * 主任务
     */
    static class TotalTask extends Thread {
        @Override
        public void run() {
           System.out.println("所有子任务都执行完了,就开始执行主任务");
        }
    }

    /**
     * 子任务
     */
    static class BillTask extends Thread {

        private String billName;

        private CyclicBarrier barrier;

        public BillTask(String workerName,CyclicBarrier barrier) {
             this.billName = workerName;
             this.barrier = barrier;
        }

        public String getBillName() {
            return billName;
        }

        public void setBillName(String billName) {
            this.billName = billName;
        }

        public CyclicBarrier getBarrier() {
            return barrier;
        }

        public void setBarrier(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("市区:"+billName+"运算开始");
                //模仿第一次运算
                Thread.sleep(1000L);
                //等待所有线程者调用过此函数才能进行后续动作
                barrier.await();
                System.out.println("全部结束,市区:"+billName+"才开始后面的工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }










}
