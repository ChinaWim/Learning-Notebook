package 算法.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Leetcode26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Leetcode26 l = new Leetcode26();
        System.out.println(l.removeDuplicates(nums));
        Arrays.stream(nums).forEach(System.out::print);
    }


    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
              continue;
            } else {
                nums[set.size()] = num;
            }
            set.add(num);
        }
        return set.size();
    }
}
