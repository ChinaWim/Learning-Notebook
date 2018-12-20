package 设计模式.单例模式.复习;


/*内部类
 * @author m969130721@163.com
 * @date 18-9-23 上午10:29
 */
public class Demo3 {


    private static class InnerClass {
        private static Demo3 demo3 = new Demo3();
    }

    public static Demo3 getInstance() {
        return InnerClass.demo3;
    }

}
