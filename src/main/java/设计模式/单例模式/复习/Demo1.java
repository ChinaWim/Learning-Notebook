package 设计模式.单例模式.复习;

/**饿汉
 * @author m969130721@163.com
 * @date 18-9-23 上午10:27
 */
public class Demo1 {
    private static Demo1 demo1 = new Demo1();

    public static Demo1 getInstance(){
        return demo1;
    }

}
