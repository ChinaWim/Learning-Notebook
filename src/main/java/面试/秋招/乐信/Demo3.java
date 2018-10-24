package 面试.秋招.乐信;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author m969130721@163.com
 * @date 18-10-13 下午4:11
 */
public class Demo3 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String string = cin.next();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        int maxNum = Integer.MIN_VALUE;
        char maxChar = '0';
        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() > maxNum) {
                maxNum = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        StringBuilder resultString = new StringBuilder();
        for (int i = 0 ; i < maxNum; i ++) {
            resultString.append(maxChar);
        }
        for (int i = 0; i < string.length(); i ++) {
            if (string.charAt(i) != maxChar){
                resultString.append(string.charAt(i));
            }
        }
        System.out.println(resultString.toString());
    }
}
