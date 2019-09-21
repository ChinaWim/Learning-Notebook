package 算法.牛客网.有赞;


import java.util.*;

public class 数组移动跳跃 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String arrayStr = cin.next();
        String numberStr = arrayStr.replace("[", "").replace("]","");
        String[] numberArray = numberStr.split(",");
        boolean isTrue = false;
        Set<Integer> step = new HashSet<>();
        List<Long> stepList = new ArrayList<>();

        for (int i = 0; i < numberArray.length; ) {
            int temp = i;
            long num = Long.parseLong(numberArray[i]);
            if (!step.contains(i)) {
                stepList.add(num);
            }
            step.add(i);
            i += num;
            if (i >= numberArray.length || i < 0) {
                isTrue = true;
                break;
            }
            if (0 == (Long.parseLong(numberArray[i]) + Long.parseLong(numberArray[temp]))) {
                break;
            }
            int sum = 0;
            boolean isBreak = false;
            for (int j = stepList.size() - 1; j >= 0; j--) {
                sum += stepList.get(j);
                if (0 == (sum + Long.parseLong(numberArray[i]))) {
                    isBreak = true;
                    break;
                }
            }
            if (isBreak) {
                break;
            }

        }
        System.out.println(isTrue);
    }
}
