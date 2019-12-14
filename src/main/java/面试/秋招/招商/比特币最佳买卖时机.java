package 面试.秋招.招商;

import java.util.Scanner;

public class 比特币最佳买卖时机 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        String[] array = str.split(" ");

        int maxValue = 0;
        for (int i = 0; i < array.length; i++) {
            int numFirst = Integer.parseInt(array[i]);
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < array.length; j++) {
                int num = Integer.parseInt(array[j]);
                if (max < num) {
                    max = num;
                }
            }
            if (numFirst <= max && (max - numFirst) > maxValue) {
                maxValue = max - numFirst;
            }
        }
        System.out.println(maxValue);
    }
}
