package 面试.秋招.平安科技;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author m969130721@163.com
 * @date 18-10-10 下午9:14
 */
class Student implements Comparable{
    private String name;

    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof Student == false){
            return -1;
        }
        Student student = (Student)o;
        if(this.score < student.getScore()){
            return 1;
        }else if(this.score > student.getScore()) {
            return -1;
        }else {
            return 1;
        }
    }
}
public class 学生平均成绩排序 {

    public static void main(String[] args) {
        TreeSet<Student> studentTreeSet = new TreeSet<>();
        Scanner cin = new Scanner(System.in);
        Student student = null;
        int p = 1;
        int sum = 0;
        int step = 0;
        while (cin.hasNext()) {
            String next = cin.next();
            try{
                int score = Integer.parseInt(next);
                sum += score;
                step ++;
            }catch (Exception e){
                if(p != 1){
                    int avg = (int)Math.round(sum / (step*1.0));
                    sum = 0;
                    step = 0;
                    student.setScore(avg);
                    studentTreeSet.add(student);
                }
                //初始化student
                student = new Student();
                student.setName(next);
                p++;
            }
        }
        int avg = (int)Math.round(sum / (step*1.0));
        student.setScore(avg);
        studentTreeSet.add(student);

        Iterator<Student> iterator = studentTreeSet.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            System.out.println(s.getName()+" "+s.getScore());
        }
    }



}
