package 算法.leetcode;


public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i ++){
            int data = nums[i];
            if(target == data){
                return i;
            }
            if(target < data){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Leetcode35 demo = new Leetcode35();
        int [] nums = new int []{1,3,5,6,101};
        System.out.println(demo.searchInsert(nums, 100));
    }


}
