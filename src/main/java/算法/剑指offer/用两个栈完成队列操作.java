package 算法.剑指offer;

import java.util.Stack;

/**
 * @author m969130721@163.com
 * @date 18-10-10 下午6:33
 */
public class 用两个栈完成队列操作 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        用两个栈完成队列操作 a = new 用两个栈完成队列操作();
    }

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

}
