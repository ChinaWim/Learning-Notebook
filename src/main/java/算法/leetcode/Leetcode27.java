package 算法.leetcode;

public class Leetcode27 {

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int count = 0;
        int p = nums.length;
        boolean temp = true;
        while(temp){
            boolean temp2 = false;
            for(int i = 0; i < p ; i ++){
                if(nums [i] == val){
                    int index = p - 1;
                    nums [i] = nums[index];
                    p -- ;
                    count ++;
                    temp2 = true;
                    break;
                }
            }
            if(!temp2){
                break;
            }

        }
        return nums.length - count;
    }


    public static void main(String[] args) {
        Leetcode27 a = new Leetcode27();
        int []nums = new int []{0,1,2,2,3,0,4,2};
        int count = a.removeElement(nums, 0);
        for(int i = 0 ; i < count ; i++){
            System.out.print(nums[i] +" ");
        }
    }
}
