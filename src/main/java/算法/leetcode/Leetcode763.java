package 算法.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode763 {
    public static void main(String[] args) {
        Leetcode763 leetcode763 = new Leetcode763();
        System.out.println(leetcode763.partitionLabels("qiejxqfnqceocmy"));
    }

    public List<Integer> partitionLabels(String S) {
        int[] sIndex = new int [S.length()];
        for(int i = 0; i < S.length(); i++){
            char curChar = S.charAt(i);
            int lastIndex = S.lastIndexOf(curChar);
            sIndex[i] = lastIndex == -1 ? i:lastIndex;
        }
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i< sIndex.length){
            char curChar = S.charAt(sIndex[i]);
            int lastIndex = S.lastIndexOf(curChar);

            int maxIndex = lastIndex;
            for(int j = i; j <= lastIndex; j ++){
                maxIndex = Math.max(maxIndex,sIndex[j]);
            }
            while(true){
                int secondMax = maxIndex;
                for(int k = lastIndex + 1; k <= maxIndex;k ++){
                    secondMax = Math.max(secondMax, sIndex[k]);
                }
                if(secondMax == maxIndex){
                    break;
                }
                int temp = maxIndex;
                maxIndex = secondMax;
                lastIndex = temp;
            }

            int size = (maxIndex - i) + 1;
            result.add(size);
            i = i + size;
        }
        return result;
    }

}
