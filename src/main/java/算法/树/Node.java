package 算法.树;

/**
 * @author m969130721@163.com
 * @date 18-9-26 下午7:28
 */
public class Node {
    private int data;

    private Node left;

    private Node right;

    public Node(int data){
        this.data = data;

    }
    public Node(){

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
