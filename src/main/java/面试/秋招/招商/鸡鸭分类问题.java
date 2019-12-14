package 面试.秋招.招商;

import java.util.Scanner;

public class 鸡鸭分类问题 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.next();
        int sum = 0;
        //C
        int cd = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'C') {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == 'D') {
                        cd++;
                    }
                }
            }
        }
        int cc = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'D') {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == 'C') {
                        cc++;
                    }
                }
            }
        }

        System.out.println(Math.min(cc, cd));
    }


}
