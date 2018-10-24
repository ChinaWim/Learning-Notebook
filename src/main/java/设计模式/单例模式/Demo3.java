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

    public static Demo3 getInstance() {
        if (demo3 == null) {
            synchronized (Demo3.class) {
                if (demo3 == null) {
                    demo3 = new Demo3();
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
