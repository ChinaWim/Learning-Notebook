package 算法.leetcode;

import java.util.*;

public class Leetcode38 {

    public String countAndSay(int n) {
        ArrayList<String> answer = new ArrayList<>();
        String answer1 = "1";
        answer.add(answer1);
        for(int i = 1; i < n ; i++){
            String preAnswerStr = answer.get(i - 1);
            StringBuilder preFinalAnswerStr = new StringBuilder();
            char preChar = preAnswerStr.charAt(0);
            for(int l = 0; l < preAnswerStr.length(); l ++){
                char data = preAnswerStr.charAt(l);
                if(l != 0 && preChar == data){
                   continue;
                }
                preFinalAnswerStr.append(data);
                preChar = data;
            }
            String preFinalAnswerFinalStr = preFinalAnswerStr.toString();
            StringBuilder finalAnswer = new StringBuilder();
            int index = 0;
            for(int j = 0; j < preFinalAnswerFinalStr.length(); j++){
                int count = 0;
                for(int k = index; k < preAnswerStr.length() ; k++){
                    if(preFinalAnswerFinalStr.charAt(j) != preAnswerStr.charAt(k)){
                        index = k;
                       break;
                    }
                    count++;
                }
                finalAnswer.append(count).append(preFinalAnswerFinalStr.charAt(j));
            }
            answer.add(finalAnswer.toString());
        }
        return answer.get(n);
    }



    public static void main(String[] args) {
        Leetcode38 demo = new Leetcode38();
//        111221
        System.out.println(demo.countAndSay(5));

    }
}
