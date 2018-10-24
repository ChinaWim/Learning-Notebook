package 算法.牛客网;

import java.util.*;

/**
 * 牛牛与妞妞
 * 牛牛与妞妞闲来无聊，便拿出扑克牌来进行游戏。游戏的规则很简单，
 * 两个人随机抽取四张牌，四张牌的数字和最大的取胜
 * （该扑克牌总张数为52张，没有大小王，A=1，J=11，Q=12，K=13，每种数字有四张牌），
 * 现在两人已经分别亮出了自己的前三张牌，
 * 牛牛想要知道自己要赢得游戏的概率有多大。
 * <p>
 * 输入
 * 3 5 7
 * 2 6 8
 * 输出
 * 0.3905
 */
public class Demo {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        HashMap<Integer, Integer> p = new HashMap<>();
        for (int i = 1; i <= 13; i++) {
            p.put(i, 4);
        }
        int array[] = new int[6];
        array[0] = cin.nextInt();
        array[1] = cin.nextInt();
        array[2] = cin.nextInt();
        int sum1 = array[0] + array[1] + array[2];
        array[3] = cin.nextInt();
        array[4] = cin.nextInt();
        array[5] = cin.nextInt();
        int sum2 = array[3] + array[4] + array[5];

        for (int i = 0; i < array.length; i++) {
            if (p.containsKey(array[i])) {
                p.put(array[i], p.get(array[i]) - 1);
            }
        }
        int sumCount = 0;
        Set<Map.Entry<Integer, Integer>> entries = p.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer times = entry.getValue();
            if (times != 0) {
                int sumA = sum1 + entry.getKey();
                p.put(entry.getKey(), entry.getValue() - 1);
                Set<Map.Entry<Integer, Integer>> entries1 = p.entrySet();
                for (Map.Entry<Integer, Integer> entry1 : entries1) {
                    if (times != 0) {
                        int sumB = sum2 + entry1.getKey();
                        if (sumB < sumA) {
                            sumCount++;
                        }
                    }
                }
                p.put(entry.getKey(), entry.getValue() + 1);
            }
        }
        double result = sumCount * 1.0 / (13 * 13);
        System.out.printf("%.4f", result);

    }
}