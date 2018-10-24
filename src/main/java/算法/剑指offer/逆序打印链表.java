package 算法.剑指offer;

import java.util.Stack;
import java.util.Vector;

/**
 * @author m969130721@163.com
 * @date 18-9-27 下午7:58
 */
public class 逆序打印链表 {
    static ListNode root = new ListNode(1);

    static {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        root.next = listNode2;
        listNode2.next = listNode3;
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        ListNode temp = root;
        while (temp != null) {
            stack.add(temp.val);
            temp = temp.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
            print2(root);

    }

    public static void print2(ListNode node){
        if(node != null) {
            System.out.println(node.val);
            print2(node.next);
        }
    }

    public static void print(ListNode node){
       if(node == null) return;
        print(node.next);
        System.out.println(node.val);
    }










}



