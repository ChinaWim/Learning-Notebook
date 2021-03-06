package 算法.leetcode;

import java.util.*;

//todo
public class Leetcode621 {

    private class TaskCount {
        private char task;
        private int value;
        TaskCount(char task,int value){
            this.task = task;
            this.value = value;
        }
        public char getTask() {
            return task;
        }

        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int result = 0;
        Queue<TaskCount> queue = new LinkedList<>();
        HashMap<Character,Integer> data = new HashMap<>();
        for (char task : tasks) {
            Integer count = data.get(task) == null ? 0 : data.get(task);
            data.put(task,++count);
        }
        ArrayList<TaskCount> taskCountList = new ArrayList<>();
        data.forEach((k,v) ->{
            TaskCount taskCount = new TaskCount(k,v);
            taskCountList.add(taskCount);
        });
        taskCountList.stream().sorted(Comparator.comparing(TaskCount::getValue));
        int p = 0;
        int time = 0;
        int count = 0;
        int juli = 0;
        while (count != tasks.length) {
            TaskCount curTask = taskCountList.get(p % (taskCountList.size()));
            if (curTask.getValue() != 0) {
                if(!queue.isEmpty() && queue.peek().getTask() == curTask.getTask()){
                    int diff = n - (queue.size()+juli - 1);
                    if(diff > 0){
                        result += diff;
                        juli+=diff;
                    }else {
                        juli = 0;
                    }
                    queue.poll();
                }else if(time == n + 1){
                    time = 0;
                    curTask = queue.poll();
                    if(curTask.getValue() == 0){
                        p++;
                        continue;
                    }else {
                        p --;
                    }

                }

                curTask.setValue(curTask.getValue() - 1);
                queue.add(curTask);
                System.out.println(curTask.getTask());
                result ++;
                time ++;
                count ++;
            }
            p++;
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode621 leetcode621 = new Leetcode621();
        System.out.println(leetcode621.leastInterval(new char[]{'A', 'A', 'A','A','A','A',  'B','C','D','E','F','G' }, 2));
    }






}
