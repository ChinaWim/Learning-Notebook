package 算法;

public class  二分搜索 {


    public static int binarySearch(int[] array, int number, int start, int end) {

        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (number < array[mid]) {
            return binarySearch(array, number, start, mid - 1);
        } else if (number > array[mid]) {
            return binarySearch(array, number, mid + 1, end);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int array[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = binarySearch(array, 10, 0, array.length - 1);
        System.out.println(index);
    }


}
