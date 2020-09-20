package 算法.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for(int i = 0 ; i < candies.length; i ++){
            max = Math.max(max,candies[i]);
        }
        List<Boolean> result = new ArrayList<>();
        for(int i = 0; i < candies.length; i ++){
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
