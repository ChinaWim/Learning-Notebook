package 算法.剑指offer;

/**
 * 第一题
 */
public class Solution {


    public static boolean Find(int target, int [][] array) {
        for (int i = 0;i < array.length; i ++) {
            for (int j = 0; j < array[i].length; j ++) {
                if (array[i][j] == target){
                    return true;
                } 
                if (array[i][j] < target) {
                    continue;
                }
                if (array[i][j] > target){
                    return false;
                }
                
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] array = new int[][]{
                {2,100,101,102,103},
                {3,4,5,6,7},
                {4,5,6,7,8},
        };
        System.out.println(Find(7,array));
    }
}