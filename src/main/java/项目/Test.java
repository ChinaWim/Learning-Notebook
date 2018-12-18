package 项目;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-11 上午10:22
 */
public class Test extends BaseDao<Student>{

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        Student student = new Student();
        student.setAge(11);
        student.setId(1);
        student.setName("student");
        student.setSex("man");
//        test.save(student);
        test.update(student);
        test.save(student);


    }

}
