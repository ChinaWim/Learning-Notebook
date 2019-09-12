package 算法.牛客网.有赞;

import java.util.Scanner;

public class 字符串旋转 {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String input = cin.next();
        String[] strArray = input.split(";");
        String str1 = strArray[0];
        String str2 = strArray[1];

        if (str1.length() != str2.length()) {
            System.out.println(false);
        } else {
            boolean isTrue = false;
            for (int i = 0; i < str1.length(); ++i) {
                String left = str1.substring(0, i + 1);
                String right = "";
                if (i != str1.length() - 1) {
                    right = str1.substring(i + 1);
                }
                String newStr = right.concat(left);
                if (newStr.equals(str2)) {
                    isTrue = true;
                    System.out.println(true);
                    break;
                }
            }
            if (!isTrue) {
                System.out.println(false);
            }
        }
    }

}
