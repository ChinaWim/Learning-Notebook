package 设计模式.单例模式;

import java.util.Collections;

/**
 * 懒汉２
 *
 * @author m969130721@163.com
 * @date 18-6-14 下午4:55
 */
public class Demo3 {
    private static volatile Demo3 demo3 = null;

    private Demo3() {
    }

    /**
     * new一个对象分三步走（代码中的 4 step ）
     * 1.memory = allocate() 分配对象的内存空间 （分配空间）
     * 2.ctorInstance() 初始化对象（初始化）
     * 3.instance = memory 设置instance指向刚分配的内存（赋值指向）
     *
     * 如果没有禁止指令重排可能发生1,3,2的执行顺序，这就导致new一个对象可能还没有初始化数据，
     * 被别的线程走到1 step的时候直接返回一个未初始化的对象，导致问题发生。
     *
     *
     * @return
     */
    public static Demo3 getInstance() {
        if (demo3 == null) {//1 step
            synchronized (Demo3.class) { //2 step
                if (demo3 == null) { // 3 step
                    demo3 = new Demo3();// 4 step
                }
            }
        }
        return demo3;
    }

    public static void main(String[] args) {
        System.out.println(Demo3.getInstance().hashCode());
        System.out.println(Demo3.getInstance().hashCode());
    }
}
