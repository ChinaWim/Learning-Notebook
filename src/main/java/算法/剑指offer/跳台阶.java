package 算法.剑指offer;

/**一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（
 * 先后次序不同算不同的结果）。
 * @author m969130721@163.com
 * @date 18-10-10 下午7:50
 */
public class 跳台阶 {
    public static void main(String[] args) {
        跳台阶 a = new 跳台阶();
        System.out.println(a.JumpFloor(10));
    }

    public int JumpFloor(int target) {
        return dfs(0,target);
    }
    public  int dfs(int step,int target){
        int result = 0;
        if (step > target) return 0;
        if (step == target) {
            result ++;
            return result;
        }
        result += dfs(step + 1,target);
        result += dfs(step + 2,target);
        return result;
    }

}
