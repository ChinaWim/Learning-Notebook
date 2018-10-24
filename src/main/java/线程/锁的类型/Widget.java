package 线程.锁的类型;

/**synchronized默认是重入锁
 * @author m969130721@163.com
 * @date 18-6-3 下午9:51
 */
public class Widget {

    public synchronized void doSomething() {
        System.out.println("Hello World!");
    }
}

class LoggingWidget extends Widget {

    public static void main(String[] args) {
        LoggingWidget loggingWidget = new LoggingWidget();
        loggingWidget.doSomething2();

    }

    public synchronized void doSomething2() {
        super.doSomething();
        System.out.println("doSomething2");
    }


}

