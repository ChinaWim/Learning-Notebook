package 算法.leetcode;

import org.noggit.JSONUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * K个不同整数的子数组 - dfs 解法
 */
public class Leetcode992_2 {

    public static void main(String[] args) {
        Leetcode992_2 l = new Leetcode992_2();
        int[] A = new int[]{1,2,1,2,3};
        System.out.println(l.subarraysWithKDistinct(A, 2));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        if(A.length <= 0 || K <= 0){
            return 0;
        }
        int result = 0;
        for(int i = 0; i< A.length; i++){
            Set<Integer> cache = new HashSet<>();
            for(int j = i+K; j<= A.length; j++){
                if(cache.size() > 0 ){
                    cache.add(A[j - 1]);
                    if(cache.size() == K){
                        result++;
                        continue;
                    }else if(cache.size() == K){
                        break;
                    }
                }
                Set<Integer> set = this.copyArray(A,i,j);;
                if(set.size() == K){
                    result++;
                }
                cache = set;
            }
        }
      return result;
    }

    private Set<Integer> copyArray(int[]source,int i,int j){
        Set<Integer> cs = new HashSet<>();
        for(int k = i; k < j; k++){
            cs.add(source[k]);
        }
        return cs;
    }







}
