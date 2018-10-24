package 面试.秋招.迅雷;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 计算勾股数 - 后台开发工程师
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 勾股数，是由三个正整数组成的数组；
 * 能符合勾股定理 a*a + b*b = c*c ， (a, b, c) 的正整数解。
 * 如果 (a, b, c) 是勾股数，它们的正整数倍数，也是勾股数。如果 (a, b, c) 互质，它们就称为素勾股数。
 * 给定正整数N，计算出小于或等于N的素勾股数个数。(0 < a <= b <= c <= N)
 *
 *
 * 输入
 * 正整数N
 *
 * 输出
 * 小于或等于N的素勾股数个数
 *
 * 样例输入
 * 10
 * 样例输出
 * 1
 *
 * (0 < a <= b <= c <= N)
 * @author m969130721@163.com
 * @date 18-9-12 下午8:13
 */
public class Test2 {

    static int box[] = new int [1000];
    static int array[] = new int [10];
    static int count = 0;
    static int N;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        N = cin.nextInt();
        dfs(0,1);
        System.out.println(count);

    }


    public static void dfs(int step,int pos){
        if (step == 3){
            System.out.println("array " + array[0] +" " + array[1] + " "+array[2]);
            int result1 = array[0]*array[0] + array[1]*array[1];
            int result2 = array[2]*array[2];
            if(result1 == result2) {
                count++;
            }
            return;
        }
        for (int i = pos; i < N;i++){
            if (box[i] == 0){
                box[i] = 1;
                array[step] = i;
                dfs(step + 1,pos + 1);
                box[i] = 0;
            }
        }

    }



}
