package 面试.秋招.迅雷;

import java.util.Scanner;

/**
 *
 *
 * 红黑积木求和 - 后台开发工程师
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 有红黑两种颜色的方块积木，红色代表正数A，黑色代表负数B。
 * 选出17块积木排成一排，使得任意相邻7块积木之和都小于0。
 * 如何挑选才能使17块积木之和最大，最大值是多少？
 *
 * 输入
 * 正数A，负数B
 *
 * A和B绝对值小于10000
 *
 * 输出
 * 积木之和的最大值
 *
 * 例输入
 * 10 -61
 * 样例输出
 * 28
 *
 *
 * @author m969130721@163.com
 * @date 18-9-12 下午7:41
 */
public class Test1 {

   static int array[] = new int [2];
   static int result[] = new int [17];

   static  int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int A = cin.nextInt();
        int B = cin.nextInt();
        array[0] = A;
        array[1] = B;

        dfs(0,0);
        System.out.println(MAX);
    }


    public static void dfs(int step,int sum){
        if (sum < MAX) {
            return;
        }
        if (step == 17) {
            for (int i = 0; i < 11 ; i++){
                int tempSum = 0;
                for (int j = i ; j < i + 7; j ++) {
                    tempSum += result[j];
                }
                if (tempSum > 0) {
                    return;
                }
            }
            MAX = Math.max(sum,MAX);
            return;
        }


        result[step] = array[0];
        dfs(step + 1,sum + result[step]);
        result[step] = array[1];
        dfs(step + 1,sum + result[step]);
        result[step] = 0;

    }




}
