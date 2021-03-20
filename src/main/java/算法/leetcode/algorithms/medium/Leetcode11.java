package 算法.leetcode.algorithms.medium;

/**
 * [盛最多水的容器]
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 思路：find (max distance and min diff) 2 number，注意已算过的不要重复计算
 */
public class Leetcode11 {

    public static void main(String[] args) {
        Leetcode11 l = new Leetcode11();
        System.out.println(l.maxArea(new int[]{2,0}));

    }

    public int maxArea(int[] height) {
        int max = 0;
        int i =  0;
        while(i < height.length - 1){
            if(height[i] == 0){
                i++;
                continue;
            }
            int p = max / height[i];
            for (int j = p; j < height.length; j ++) {
                max = Math.max(Math.min(height[i],height[j]) * (j - i),max);
            }
            i ++;

        }
        return max;
    }
}
