package 算法.leetcode.leetcode700;

public class Leetcode700 {

    public static void main(String[] args) {
        Leetcode700 leetcode700 = new Leetcode700();





    }

    public TreeNode searchBST(TreeNode root, int val) {
       if(root == null){
           return null;
       }
      TreeNode temp = root;
      while(temp != null){
          if(temp.val == val){
              return temp;
          }else if(temp.val > val){
              temp = temp.left;
          }else {
              temp = temp.right;
          }
       }
       return temp;
    }

    private void firstSearch(TreeNode root){



    }


}
