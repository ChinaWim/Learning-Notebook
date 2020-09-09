package 算法;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

public class Leetcode20 {


    public boolean isValid(String s) {
        if(StringUtils.isBlank(s)){
            return true;
        }
       Stack<Character> result = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                result.push(s.charAt(i));
            }else {
                if(result.isEmpty()){
                    return false;
                }
                Character pop = result.pop();
                if(!(pop == '(' && s.charAt(i) == ')' ||
                        pop == '{' && s.charAt(i) == '}' ||
                        pop == '[' && s.charAt(i) == ']')){
                    return false;
                }
            }
        }
            return result.isEmpty();
    }


}
