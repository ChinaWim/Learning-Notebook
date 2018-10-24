package 算法.剑指offer;

/**
 * @author m969130721@163.com
 * @date 18-10-10 下午8:32
 */
public class 二进制 {
    public static void main(String[] args) {
        //11111111111111111111111111111110  -2以补码的形式存在计算机中
//        System.out.println(Integer.toBinaryString(-2));
        二进制 a = new 二进制();
        System.out.println(a.NumberOf1(7));
    }

    public int NumberOf1(int n) {
        int number = 0;
        boolean flag = false;
        int step = 0;
        if (n < 0) {
            n = -n;
            int temp = n;
            flag = true;
            while (temp != 0) {
                temp  = temp >> 1;
                step ++;
            }
        }
        while (n > 0) {
            if (n != 0) {
                n = n & (n - 1);
            }
            number ++;
        }
        if (flag) {
            number += 32 - step;
        }
        return number;
    }
}
