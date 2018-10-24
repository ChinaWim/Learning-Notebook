package java8;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * lambda Final练习题
 */
public class FinalTest {

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> collect = list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test2() {
        Student student1 = new Student("ming", 1, 2);
        Student student2 = new Student("ming2", 1, 2);
        Student student3 = new Student("ming3", 1, 2);
        List<Student> students = Arrays.asList(student1, student2, student3);
        students = new ArrayList<>();
        Optional<Integer> reduce = students.stream()
                .map(e -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.orElse(0));
    }

    static List<Trader> traders;
    static List<Transaction> transactions;

    @Before
    public void before() {
        Trader trader1 = new Trader("张三", "剑桥");
        Trader trader2 = new Trader("李四", "剑桥");
        Trader trader3 = new Trader("王五", "日本");
        Trader trader4 = new Trader("赵六", "中国");
        Trader trader5 = new Trader("田七", "中国");
        traders = Arrays.asList(trader1, trader2, trader3, trader4, trader5);


        Transaction transaction1 = new Transaction(trader1, 2018, 1000);
        Transaction transaction2 = new Transaction(trader2, 2018, 100);
        Transaction transaction3 = new Transaction(trader3, 2018, 200);
        transactions = Arrays.asList(transaction1, transaction2, transaction3);
    }

    @Test
    public void forEach() {
        PrintStream out = System.out;

        traders.stream().forEach((x) -> out.println(x));
    }


    //1 找出2011发生的所有交易，并按交易额排序（低到高）
    @Test
    public void test3() {

        transactions.stream()
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .filter((t) -> t.getYear() == 2018)
                .forEach(System.out::println);

    }

    //2 交易员都在哪些不同的城市工作过
    @Test
    public void test4() {

        HashSet<String> collect = traders.stream()
                .map(Trader::getCity)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect);
        //2
        traders.stream()
                .map(Trader::getCity)
                .distinct();
    }


    //3.查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test5() {
        traders.stream()
                .filter(x -> x.getCity().equals("剑桥"))
                .sorted((x, y) -> x.getName().compareTo(y.getName()))
                .forEach(System.out::println);
    }

    //4.返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test6() {
        traders.stream()
                .map(Trader::getName)
                .sorted()
                .forEach(System.out::println);
        System.out.println("================================");
        String string = traders.stream()
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining(","));
        System.out.println(string);
        String string2 = traders.stream()
                .map(Trader::getName)
                .sorted()
                .reduce("", String::concat);
        System.out.println(string2);

    }

    //5.有 没有交易在剑桥的交易员的所有交易额
    @Test
    public void test7() {
        Integer integer = transactions.stream()
                .filter(x -> !x.getTrader().getCity().equals("剑桥"))
                .collect(Collectors.summingInt(Transaction::getValue));
        System.out.println(integer);

    }

    //6.打印生活在剑桥的交易员的所有交易额
    @Test
    public void test8() {
        Integer integer = transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("剑桥"))
                .collect(Collectors.summingInt(Transaction::getValue));
        System.out.println(integer);
    }

    //7.所有交易中，最高的交易额是多少
    @Test
    public void test9() {
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue).max(Integer::compareTo);
        System.out.println(max);
    }

    //8 找到交易额最小的交易
    @Test
    public void test10() {
        transactions.stream()
                .sorted((x, y) -> Integer.compare(x.getValue(), y.getValue()))
                .limit(1)
                .forEach(System.out::println);

        Optional<Transaction> min = transactions.stream()
                .min((x, y) -> Integer.compare(x.getValue(), y.getValue()));
        System.out.println(min);

    }


}
