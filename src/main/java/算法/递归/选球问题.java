package 算法.递归;

/**
 * 从n个球中选m个球不放回，问有多少种情况
 *
 * @author m969130721@163.com
 * @date 18-12-8 下午8:45
 */
public class 选球问题 {

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public static int f2(int n){
        if(n == 1 || n == 2) {
            return 1;
        }
        return f2(n - 1) + f2(n - 2);

    }

    /**
     * 斐波那契数列进阶版本
     * @param n
     * @param m
     * @return
     */
    public static int f(int n, int m) {
        if (n < m) {
            return 0;
        }
        if (n == m) {
            return 1;
        }
        if (m < 0) {
            return 0;
        }
        return f(n - 1, m - 1) + f(n - 1, m);

    }


    public static void main(String[] args) {

        int count = 0;
        for(int i = 0; i < 10; i++){
            for(int j = i + 1; j < 10; j++){
                    count ++;
            }
        }
        System.out.println(count);

        System.out.println(f(2, 1));
    }


}
