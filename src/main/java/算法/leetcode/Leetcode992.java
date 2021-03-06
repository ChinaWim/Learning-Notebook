package 算法.leetcode;

/**
 * K个不同整数的子数组 - dfs 解法
 */
public class Leetcode992 {

    public static void main(String[] args) {
        Leetcode992 l = new Leetcode992();
        int[] A = new int[]{1,2,3};

        l.subarraysWithKDistinct(A,2);

    }

    public int subarraysWithKDistinct(int[] A, int K) {

        int[] box = new int [A.length];
        int[] data = new int [A.length];
        this.dfs(0,A,box,data);
        return 1;
    }



    public void dfs(int step,int[]A,int[]box,int[]data){
        if(step > A.length){
            return;
        }
        for(int p = 0; p < step; p++){
            System.out.print(data[p]+" ");
        }
        System.out.println();

        for(int i = 0; i < A.length ;i ++){
            if(box[i] == 0){
                box[i] = 1;
                data[step] = A[i];
                this.dfs(step + 1, A,box,data);
                box[i] = 0;
            }
        }
    }



}
