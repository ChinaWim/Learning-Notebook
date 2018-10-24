package java8;

public class Student {
    private String name;
    private Integer sno;
    private Integer age;

    public Student(String name, Integer sno, Integer age) {
        this.name = name;
        this.sno = sno;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
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
                "name='" + name + '\'' +
                ", sno=" + sno +
                ", age=" + age +
                '}';
    }
}
