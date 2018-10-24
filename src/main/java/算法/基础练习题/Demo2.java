package 算法.基础练习题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一个所有元素都是自然数的数组, 初始状态你的位置位于第1个元素, 每个元素的位置表示1步,
 * 当前所在位置的元素数值表示你下一次前进能够移动的最大步数,
 * 你的目标是以最小的前进次数从数组的第一个元素移动到数组的最后一个元素位置.
 * 你需要输出每次前进的步数.
 * <p>
 * 举个例子, 输入: [2,3,1,1,4], 输出: [1,3]
 *
 * @author m969130721@163.com
 * @date 18-10-10 下午2:58
 */
class Node {
    int x;

}

public class Demo2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = cin.nextInt();
        }
        List<Integer> resultList = getStep(array);
        int[] resultAarray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i ++){
            resultAarray[i] = resultList.get(i);
        }
        System.out.println(Arrays.toString(resultAarray));
    }

    public static List<Integer> getStep(int[] array) {
        List<Integer> resultList = new ArrayList<>();
        int step = 0;
        int i = 0;
        while(i < array.length){
            int range = array[i];
            int endStep = array.length - 1 - i;
            if ( range >= endStep) {
                resultList.add(endStep);
                break;
            }
            int max = Integer.MIN_VALUE;
            int index = i;
            for (int j = i + 1; j <= i + range; j++) {
                if (array[j] > max) {
                    max = array[j];
                    index = j;
                }
            }
            if (index != i) {
                step = index - i;
                resultList.add(step);
                i = index;
            }
        }
        return resultList;
    }


}
