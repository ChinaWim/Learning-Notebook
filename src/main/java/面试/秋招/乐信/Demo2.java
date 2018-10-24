package 面试.秋招.乐信;

import java.util.Scanner;

/**
 * @author m969130721@163.com
 * @date 18-10-13 下午3:56
 */
public class Demo2 {
    static int[][] dist = {{0,1},{1,0},{0,-1},{-1,0}};
    static int[][] box = new int[100][100];
    static int sum = 0;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        int[][] array = new int [n][m];
        for (int i = 0; i < n ; i ++) {
            for (int j = 0; j < m ; j ++) {
                array[i][j] = cin.nextInt();
            }
        }
        box[0][0] = 1;
        dfs(array,0,0,0);
        box[0][0] = 0;
        System.out.println(sum);

    }


    public static void dfs(int[][] array,int x,int y,int step){
        if (x == n -1 && y == m - 1) {
            sum ++;
            return;
        }

        for(int i = 0; i < dist.length; i ++) {
            int next_x = x + dist[i][0];
            int next_y = y + dist[i][1];
            if(next_x < 0 || next_x >= n || next_y < 0 || next_y>= m) continue;
            if(array[next_x][next_y] == 1) continue;
            if(box[next_x][next_y] == 0){
                box[next_x][next_y] = 1;
                dfs(array,next_x,next_y,step + 1);
                box[next_x][next_y] = 0;
            }
        }
    }

}
