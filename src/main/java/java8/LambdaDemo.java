package java8;

import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;

/**
 * lambda练习题1
 */
public class LambdaDemo {

    @Test
    public void test1() {
        Student student1 = new Student("張三", 1000, 20);
        Student student2 = new Student("李四", 1001, 18);
        Student student3 = new Student("王五", 1002, 30);
        Student student4 = new Student("赵六", 1007, 30);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        Collections.sort(students, (s1, s2) -> {
            if (s1.getAge() == s2.getAge()) {
                return Integer.compare(s1.getSno(), s2.getSno());
            } else
                return Integer.compare(s1.getAge(), s2.getAge());
        });
        students.forEach(System.out::println);

    }

    @Test
    public void test2() {
        StringOperation stringOperation = string -> string.toLowerCase();
        String value = stringOperation.getValue("ABC");
        System.out.println(value);
        stringOperation = string -> string.substring(1, 4);
        String abcd = stringOperation.getValue("ABCD");
        System.out.println(abcd);
    }

    @Test
    public void test3() {
        FunctionInterface2<Long, Integer> f2 = (i, j) -> (int) (i + j);
        Integer value = f2.getValue(1000L, 1000L);
        System.out.println(value);
        f2 = (i, j) -> (int) (i * j);
        Integer value1 = f2.getValue(1000L, 2000L);
        System.out.println(value1);
    }

    @Test
    public void test4() {
        Student student = new Student("ming", 1, 2);
        Supplier<String> supplier = () -> {
            return student.getName();
        };


    }



    @Test
    public void test5(){
        Map<String,Integer> map = new HashMap<>();
        map.put("ming",10);
        map.put("ming2",12);
        map.put("ming3",1);
        TreeMap<String,Integer> treeMap = new TreeMap<>((k1,k2)-> {
            return map.get(k1).compareTo(map.get(k2));
        });
        treeMap.putAll(map);
        for (String s : treeMap.keySet()) {
            System.out.println(s);
        }

    }

}
