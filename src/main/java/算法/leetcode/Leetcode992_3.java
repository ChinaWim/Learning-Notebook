package 算法.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * K个不同整数的子数组 -  解法 on2超时法
 */
public class Leetcode992_3 {

    public static void main(String[] args) {
        Leetcode992_3 l = new Leetcode992_3();
        int[] A = new int[]{1,2,1,2,3};
        System.out.println(l.subarraysWithKDistinct(A, 2));
    }

    public int subarraysWithKDistinct(int[] A, int K) {

        int result = 0;
        int p = 0;
        LinkedList<Integer> subArray = new LinkedList<>();
        Set<Integer> subSet = new HashSet<>();
        while(p < A.length){
            if(subArray.size() > 0){
                subArray.removeFirst();
                if(p+K-1 >= A.length){
                    break;
                }
                subArray.add(A[p+K-1]);
                subSet = new HashSet<>(subArray);
                if(subSet.size() == K){
                    result ++;
                }

                int k = p + K;
                while(k < A.length){
                    subSet.add(A[k]);
                    if(subSet.size() == K ){
                        result ++;
                    }else if(subSet.size() > K){
                        break;
                    }
                    k++;
                }

            }else {
                int k = p + K;
                subSet = this.copyArray(A, subArray, p, p + K);
                if(subSet.size() == K){
                    result ++;
                }
                while(k < A.length){
                    subSet.add(A[k]);
                    if(subSet.size() == K ){
                        result ++;
                    }else if(subSet.size() > K){
                        break;
                    }
                    k++;
                }
            }
            p++;

        }

        return result;
    }

    private Set<Integer> copyArray(int[]source,LinkedList<Integer> target,int i,int j){
        Set<Integer> cs = new HashSet<>();
        for(int k = i; k < j; k++){
            target.add(source[k]);
            cs.add(source[k]);
        }
        return cs;
    }







}
