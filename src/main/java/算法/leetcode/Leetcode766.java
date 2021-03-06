package 算法.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int[][] box = new int[21][21];
        for(int i = 0 ; i < matrix.length; i++){
            for (int j = 0; j <matrix[i].length; j++) {
                if(box[i][j] != 0){
                    continue;
                }
                int k = i + 1;
                int l = j + 1;
                List<Integer> rows = new ArrayList<>();
                List<Integer> columns = new ArrayList<>();
                while( k < matrix.length && l < matrix[i].length){
                    if(matrix[k][l] != matrix[i][j]){
                        return false;
                    }
                    rows.add(k);
                    columns.add(l);
                    k ++;
                    l ++;
                }
               for(int i2 = 0 ; i2 < rows.size() ;i2++){
                   box[rows.get(i2)][columns.get(i2)] = 1;
               }
            }
        }
        return true;
    }
}
