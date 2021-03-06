package 算法.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 字符串排序 {

    public static void main(String[] args) {
        字符串排序 a = new 字符串排序();
        String[] result = a.permutation("aab");
        System.out.println(Arrays.toString(result));
    }


    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        int[] box = new int[s.length()];
        char[]data = new char[chars.length];
        Set<String> result = new HashSet<>();
        this.dfs(box,chars,data,0,result);
        String[] finalResult = new String[result.size()];
        return result.toArray(finalResult);
    }

    public void dfs(int[] box,char[] chars,char[] data,int step,Set<String> result){
        if(step == chars.length){
            StringBuilder sb = new StringBuilder();
            for(int t = 0;t<step;t ++){
                sb.append(data[t]);
            }
            result.add(sb.toString());
            return;
        }
        for(int i = 0; i <chars.length; i++){
            if(box[i] == 0){
                box[i] = 1;
                data[step] = chars[i];
                dfs(box,chars,data,step + 1,result);
                box[i] = 0;
            }
        }
    }
}
