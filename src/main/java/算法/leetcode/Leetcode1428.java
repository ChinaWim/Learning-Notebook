package 算法.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * 滑动窗口
 */
public class Leetcode1428 {

    public static void main(String[] args) {
        int[] nums = new int []{4,2,2,2,4,4,2,2};
        Leetcode1428 l = new Leetcode1428();
        System.out.println(l.longestSubarray(nums, 0));
    }

    public int longestSubarray(int[] nums, int limit) {
        int right = 0;
        int left = 0;
        int i = 0;
        int j = 0;
        int max = nums[0];
        int min = nums[0];
        int result = 0;
        while(right < nums.length){
            if(nums[right] >= max){
                max = nums[right];
                i = right;
            }
            if(nums[right] <= min){
                min = nums[right];
                j = right;
            }
            if(max - min <= limit){
                right ++;
            }else {
             result = Math.max(right - left,  result);
             if(i > j){
                 left = j+1;
             }else {
                 left = i+1;
             }
             i = left;
             j = left;
             max = nums[left];
             min = nums[left];
             right = left;
            }
        }
        result = Math.max(right - left,  result);
        return result;
    }




}
