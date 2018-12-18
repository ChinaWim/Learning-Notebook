package jvm.hot;

/**
 * @author m969130721@163.com
 * @date 18-12-11 上午10:47
 */
public class HelloService implements IHelloService{
    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
