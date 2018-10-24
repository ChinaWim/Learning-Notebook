package 算法.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉排序树的一些操作
 *
 * @author m969130721@163.com
 * @date 18-9-26 下午7:18
 */
public class SearchTree {
    private Node root;


    public void insertNode(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Node temp = root;
        while (true) {
            if (data >= temp.getData()) {
                if (temp.getRight() != null) {
                    temp = temp.getRight();
                    continue;
                }
                temp.setRight(newNode);
                return;
            } else {
                if (temp.getLeft() != null) {
                    temp = temp.getLeft();
                    continue;
                }
                temp.setLeft(newNode);
                return;
            }
        }
    }

    public void buildTree(int ... data) {
        for (int n : data) {
            insertNode(n);
        }
    }

    private void beforePrint(Node tree) {
        if (tree != null) {
            System.out.print(tree.getData() + " ");
            beforePrint(tree.getLeft());
            beforePrint(tree.getRight());
        }
    }

    //todo
    private void beforePrint2(Node node){
        while (node != null) {


        }


    }



    private void midPrint(Node tree) {
        if (tree != null) {
            midPrint(tree.getLeft());
            System.out.print(tree.getData() + " ");
            midPrint(tree.getRight());
        }
    }

    private void afterPrint(Node tree) {
        if (tree != null) {
            afterPrint(tree.getLeft());
            afterPrint(tree.getRight());
            System.out.print(tree.getData() + " ");
        }
    }

    public void beforePrint() {
        this.beforePrint(this.root);
    }

    public void midPrint() {
        this.midPrint(this.root);
    }

    private void afterPrint() {
        this.afterPrint(this.root);
    }

    public void bfsPrint(Node headNode) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(headNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.getData()+" ");
            if (node.getLeft() != null) {
               queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }


    private void bfsPrint(){
        this.bfsPrint(this.root);
    }




    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree();
        searchTree.buildTree(10,8,13,5,6,9,12,14);
        searchTree.bfsPrint();
    }


}
