package 算法.基础练习题;

/**
 * 猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个，
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
 * 以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。
 * 求第一天共摘了多少。
 * @author m969130721@163.com
 * @date 18-12-4 下午7:18
 */
public class 猴子吃桃 {

    public static void main(String[] args) {
        System.out.println(method(1));
        System.out.println(method2("123456"));
    }

    public static int method(int day) {
        if (day == 10) {
            return 1;
        }
        return  (method(day + 1) + 1) * 2;
    }


    //用递归逆序字符串
    public static String method2(String string){
        if (string.length() <= 1) {
            return string;
        }

        return  method2(string.substring(1,string.length())) + string.charAt(0);
    }
}
