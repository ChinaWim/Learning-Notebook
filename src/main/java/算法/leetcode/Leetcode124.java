package 算法.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树中的最大路径和
 */
public class Leetcode124 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    public int maxPathSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while(!treeNodeQueue.isEmpty()){
            TreeNode tempRoot = treeNodeQueue.poll();

            int []saveLeftRight = new int [2];
            this.maxChildSum(tempRoot, saveLeftRight);
            max = Math.max(Math.max(Math.max(Math.max(saveLeftRight[0], saveLeftRight[1]) + tempRoot.val,saveLeftRight[0] + saveLeftRight[1] + tempRoot.val),tempRoot.val),max);
            System.out.println(max);
            if(tempRoot.left != null){
                treeNodeQueue.add(tempRoot.left);
            }
            if(tempRoot.right != null){
                treeNodeQueue.add(tempRoot.right);
            }
        }
        return max;
    }

    private int maxChildSum(TreeNode root,int[]saveLeftRight){
        if(root == null) {
            return 0;
        }
        int leftMax = maxChildSum(root.left,saveLeftRight);
        int rightMax = maxChildSum(root.right,saveLeftRight);
        saveLeftRight[0] = leftMax;
        saveLeftRight[1] = rightMax;

        return Math.max(Math.max(leftMax,rightMax)+ root.val,root.val);
    }



    //[5,4,8,11,null,13,4,7,2,null,null,null,1]
//    [-10,9,20,null,null,15,7]
//    [9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(9);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(-3);
        treeNode.right.left = new TreeNode(-6);
        treeNode.right.right = new TreeNode(2);
        treeNode.right.right.left = new TreeNode(2);
        treeNode.right.right.left.left = new TreeNode(-6);
        treeNode.right.right.left.right = new TreeNode(-6);
        treeNode.right.right.left.left.left = new TreeNode(-6);
        int []saveLeftRight = new int [2];
        Leetcode124 leetcode124 = new Leetcode124();


        System.out.println(leetcode124.maxChildSum(treeNode,saveLeftRight));
        System.out.println(Arrays.toString(saveLeftRight));
        System.out.println("--");
//        System.out.println(leetcode124.maxPathSum(treeNode));


    }

}
