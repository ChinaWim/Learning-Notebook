package 算法.基础练习题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author m969130721@163.com
 * @date 18-9-25 上午11:43
 */
public class 统计单词个数 {

    static {
        System.out.println("12331");
    }
    public static void main(String[] args) {
        List<String> li = new ArrayList<>();
        String[] objects = (String[])li.toArray();

        System.out.println("Hello World");
        Scanner cin = new Scanner(System.in);
        String string = cin.nextLine();
        System.out.println(getWordCount(string));

    }


    public static int getWordCount(String string) {
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                flag = true;
                continue;
            }
            if (flag) {
                count++;
                flag = false;
            }
        }
        return count;
    }

}
