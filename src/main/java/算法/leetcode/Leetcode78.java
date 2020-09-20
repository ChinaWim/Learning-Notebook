package 算法.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] array = new int[nums.length];
        this.dfs(nums,0,0,array,result);
        return result;
    }


    private void dfs(int[] nums,int step,int pos,int [] array,List<List<Integer>> result){
        if(step > nums.length){
            return;
        }
        List<Integer> stepData = new ArrayList<>();
        for(int j = 0; j < step ; j++){
            stepData.add(array[j]);
        }
        result.add(stepData);
        for(int i = pos; i < nums.length; i ++){
           array[step] = nums[i];
           dfs(nums,step + 1,i + 1,array,result);
        }

    }

    public static void main(String[] args) {
        Leetcode78 leetcode78 = new Leetcode78();
        List<List<Integer>> subsets = leetcode78.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);

    }
}
