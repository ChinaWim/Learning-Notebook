package 面试.秋招.迅雷;

import java.util.Scanner;

/**
 * @author m969130721@163.com
 * @date 18-9-12 下午9:45
 */
public class GCD {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        System.out.println(gcd(a,b));
    }
    public static int gcd(int a,int b){
        int number1 = Math.max(a,b);
        int number2 = Math.min(a,b);
        while(number1 % number2 != 0){
            int temp = number2;
            number2  = number1 % number2;
            number1  = temp;
        }
        return number2;
    }


}
