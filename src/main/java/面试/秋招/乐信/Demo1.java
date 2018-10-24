package 面试.秋招.乐信;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author m969130721@163.com
 * @date 18-10-13 下午3:13
 */
public class Demo1 {
    static int box[] = new int[100];
    static int xc = Integer.MAX_VALUE;
    static int result = 0;
    static int[] array = new int[3];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String arrayString = cin.nextLine();
        int target = cin.nextInt();
        String numberString = arrayString.substring(1, arrayString.length() - 1);
        String[] numberArray = numberString.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : numberArray) {
            list.add(Integer.parseInt(s));
        }
        dfs(list, 0, 0, target);
        System.out.println(result);
    }

    public static void dfs(ArrayList<Integer> list, int step, int sum, int target) {

        if (step == 3) {
            int dis = Math.abs(sum - target);
            if (dis > xc) {
                return;
            }
            xc = dis;
            result = sum;
            return;
        }


        for (int i = 0; i < list.size(); i++) {
            if (box[i] == 0) {
                box[i] = 1;
                array[step] = list.get(i);
                dfs(list, step + 1, sum + list.get(i), target);
                box[i] = 0;
            }


        }


    }


}
