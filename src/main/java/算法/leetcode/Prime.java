package 算法.leetcode;

import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/*
 * 筛选法求素数
 */
public class Prime {

    /*public static boolean isPrime(int n){
        for (int i = 2; i < Math.sqrt(n) ; i ++){
            if (n % i == 0 )return false;
        }
        return true;
    }*/

    public static boolean[] printPrime(int from, int to) {
        boolean[] isPrime = new boolean[to + 1];
        isPrime[1] = false;  //true为素数
        isPrime[0] = false;
        Arrays.fill(isPrime, 2, to + 1, true);
        for (int i = 2; i <= Math.sqrt(to); i++) {
//            isPrime(i)
            if (isPrime[i]) { //素数的倍数
                for (int j = i; j * i <= to; j++) {
                    isPrime[j * i] = false; //挖走
                }
            }
        }

        return isPrime;
    }

    public static int fun(int from, int to) {
        int count = 0;
        boolean[] isPrime = printPrime(from, to);
        for (int i = from; i <= to; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println();
        long start = Instant.now().toEpochMilli();
        fun(1, 100);
        long end = Instant.now().toEpochMilli();
        System.out.println(end - start);
    }
}  