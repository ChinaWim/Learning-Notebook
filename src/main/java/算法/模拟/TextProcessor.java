package 算法.模拟;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * @author m969130721@163.com
 * @date 18-9-24 下午4:23
 */
public class TextProcessor {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String content = cin.nextLine();
        System.out.println(process(content, 10));
    }

    public static String process(String text, int width) {
        StringBuilder result = new StringBuilder();
        StringBuilder nonBlankWord = new StringBuilder();
        StringBuilder blankWord = new StringBuilder();
        int nonBlankStart = 0;
        int nonBlankEnd = 0;
        int blankStart = 0;
        int blankEnd = 0;


        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                nonBlankWord.append(text.charAt(i));
            } else {
                blankWord.append(text.charAt(i));
            }

            //处理开头和结束
            if (i == 0) {
                if (text.charAt(i) != ' ') {
                    nonBlankStart = getHeight(i + 1, width);
                } else {
                    blankStart = getHeight(i + 1, width);
                }
            }
            if (i == text.length() - 1) {
                if (text.charAt(i) != ' ') {
                    nonBlankEnd = getHeight(i + 1, width);
                    result.append(setRowNumber(nonBlankWord, nonBlankStart, nonBlankEnd));
                } else {
                    blankEnd = getHeight(i + 1, width);
                    result.append(setRowNumber(blankWord, blankStart, blankEnd));
                }
            }

            if (i != 0 && (text.charAt(i - 1) == ' ' && text.charAt(i) != ' ')) {//单词的开始
                nonBlankStart = getHeight(i + 1, width);

            }

            if (i != 0 && (text.charAt(i) == ' ' && text.charAt(i - 1) != ' ')) {//空白字符的开始
                blankStart = getHeight(i + 1, width);
            }

            if (i != text.length() - 1 && (text.charAt(i + 1) == ' ' && text.charAt(i) != ' ')) { //单词的结束
                nonBlankEnd = getHeight(i + 1, width);
                result.append(setRowNumber(nonBlankWord, nonBlankStart, nonBlankEnd));
                nonBlankWord = new StringBuilder();


            }

            if (i != text.length() - 1 && (text.charAt(i + 1) != ' ' && text.charAt(i) == ' ')) { //空白字符的结束
                blankEnd = getHeight(i + 1, width);
                result.append(setRowNumber(blankWord, blankStart, blankEnd));
                blankWord = new StringBuilder();
            }

        }

        return result.toString();
    }

    private static StringBuilder setRowNumber(StringBuilder sb, int start, int end) {
        sb.append("(");
        for (int j = start; j <= end; j++) {
            if (j == end) {
                sb.append(j);
            } else {
                sb.append(j + ",");
            }
        }
        sb.append(");");
        return sb;
    }

    public static int getHeight(int index, int width) {
        return (int) Math.ceil(index * 1.0 / width);
    }


}
