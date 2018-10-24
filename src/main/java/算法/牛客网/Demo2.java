package 算法.牛客网;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 又是晴朗的一天，牛牛的小伙伴们都跑来找牛牛去公园玩。
 * 但是牛牛想呆在家里看E3展，不想出去逛公园，
 * 可是牛牛又不想鸽掉他的小伙伴们，于是找来了公园的地图，
 * 发现公园是由一个边长为n的正方形构成的，公园一共有m个入口，
 * 但出口只有一个。公园内有一些湖和建筑，
 * 牛牛和他的小伙伴们肯定不能从他们中间穿过，
 * 所以只能绕行。牛牛想知道他需要走的最短距离并输出这个最短距离。
 * <p>
 * <p>
 * 第一行输入一个数字n(1≤n≤1000)表示公园的边长
 * 接下来会给你一个n*n的公园地图，其中 .
 * 表示公园里的道路，@表示公园的入口，*表示公园的出口，
 * #表示公园内的湖和建筑。
 * 牛牛和他的小伙伴们每次只能上下左右移动一格位置。
 * 输入保证公园入口个数m(1≤m≤10000)且所有的入口都能和出口相连。
 * <p>
 * 输出描述:
 * 输出牛牛需要行走的最短距离。
 * 示例1
 * 输入
 * 10
 * .@....##@.
 * ......#...
 * ...@..#...
 * ###.......
 * ....##..#.
 * ...####...
 *
 * @author m969130721@163.com
 * @...##.... #####.....
 * ..##*####.
 * #.........
 * 输出
 * 16
 * @date 18-6-14 下午7:51
 */
public class Demo2 {

    static int box[][] = new int[1000][1000];
    static int desc[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N;
    static int min = Integer.MAX_VALUE;
    static char[][] array;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        N = cin.nextInt();
        array = new char[N][N];
        for (int i = 0; i < array.length; i++) {
            String line = cin.next();
            for (int j = 0; j < line.length(); j++) {
                array[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == '@') {
                    dfs(i, j, 0);
                    box = new int[N][N];
                }


            }
        }
        System.out.println(min);
    }

    static void dfs(int x, int y, int step) {
        if (step > min) {
            return;
        }
        if (array[x][y] == '*') {
            min = step;
            return;
        }
        for (int i = 0; i < desc.length; i++) {
            int next_x = x + desc[i][0];
            int next_y = y + desc[i][1];
            if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) {
                continue;
            }
            if (box[next_x][next_y] == 1 || array[next_x][next_y] == '#') {
                continue;
            }
            box[next_x][next_y] = 1;
            dfs(next_x, next_y, step + 1);
            box[next_x][next_y] = 0;
        }

    }


}
