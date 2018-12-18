package 设计模式.单例模式;

import java.util.Deque;

/**静态内部类
 * @author m969130721@163.com
 * @date 18-6-14 下午4:59
 */
public class Demo4 {
    private Demo4() {

    }


    private static class Demo4Instance {
        private static Demo4 demo4 = new Demo4();
    }

    public static Demo4 getInstance() {
        return Demo4Instance.demo4;
    }

    public static void main(String[] args) {
    }

}
