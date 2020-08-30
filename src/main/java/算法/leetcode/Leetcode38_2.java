package 算法.leetcode;

import java.util.ArrayList;

/**
 * 第二种做法
 */
public class Leetcode38_2 {
    public String countAndSay(int n) {
        ArrayList<String> answer = new ArrayList<>();
        String answer1 = "1";
        answer.add(answer1);
        for(int i = 1; i < n ; i++){
            String preAnswerStr = answer.get(i - 1);
            char pre = preAnswerStr.charAt(0);
            StringBuilder finalAnswer = new StringBuilder();
            for(int j = 0 ; j < preAnswerStr.length(); j++){
                if(j != 0 && pre == preAnswerStr.charAt(j)){
                    continue;
                }
                int count = 0;
                for(int k = j ; k < preAnswerStr.length(); k++){
                    if(preAnswerStr.charAt(k) != preAnswerStr.charAt(j)){
                       break;
                    }
                    count ++;
                }
                pre = preAnswerStr.charAt(j);
                finalAnswer.append(count).append(pre);
            }
            System.out.println(answer);
            answer.add(finalAnswer.toString());
        }
        return answer.get(n - 1);
    }

    public static void main(String[] args) {
        Leetcode38_2 demo2 = new Leetcode38_2();
        System.out.println(demo2.countAndSay(20));
    }

}
