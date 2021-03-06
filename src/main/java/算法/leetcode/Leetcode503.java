package 算法.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * [下一个更大元素] 考点：单调栈
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode503 {

    public static void main(String[] args) {
        Leetcode503 abc = new Leetcode503();
        int[] ints = abc.nextGreaterElements2(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 暴力的方法
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            boolean big = false;
            for(int j = ((i+1) % nums.length); j != i; j = ((++j) % nums.length)){
                    if(nums[j] > nums[i]){
                        big = true;
                        result[i] = nums[j];
                        break;
                    }
            }
            if(!big){
                result[i] = -1;
            }
        }
        return result;
    }


    /**
     * 单调栈的解法
     */
    public int[] nextGreaterElements2(int[] nums){
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        int n = nums.length;
        for(int i = 0; i < n * 2; i ++){
            int num = nums[i % n];
            while(!deque.isEmpty() && (num > nums[deque.peekLast()])){
                result[deque.pollLast()] = num;
            }
            if(i < n){
                deque.addLast(i);
            }
        }
         return result;
    }

}
