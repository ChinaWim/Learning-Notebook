package 算法.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 缺失的第一个正数
 */
public class Leetcode41 {

    public int firstMissingPositive(int[] nums) {

        HashSet<Integer> values = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0){
                values.add(nums[i]);
            }
        }
        if(values.size() > 0){
            int p = 1;
            while(p != 0){
                if(values.contains(p)){
                    p++;
                }else {
                    return p;
                }
            }
            return p;
        }else {
            return 1;
        }

    }


    public static void main(String[] args) {
        Leetcode41 demo = new Leetcode41();
        System.out.println(demo.firstMissingPositive(new int[]{7,8,9,11,12}));
    }


}
