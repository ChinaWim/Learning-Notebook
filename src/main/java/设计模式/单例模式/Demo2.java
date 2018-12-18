package 设计模式.单例模式;

/**
 * 懒汉　线程不安全
 *
 * @author m969130721@163.com
 * @date 18-6-14 下午4:53
 */
public class Demo2 {
    private static Demo2 demo2 = null;

    private Demo2() {

    }

    public static Demo2 getInstance() {
        if (demo2 == null) {
            demo2 = new Demo2();
        }
        return demo2;
    }

    public static void main(String[] args) {
        System.out.println(Demo2.getInstance().hashCode());
        System.out.println(Demo2.getInstance().hashCode());

    }
}
