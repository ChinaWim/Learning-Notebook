package 算法.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] array = new int [k];
        this.dfs(n,k,0,1,result,array);
        return result;
    }

    private void dfs(int n,int k, int step,int pos,List<List<Integer>> result,int[] array){
        if(step >= k){
            List<Integer> data = new ArrayList<>();
            for(int i = 0 ; i < k; i++){
                data.add(array[i]);
            }
            result.add(data);
            return;
        }
        for(int i= pos;i <=n; i++){
            int temp = array[step];
            array[step] = i;
            dfs(n,k,step + 1,i + 1,result,array);
            array[step] = temp;
        }
    }

    public static void main(String[] args) {
        Leetcode77 leetcode77 = new Leetcode77();
        System.out.println(leetcode77.combine(4, 2));
    }



}
