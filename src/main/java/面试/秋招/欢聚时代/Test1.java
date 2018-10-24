package 面试.秋招.欢聚时代;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author m969130721@163.com
 * @date 18-9-14 下午3:58
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        while(T-- >0){
            String oldStr = cin.next();
            String newStr = cin.next();
            if (oldStr.equals(newStr)){
                System.out.println("Yes");
                continue;
            }
            LinkedList<Character> queue = new LinkedList<>();
            for (int i = 0; i < oldStr.length(); i++) {
                queue.add(oldStr.charAt(i));
            }
            int time = 0;
            boolean isYes = false;
            while(true){
                time ++;
                queue.addFirst(queue.pollLast());
                StringBuilder sb = new StringBuilder();
                for (Character character : queue) {
                    sb.append(character);
                }
                if (sb.toString().equals(newStr)){
                    System.out.println("Yes");
                    isYes = true;
                    break;
                }
                if (time >= newStr.length()) break;

            }
            if(!isYes){
                System.out.println("No");
            }
        }
    }

}
