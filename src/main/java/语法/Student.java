package 语法;

/**
 * @author m969130721@163.com
 * @date 18-5-31 下午9:31
 */
public class Student {

    private String name;

    private int age;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void method() {
        System.out.println("this is student method");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
