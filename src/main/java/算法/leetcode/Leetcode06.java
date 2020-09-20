package 算法.leetcode;

public class Leetcode06 {

    public int minCount(int[] coins) {
        int count = 0;
        for(int i = 0; i < coins.length; i ++){
            count += coins[i] % 2 + coins[i] / 2;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
