package 算法.leetcode;

public class Leetcode896 {
    public boolean isMonotonic(int[] A) {
        boolean up = false;
        boolean down = false;
        for(int i = 0; i < A.length - 1; i ++){
            if(A[i] > A[i + 1]){
                down = true;
            }
            if(A[i] < A[i + 1]){
                up = true;
            }
            if(up && down){
                return false;
            }
        }
        return true;
    }


}
