package 设计模式.单例模式.复习;

/**懒汉＋双重校验 double-check
 * @author m969130721@163.com
 * @date 18-9-23 上午10:28
 */
public class Demo2 {
    private static volatile  Demo2 demo2;

    public static Demo2 getInstance(){
        if (demo2 == null) {
            synchronized (Demo2.class) {
                if (demo2 == null) {
                    demo2 = new Demo2();
                }
            }
        }
        return demo2;
    }


}
