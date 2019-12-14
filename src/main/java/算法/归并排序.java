package 算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 稳定的排序算法（冒泡，插入，归并，基数）
 * 归并排序有多路归并排序、两路归并排序 , 可用于内排序，也可以用于外排序。
 * 这里仅对内排序的两路归并方法进行讨论。
 * <p>
 * 一、两路归并排序算法思路
 * <p>
 * 分而治之(divide - conquer);每个递归过程涉及三个步骤
 * 第一, 分解: 把待排序的 n 个元素的序列分解成两个子序列, 每个子序列包括 n/2 个元素.
 * 第二, 治理: 对每个子序列分别调用归并排序MergeSort, 进行递归操作
 * 第三, 合并: 合并两个排好序的子序列,生成排序结果.
 *
 * @author m969130721@163.com
 * @date 18-12-3 下午5:24
 */
public class 归并排序 {

    public static void main(String[] args) {

        int[] a = {4, 2, 3};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {

            sort(a, low, mid);
            sort(a, mid + 1, high);
            //左右归并
            merge(a, low, mid, high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        //把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        //把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        //把右边剩下的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        //把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }

}
