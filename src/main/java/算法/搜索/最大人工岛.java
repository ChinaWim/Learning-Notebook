package 算法.搜索;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author m969130721@163.com
 * @date 18-8-19 下午7:39
 */
public class 最大人工岛 {

    static int[][] box = new int [50][50];
    static int[][] grid = new int [50][50];
    static int[][] dire = {{0,1},{1,0},{-1,0},{0,-1}};
    static int max = 0;
    static int N;
    static boolean flag = true;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        N = cin.nextInt();
        for(int i = 0;i < N; i++){
            for(int j = 0;j < N; j++){
                grid[i][j] = cin.nextInt();
            }
        }
        for(int i = 0;i < N; i++){
            for(int j = 0;j < N; j++){
                box[i][j] = 1;
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    flag = false;
                    dfs(i,j,1);
                    grid[i][j] = 0;
                    flag = true;
                }else {
                    dfs(i,j,1);
                }
                box = new int[50][50];
            }
        }
        System.out.println(max);
    }

    public static void dfs(int x, int y, int step) {
        max = Math.max(step,max);
        for (int i = 0; i < dire.length; i++) {
            int next_x = x + dire[i][0];
            int next_y = y + dire[i][1];
            if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= N) continue;
            if (box[next_x][next_y] == 1) continue;
            if (grid[next_x][next_y] == 0 && !flag) continue;
            box[next_x][next_y] = 1;
            if (flag && grid[next_x][next_y] == 0){
                flag = false;
                grid[next_x][next_y] = 1;
                dfs(next_x,next_y,step + 1);
                flag = true;
                grid[next_x][next_y] = 0;
            }else{
                dfs(next_x,next_y,step + 1);
            }
        }
    }
}
