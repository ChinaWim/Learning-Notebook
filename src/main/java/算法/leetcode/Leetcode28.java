package 算法.leetcode;

/**
 * 实现 strStr()
 */
public class Leetcode28 {

    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack == null || haystack.length() == 0){
            return -1;
        }
        int size = needle.length();
        for(int i = 0; i < haystack.length(); i ++){
            if((i + size) > haystack.length()){
                break;
            }
            boolean allEquals = true;
            int p = 0;
            for(int j = i; j < i+size; j++){
                if(haystack.charAt(j) != needle.charAt(p++)){
                    allEquals = false;
                    break;
                }
            }
            if(allEquals){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode28 demo = new Leetcode28();
        System.out.println(demo.strStr("mississippi", "a"));
    }

}
