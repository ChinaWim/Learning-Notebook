package 算法.leetcode;

/**
 * 滑动窗口
 */
public class Leetcode1052 {
    public static void main(String[] args) {
        Leetcode1052 leetcode1052 = new Leetcode1052();
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        System.out.println(leetcode1052.maxSatisfied(customers, grumpy, 1));

    }
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        for(int i = 0; i < customers.length; i ++){
            if(grumpy[i] == 0){
                sum+=customers[i];
            }
        }
        int sumMax = 0;
        for(int i = 0; i < customers.length; i ++){
            int newXsum = 0;
            int oldXsum = 0;

            for(int j = i; j < customers.length && j < i + X ; j ++){
                if(grumpy[j] == 0){
                    oldXsum += customers[j];
                }
                newXsum += customers[j];
            }
            sumMax = Math.max(sumMax,sum - oldXsum + newXsum);
        }
        return sumMax;
    }
}
