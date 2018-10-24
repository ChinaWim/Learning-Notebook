package 算法.剑指offer;

/**
 *
 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author m969130721@163.com
 * @date 18-10-10 下午6:54
 */
public class 旋转数组最小的数字 {
    public static void main(String[] args) {
        旋转数组最小的数字 a = new 旋转数组最小的数字();

        System.out.println(a.minNumberInRotateArray(new int[]{3,4,5,1,2}));
    }


    public int minNumberInRotateArray(int [] array) {
            if (array.length == 0) {
                return 0;
            }
            int baseLeft = array[0];
            int baseRight = array[array.length - 1];
            int left = 0;
            int right = array.length - 1;
            int mid = (left + right) / 2;
            while (mid < array.length) {
                if (array[mid] > baseRight) {
                    left = mid + 1;
                    mid = (left + right) / 2;
                } else {
                    int tempIndex = mid;
                    while (tempIndex -- > 0) {
                        if (array[tempIndex] > baseLeft) {
                            return array[tempIndex + 1];
                        }
                    }
                }
            }
            return 0;
    }
}
