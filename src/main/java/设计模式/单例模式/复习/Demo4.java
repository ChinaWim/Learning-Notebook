package 设计模式.单例模式.复习;

import 语法.内部类.Demo;

/**枚举
 * @author m969130721@163.com
 * @date 18-9-23 上午10:32
 */
public enum Demo4 {
    /**
     *
     */
    getInstance(),
    getInstance2();;
    private Demo1 demo1;
    Demo4() {
        demo1 = new Demo1();
        System.out.println("123");
    }


    public static void main(String[] args) {
        System.out.println(Demo4.getInstance.demo1.hashCode());
    }
}


