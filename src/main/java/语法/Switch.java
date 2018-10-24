package 语法;

import org.junit.Test;

import java.util.*;

/**
 * @author m969130721@163.com
 * @date 18-6-6 下午3:50
 */
public class Switch {

    @Test
    public void switchMethod() {
        String i = "5";
        switch (i) {
            default:
                System.out.println("default");
            case "1":
                System.out.println("1");
            case "2":
                System.out.println("1");
            case "3":
                System.out.println("1");


        }


    }

    public <T extends List> T method(List<T> list) {


        return null;
    }


    @Test
    public void iterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);


        /*//使用了Arrays.asList（）方法则List的长度固定
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.set(0,2);

        Vector<Integer> vector = new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);


        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(list);
*/
    }


}
