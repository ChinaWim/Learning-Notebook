package 反射;

import java.util.Comparator;

/**
 * @author m969130721@163.com
 * @date 18-6-10 下午10:43
 */
@Ming("123")
public class Student extends People implements Comparator, Cloneable {
    private int id;
    public String name;
    private int age;

    private Student() {
        System.out.println("this is student 构造");
    }

    public void study() {
        System.out.println("good good study,day day up");
    }

    private int score() {
        return 100;
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
