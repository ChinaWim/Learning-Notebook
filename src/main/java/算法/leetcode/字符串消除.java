package 算法.leetcode;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author m969130721@163.com
 * @date 18-8-19 下午11:14
 */
class Student{
    public int age ;
    public Student(int age){
        this.age = age;

    }
}

public class 字符串消除 {


    public static void main(String[] args) throws InterruptedException {

        ArrayList<Student> list = new ArrayList<Student>();
        Student s = new Student(1);
        list.add(s);
        Student student = list.get(0);
        student.age = 10;
        System.out.println(s.age);




    }
}
