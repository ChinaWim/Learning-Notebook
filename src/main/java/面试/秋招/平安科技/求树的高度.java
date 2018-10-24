package 面试.秋招.平安科技;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author m969130721@163.com
 * @date 18-10-10 下午9:02
 */
public class 求树的高度 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        HashSet<Integer> hashSet = new HashSet<>();
        while (cin.hasNext()) {
            int parent = cin.nextInt();
            int child = cin.nextInt();
            hashSet.add(parent);
        }
        System.out.println(hashSet.size() - 1);
    }

}
