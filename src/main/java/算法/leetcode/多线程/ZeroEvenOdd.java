package 算法.leetcode.多线程;

import java.util.concurrent.atomic.AtomicInteger;

public class ZeroEvenOdd {
    private volatile int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }
    private AtomicInteger  atomicX = new AtomicInteger(0);
    private volatile boolean zeroOutFlag = true;
    private volatile boolean oddEvenOutFlag = false;


    // printNumber.accept(x) outputs "x", where x is an integer.
    public  void zero(IntConsumer printNumber) throws InterruptedException {
        while(atomicX.get() <= n){
            if(zeroOutFlag){
                atomicX.incrementAndGet();
                if(atomicX.get() > n){
                    break;
                }
                printNumber.accept(0);
                zeroOutFlag = false;
                oddEvenOutFlag = true;
            }

        }
    }

    public  void odd(IntConsumer printNumber) throws InterruptedException {
        while(atomicX.get() <= n){
            if(oddEvenOutFlag && (atomicX.get() & 1) != 0){
                printNumber.accept(atomicX.get());
                zeroOutFlag = true;
                oddEvenOutFlag = false;
            }
        }
    }

    public   void even(IntConsumer printNumber) throws InterruptedException {
        while(atomicX.get() <= n){
            if(oddEvenOutFlag && (atomicX.get() & 1) == 0){
                printNumber.accept(atomicX.get());
                zeroOutFlag = true;
                oddEvenOutFlag = false;
            }

        }
    }

    public static void main(String[] args) {
//        int a1 = 9 & 1;
//        int a2 = 2 & 1;
//        System.out.println(a1);
//        System.out.println(a2);


        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer intConsumer = new IntConsumer();
        new Thread(() ->{
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() ->{
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() ->{
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
