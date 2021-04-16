package 语法.位运算;

/**
 *  >>>无符号右移,左边补0
 *  没有无符号左移，因为右边补的都是0
 *
 * <<有符号左移,右边补上0
 * >>有符号右移,左边补上符号位
 * 原码、反码、补码（补码为反码+1）
 * @author m969130721@163.com
 * @date 18-10-16 上午10:13
 */
public class Demo1 {

    public static void main(String[] args) {
        //负数在计算机中是以补码的形式存在的
        int a = -5;
        int b = 5;
        System.out.println(Integer.toBinaryString(a).length());
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a >> 1));
        System.out.println(Integer.toBinaryString(a >>> 1));
        System.out.println("-------------");
        System.out.println(Integer.toBinaryString(b).length());
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b >> 1));
        System.out.println(Integer.toBinaryString(b >>> 1));


    }

}
