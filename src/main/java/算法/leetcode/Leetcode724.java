package 算法.leetcode;

public class Leetcode724 {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int p = 0;
       for(int i = 0; i < nums.length; i++){
           if((sum - p - nums[i]) == p ){
                return i;
           }
           p+=nums[i];
       }
        return -1;
    }
}
