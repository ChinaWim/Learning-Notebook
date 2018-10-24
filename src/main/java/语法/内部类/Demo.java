package 语法.内部类;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 成员内部类，局部内部类
 *
 * @author m969130721@163.com
 * @date 18-6-14 下午5:11
 */
public class Demo {
    public class Inner {
        private Integer age;
        private String name;
//        private static String sex; 编译错误
    }

    public static class StaticInner {
        private Integer age;
        private String name;
        private static String sex;
        public static String publicSex;
    }

    private static Integer age;
    private String name;

    public void method() {
        Inner inner = new Inner();
        String sex = StaticInner.sex;//在方法里跟普通类使用
    }

    public static void staticMethod() {

    }


    public static void main(String[] args) {//静态方法
        Demo demo = new Demo();
//        StaticInner staticInner = new StaticInner();


    }
}

class Outer {
    public void method() {
        Demo demo = new Demo();

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Demo.Inner inner = demo.new Inner();
        Demo.StaticInner staticInner = new Demo.StaticInner();

    }
}





