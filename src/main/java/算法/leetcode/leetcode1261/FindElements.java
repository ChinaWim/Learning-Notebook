package 算法.leetcode.leetcode1261;


import java.util.ArrayList;

class FindElements {

    private ArrayList<Integer> recoverData = new ArrayList<>();

    public FindElements(TreeNode root) {
        recover(root,0);
    }


    private void recover(TreeNode root,int val){
        if(root != null){
            root.val = val;
            recoverData.add(val);
            recover(root.left,root.val * 2 + 1);
            recover(root.right,root.val * 2 + 2);
        }
    }

    
    public boolean find(int target) {
        return recoverData.contains(target);
    }

}