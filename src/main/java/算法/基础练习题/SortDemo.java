package 算法.基础练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 排序练习
 *
 * @author m969130721@163.com
 * @date 18-6-4 下午1:03
 */
public class SortDemo {

    public static void quickSort() {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = cin.nextInt();
        }
        quick(array, 0, array.length - 1);
        Arrays.stream(array).forEach(value -> System.out.print(value + " "));
    }

    /**
     * 快排
     * @param array
     * @param left
     * @param right
     */
    public static void quick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int baseNum = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (array[j] >= baseNum && i < j) {
                j--;
            }
            while (array[i] <= baseNum && i < j) {
                i++;
            }
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        array[left] = array[i];
        array[i] = baseNum;

        quick(array, left, i - 1);
        quick(array, i + 1, right);
    }

    /**
     * 选择排序
     */
    public static void select() {
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

    /**
     * 冒泡排序
     */
    public static void maoPao() {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = cin.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    array[j] ^= array[j + 1];
                    array[j + 1] ^= array[j];
                    array[j] ^= array[j + 1];
                }
            }
        }
        Arrays.stream(array).forEach(System.out::print);
    }


    public void monkey() {
        int count = 1;
        for (int i = 9; i >= 1; i--) {
            count = (count + 1) * 2;
        }
        System.out.println(count);
    }

    public static int returnMonkey(int day) {
        if (day == 10) return 1;
        return (returnMonkey(day + 1) + 1) * 2;
    }

    public static long jieChen(long n) {
        if (n == 1) return 1;

        return jieChen(n - 1) * n;
    }

    public static List<Integer> getPrime(int range) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= range; i++) {
            boolean flag = false;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(i);
            }
        }
        return list;
    }

    public static void yanghui(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            array[i][0] = 1;
            array[i][i] = 1;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j <= i - 1; j++) {
                array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 约塞夫环
     *
     * @param n
     */
    public static int yshh(int n) {
        int[] array = new int[n];
        int num = n;
        int count = 0;
        int value = 1;
        while (num > 1) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != 1) {
                    count++;
                    if (count % 3 == 0) {
                        array[i] = 1;
                        num--;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (array[i] == 0) {
                value = i + 1;
                break;
            }
        }
        return value;
    }


    public static void main(String[] args) {
//        maoPao();
//        select();
//        quickSort();
//        getPrime(100).stream().forEach(System.out::println);
//        yanghui(10);
        System.out.println(yshh(6));
    }


}
