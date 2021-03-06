package 算法.leetcode;

public class Leetcode832 {
    public static void main(String[] args) {
        System.out.println(1^1);
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int[][] B = new int[A.length][A[0].length];
        for(int i = 0; i < A.length; i ++){
            int p = 0;
            for(int j = A[i].length - 1; j >= 0; j --){
                B[i][p++] = A[i][j] ^ 1;
            }
        }
        return B;
    }
}
