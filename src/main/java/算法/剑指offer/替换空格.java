package 算法.剑指offer;

import java.util.Scanner;

/**
 * @author m969130721@163.com
 * @date 18-9-27 下午7:18
 */
public class 替换空格 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String string = cin.nextLine();
        boolean blankFlag = false;
        boolean firstFlag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < string.length(); i++) {
            if (string.charAt(i) == ' '){
                if(firstFlag){
                   blankFlag = true;
                   firstFlag = false;
                }
                if (blankFlag) {
                    blankFlag = false;
                    sb.append("%20");
                }
            }else {
                firstFlag = true;
                sb.append(string.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
