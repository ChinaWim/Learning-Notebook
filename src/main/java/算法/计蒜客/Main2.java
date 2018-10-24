package 算法.计蒜客;

import java.util.Scanner;

/**
 * 这个是数的排列(位置不考虑)　比如说　1 2 3 4 5 6  从中任意选３个数求有多少种方式？A6 3  = 120
 */
public class Main2 {
    private static int[] arr = new int[100];
    private static boolean[] map = new boolean[100];
    private static int[] result = new int[100];
    private static int n;
    private static int count;
    private static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入输入数的个数");
        n = sc.nextInt();
        System.out.println("请输入这n个数");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("从中选几个？");
        num = sc.nextInt();
        getCount(0, arr, 0,0);
        System.out.println(count);
    }

    public static void getCount(int sum, int[] arr, int step,int pos) {
//        if (sum > m) return;
        if (step == num) {
            for (int i = 0; i < step; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println("sum:" + sum);
            count ++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!map[i]) {
                map[i] = true;
                result[step] = arr[i];
                getCount(arr[i] + sum, arr, step + 1,0);
                map[i] = false;
            }
        }

    }
}