package 算法.leetcode;

import java.util.LinkedHashSet;

public class Leetcode1365 {



    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] box = new int [101];
        for(int i = 0; i < nums.length; i++){
            box[nums[i]]++;
        }
        int tmp = 0;


        for(int j = 0 ; j < box.length; j ++){
            int tempBox = box[j];
            box[j] = tmp;
            tmp += tempBox;
        }
        int [] result = new int [nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i]  = box[nums[i]];
        }

        return result;
    }
}
