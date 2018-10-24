package java8.方法引用;

import java8.Student;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDeomo {

    @Test
    public void test1() {
        Student student = new Student("1",1,1);

        Supplier<String> supplier = () -> new String("Hello Lambda!");
        String s = supplier.get();
        System.out.println(s);

    }

    @Test
    public void test2() {
        Function<String, String> function = (s -> s.toLowerCase());
        String apply = function.apply("123");
        System.out.println(apply);
    }

    @Test
    public void test3() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("123");
    }

    @Test
    public void test4() {
        Predicate<String> predicate = (s -> s.isEmpty());
        System.out.println(predicate.test("123"));
        System.out.println(predicate.test(""));

    }


}
