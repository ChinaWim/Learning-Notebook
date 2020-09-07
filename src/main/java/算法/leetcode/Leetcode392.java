package 算法.leetcode;


public class Leetcode392 {

    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()){
            return false;
        }
        if(s.length() == 0){
           return true;
        }

        int p = 0;
        for(int i = 0 ; i < t.length(); i++){
            if(t.charAt(i) == s.charAt(p)){
                p++;
            }
            if(p == s.length()){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Leetcode392 leetcode392 = new Leetcode392();
        boolean subsequence = leetcode392.isSubsequence("abc", "abcgdc");
        System.out.println(subsequence);
    }
}
