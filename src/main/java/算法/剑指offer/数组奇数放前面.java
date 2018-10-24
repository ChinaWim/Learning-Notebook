package 算法.剑指offer;

import java.util.*;

/**
 * @author m969130721@163.com
 * @date 18-10-16 下午2:11
 */
public class 数组奇数放前面 {

    public static void main(String[] args) {
        reOrderArray(new int[]{1,2,4,5,6,7,8} );

    }

    public static void  reOrderArray(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) != 0) {
                list.add(array[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                list.add(array[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
    }
}
