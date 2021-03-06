package 算法.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 ["hello","leetcode"]

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verifying-an-alien-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode953 {
    public static void main(String[] args) {
        Leetcode953 a = new Leetcode953();
        boolean hlabcdefgijkmnopqrstuvwxyz = a.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
        System.out.println();
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> indexMap = new HashMap<>();
        for(int i = 0; i < order.length(); i ++){
            indexMap.put(order.charAt(i), i);
        }
        for(int i = 0 ; i < words.length - 1; i ++){
            String word1 = words[i];
            String word2 = words[i + 1];
            boolean next = false;
            int length = Math.min(word1.length(),word2.length());
            for(int j = 0; j < length; j++){
                char w1 = word1.charAt(j);
                char w2 = word2.charAt(j);
                if(indexMap.get(w1) < indexMap.get(w2)){
                    next = true;
                    break;
                }
                if(indexMap.get(w1) > indexMap.get(w2)){
                    return false;
                }
            }
            if(!next && word1.length() > word2.length()){
                return false;
            }

        }
        return true;
    }
}
