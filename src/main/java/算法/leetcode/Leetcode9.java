package 算法.leetcode;

public class Leetcode9 {


    public static void main(String[] args) {
     Leetcode9 l = new Leetcode9();
        System.out.println(l.isPalindrome(10));
        System.out.println(l.isPalindrome(101));
        System.out.println(l.isPalindrome(120));
        System.out.println(l.isPalindrome(110));
        System.out.println(l.isPalindrome(20102));


    }


    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String strX = String.valueOf(x);
        for (int i = 0; i < strX.length() / 2; i++) {
            if (strX.charAt(i) != strX.charAt(strX.length() -1 - i)) {
                return false;
            }
        }
        return true;
    }


}
