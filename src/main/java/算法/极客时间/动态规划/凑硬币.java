package 算法.极客时间.动态规划;

import java.util.Arrays;

public class 凑硬币 {


    //贪心实现：从大的硬币开始拿
    int getMinCoinCountOfValue(int total,int []values ,int step){
        if(step >= values.length){
            return Integer.MAX_VALUE;
        }
        int minCount = Integer.MAX_VALUE;
        int maxCount = total / values[step];
        for(int maxCurCount = maxCount;maxCurCount >= 0; maxCurCount--){
            int restTotal = total - maxCurCount * values[step];
            if(restTotal == 0){
                return Math.min(maxCurCount, minCount);
            }
            int restCount = getMinCoinCountOfValue(restTotal,values,step + 1);
            //组合不到直接跳过
            if(restCount == Integer.MAX_VALUE){
                continue;
            }
            minCount = Math.min(minCount,maxCurCount+restCount);
        }

        return minCount;
    }

    public static void main(String[] args) {
        凑硬币 c = new 凑硬币();
        System.out.println(c.getMinCoinCountOfValue(12, new int[]{3,2,1}, 0));
    }



}



