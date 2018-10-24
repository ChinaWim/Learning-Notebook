package 语法.深拷贝和浅拷贝;

/**
 * @author m969130721@163.com
 * @date 18-6-13 下午11:30
 */
public class Demo {

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(10);
        student.setName("Ming");
        Car car = new Car();
        car.setMoney(100);
        student.setCar(car);
        try {
            //没重写子类对象的clone方法，就是浅拷贝，深拷贝要重写car的clone
            Student copy = student.clone();

            copy.setName("HAHA");
            copy.getCar().setMoney(999);
            System.out.println(student.hashCode() + " student");
            System.out.println(copy.hashCode() + " copy");

            System.out.println(student.getName().hashCode() + " student的String");
            System.out.println(copy.getName().hashCode() + " copy的String");
            System.out.println(student.getCar().hashCode() + " student的Car");
            System.out.println(copy.getCar().hashCode() + " copy的Car");

            System.out.println(copy + ":copy");
            System.out.println(student + ":student");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }

}
