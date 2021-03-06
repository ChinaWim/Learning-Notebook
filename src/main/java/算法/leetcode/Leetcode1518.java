package 算法.leetcode;

/**
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * 请你计算 最多 能喝到多少瓶酒。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-bottles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode1518 {
    public static void main(String[] args) {
        Leetcode1518 a = new Leetcode1518();
        System.out.println(a.numWaterBottles(9, 3));
    }
    public int numWaterBottles(int numBottles, int numExchange) {
       int numBottlesTemp = numBottles;
       int sum = numBottles;
       int exchange = (numBottlesTemp / numExchange);
       while(exchange != 0){
           exchange = (numBottlesTemp / numExchange);
           numBottlesTemp = exchange + (numBottlesTemp % numExchange);
           sum += exchange;
       }
       return sum;
    }

    /**
     * (numBottles * numExchange-1)/(numExchange-1);
     * 一个空瓶价值为1的话，numBottles * numExchange为总价值，至少一个空瓶最后留在手里换不了，所以总价值-1，numExchange-1为一份酒的价值,。
     * O(1)数学解法
     */

}
