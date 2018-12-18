package 算法.基础练习题;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 移动数组
 *
 * @author m969130721@163.com
 * @date 18-7-15 下午11:01
 */
public class Array {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int array[] = new int[n];
        int result[] = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = cin.nextInt();
        }
        int size = cin.nextInt();
        for (int i = 0; i < array.length; i++) {
            int index = i + size;
            if (index > (n - 1)) {
                index = index - (n - 1) - 1;
            }
            result[index] = array[i];
        }
        for (int i : result) {
            System.err.print(i + " ");
        }


    }

}
