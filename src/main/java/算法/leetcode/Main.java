package 算法.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 查找因子
 *
 * @author m969130721@163.com
 * @date 18-6-5 下午8:34
 */
public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int num = n;
        while (num != 1 && num > 0) {
            for (int i = 2; i <= num; i++) {
                if (i == n) {
                    System.out.println(1);
                }
                if (num % i == 0) {
                    System.out.println(i);
                    num = num / i;
                    break;
                }
            }
        }
    }
}



