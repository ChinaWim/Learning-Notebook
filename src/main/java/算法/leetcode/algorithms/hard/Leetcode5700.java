package 算法.leetcode.algorithms.hard;

import java.util.HashMap;

//todo
public class Leetcode5700 {
    public static void main(String[] args) {
        Leetcode5700 l = new Leetcode5700();
        System.out.println(l.minChanges(new int[]{1, 2, 3, 4, 5}, 1));
    }
    public int minChanges(int[] nums, int k) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i = 0; i < nums.length - (k - 1); i ++){
            int source = nums[i];
            for(int j = i; j < i + k; j ++){
                source ^= nums[j];
            }
            if(source == 0){
                continue;
            }else {

            }
        }
        return 0;
    }
}
