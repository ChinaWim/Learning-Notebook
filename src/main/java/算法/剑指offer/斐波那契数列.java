package 算法.剑指offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 *
 * @author m969130721@163.com
 * @date 18-10-10 下午7:43
 */
public class 斐波那契数列 {

    public static void main(String[] args) {
        斐波那契数列 a = new 斐波那契数列();
        System.out.println(a.Fibonacci(7));


    }

    public int Fibonacci(int n) {
        if (n <= 2) return 1;
        int[] array = new int [n];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n; i ++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }

}
