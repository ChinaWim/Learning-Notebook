package 算法.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {
    private static Map<String, Integer> dirt = new HashMap<>();

    static {
        dirt.put("I", 1);
        dirt.put("V", 5);
        dirt.put("X", 10);
        dirt.put("L", 50);
        dirt.put("C", 100);
        dirt.put("D", 500);
        dirt.put("M", 1000);
        dirt.put("IV", 4);
        dirt.put("IX", 9);
        dirt.put("XL", 40);
        dirt.put("XC", 90);
        dirt.put("CD", 400);
        dirt.put("CM", 900);
    }

    public int romanToInt(String s) {
        int sum = 0;
        String temp = s;
        for (int i = temp.length() - 1; i >= 0; ) {
            String oneKey = temp.charAt(i) + "";
            if (i != 0) {
                char towChar = temp.charAt(i - 1);
                String towKey = towChar + oneKey;
                if (dirt.containsKey(towKey)) {
                    sum += dirt.get(towKey);
                    i -= 2;
                } else {
                    sum += dirt.get(oneKey);
                    i--;
                }
            } else {
                sum += dirt.get(oneKey);
                i--;
            }
        }

        return sum;
    }


}
