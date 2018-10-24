package 设计模式.单例模式;

import org.junit.Test;

/**
 * 饿汉
 *
 * @author m969130721@163.com
 * @date 18-6-14 下午4:52
 */
public class Demo1 {
    private static Demo1 demo1 = new Demo1();

    private Demo1() {

    }

    public static Demo1 getInstance() {
        return demo1;
    }

    public static void main(String[] args) {
        System.out.println(Demo1.getInstance().hashCode());
        System.out.println(Demo1.getInstance().hashCode());
    }
}
