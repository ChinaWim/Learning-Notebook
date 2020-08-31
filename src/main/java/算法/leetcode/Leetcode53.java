package 算法.leetcode;

public class Leetcode53 {

    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int maxNum = nums[0];
        int tempNum = 0;
        for (int i = 0 ; i < nums.length; i++) {
            tempNum += nums[i];
            if(tempNum > maxNum){
                maxNum = tempNum;
            }
            if(nums[i] > tempNum){
                tempNum = nums[i];
                if(nums[i] > maxNum){
                    maxNum = nums[i];
                }
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        Leetcode53 demo = new Leetcode53();
        System.out.println(demo.maxSubArray(new int[]{8,-19,5,-4,20}));
    }
}
