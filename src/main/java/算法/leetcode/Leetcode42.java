package 算法.leetcode;

/**
 * todo
 */
public class Leetcode42 {

    public int trap(int[] height) {
        int[] reHeight = new int [height.length];
        int p = 0;
        for(int i = height.length - 1 ; i >= 0; i--){
            reHeight[p ++] = height[i];
        }
        return Math.max(this.getValue(height),this.getValue(reHeight));
    }
    private int getValue(int[] height){
        if(height.length <= 0){
            return 0;
        }

        int p = 1;
        int start = height[0];
        int startIndex = 0;
        int result = 0;
        int beforeStart = start;
        int beforeStartIndex = 0;

        while( p < height.length){
            boolean has = false;
            int step = 0;
            int space = 0;
            int[] box = new int [height.length + 1];
            for(int i = p ;i < height.length; i++){
                if(start <= height[i]){
                    boolean hasFinal = true;
                    for(int k = i + 1; k < height.length; k ++){
                        if(height[k] > height[i]){
                            hasFinal = false;
                            break;
                        }
                    }
                    if(hasFinal && i - 1 == startIndex && startIndex != 0 && beforeStart > start && box[i] == 0){
                        result +=  height[i] - start;
                    }else if(i == height.length - 1 && startIndex == height.length - 2 && height[startIndex - 1] > start){
                        result +=  height[i] - start;
                    }else if(i == height.length - 1 && beforeStart > start){
                        int tempSpace = 0;
                        int tempStep = 0;
                        for(int j = beforeStartIndex + 1; j <= i - 1; j++){
                            tempSpace += height[j];
                            tempStep ++;
                        }
                        result +=  height[i] * tempStep - tempSpace;
                    } else {
                        result +=  start * step - space;
                        box[i] = 1;

                    }
                    p = i + 1;
                    startIndex = i;
                    start = height[i];
                    has = true;
                    break;
                }
                step ++;
                space += height[i];
            }
            if(!has){
                beforeStartIndex = startIndex;
                beforeStart = start;
                start = height[p];
                startIndex = p;
                p ++;

            }
        }
        return result;
    }


    public static void main(String[] args) {
        Leetcode42 demo =  new Leetcode42();
//
        System.out.println(demo.trap(new int[]{7,6,7,6,9}));
    }
}
