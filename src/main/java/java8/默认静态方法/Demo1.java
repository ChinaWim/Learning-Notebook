package java8.默认静态方法;

public class Demo1 extends Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.defaultMethod();
    }

}

class Demo implements DefaultMethod {
    final static void method() {
        System.out.println("this is Switch static method");

    }

    public void defaultMethod() {
        System.out.println("This is class DefaultMethod");
    }
}


interface DefaultMethod extends DefaultMethod2 {
    default void defaultMethod() {
        System.out.println("This is interface DefaultMethod");
    }
}

interface DefaultMethod2 {
    default void defaultMethod() {
        System.out.println("This is interface DefaultMethod");
    }
}
