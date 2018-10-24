package 算法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author m969130721@163.com
 * @date 18-6-4 下午1:23
 */
public class 选择排序 {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                array[maxIndex] ^= array[i];
                array[i] ^= array[maxIndex];
                array[maxIndex] ^= array[i];
            }
        }
        Arrays.stream(array).forEach(System.out::print);
    }
}
