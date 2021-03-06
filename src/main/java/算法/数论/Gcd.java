package 算法.数论;

/**
 * @author m969130721@163.com
 * @date 18-10-12 下午7:35
 */
public class Gcd {

    public static int gongBei(int n,int m){
        return (n*m)/gcd(n,m);
    }


    public static int gcd(int n,int m) {
        int a = n;
        int b = m;
        if (n < m){
            a = m;
            b = n;
        }
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }


}
