package 面试.秋招.招商;

import 算法.基础练习题.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author m969130721@163.com
 * @date 18-9-25 下午4:21
 */
public class Main {
    private static int box[] = new int [100];
    private static int value[] = new int[100];
    private static int result[] = new int[100];
    private static int n;
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        for(int i = 0; i < n; i++) {
            value[i] = cin.nextInt();
        }
        dfs(0);
        System.out.println(max);

    }

    public static void dfs(int step){
        if (step == 2) {
            int money = result[1] - result[0];
            max = Math.max(money,max);
        }
        if(step >= 4){
            int money = result[1] - result[0] + result[3] - result[1];
            max = Math.max(money,max);
            return;
        }


        for (int i = 0;i < n; i++) {
            if (step > 0 && result[0] > value[i]) continue;
            if (step > 2 && result[2] > value[i]) continue;
            if (box[i] == 0){
                box[i] = 1;
                result[step] = value[i];
                dfs(step + 1);
                box[i] = 0;
            }

        }

    }

}
