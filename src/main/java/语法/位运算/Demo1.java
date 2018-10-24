package 语法.位运算;

/** >>>无符号右移,左边补0
 * <<有符号左移,右边补0
 * >>有符号右移,右边补1
 * @author m969130721@163.com
 * @date 18-10-16 上午10:13
 */
public class Demo1 {

    public static void main(String[] args) {
        double exponent = 3;
        int base = 2;
        double result = 1;
        if (exponent == 1){
            System.out.println(base);
        }else {
            for (int i = 0; i < exponent; i ++) {
                result = result*base;
            }
            System.out.println(result);
        }

    }

}
