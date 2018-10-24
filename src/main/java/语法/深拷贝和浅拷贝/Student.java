package 语法.深拷贝和浅拷贝;

/**
 * @author m969130721@163.com
 * @date 18-6-13 下午11:30
 */
public class Student implements Cloneable {

    private Car car;

    private String name;

    private Integer age;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "car=" + car +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student student = null;
        student = (Student) super.clone();
        student.setCar(this.getCar().clone());
        return student;
    }
}
