package 算法.排序;

public class      快速排序 {


    public static void quickSort(int array[], int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        while (i < j) {
            while (array[j] >= array[left] && i < j) {
                j--;
            }
            while (array[i] <= array[left] && i < j) {
                i++;
            }
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        int temp = array[left];
        array[left] = array[i];
        array[i] = temp;

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }

    public static void main(String[] args) {
        int array[] = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
