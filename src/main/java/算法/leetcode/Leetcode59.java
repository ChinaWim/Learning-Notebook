package 算法.leetcode;

import java.util.Arrays;

public class Leetcode59 {

    public int[][] generateMatrix(int n) {
         int[][] result = new int[n][n];
        boolean columnStart = true;
        boolean rowAddStart = true;
        boolean columnAddStart = true;
       int row = 0;
       int column = 0;
        result[0][0] = 1;
       if(n == 1){
           return result;
       }
       int p = 2;
        while(p <= n*n){
            if(columnStart){
                column =  columnAddStart ? column < n - 1 ? ++column : column  : column > 0 ? --column : column;
                if(columnAddStart && (column == n - 1 || result[row][column] != 0)){
                    if(result[row][column] != 0){
                        column --;
                        p--;
                    }
                    columnStart = false;
                    columnAddStart = false;
                }else if(column == 0 || result[row][column] != 0){
                    if(result[row][column] != 0){
                        column ++;
                        p--;
                    }
                    columnStart = false;
                    columnAddStart = true;
                }
            }else {
                row =  rowAddStart ? row < n - 1 ? ++row : row  : row > 0 ? --row : row;
                if(rowAddStart && (row == n - 1 || result[row][column] != 0)){
                    if(result[row][column] != 0){
                        row --;
                        p--;
                    }
                    columnStart = true;
                    rowAddStart = false;
                }else if(row == 0 || result[row][column] != 0){
                    if(result[row][column] != 0){
                        row ++;
                        p--;
                    }
                    columnStart = true;
                    rowAddStart = true;
                }
            }

            result[row][column] = p ++;

        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode59 demo1 = new Leetcode59();
        int[][] ints = demo1.generateMatrix(6);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
      ;
    }

}
