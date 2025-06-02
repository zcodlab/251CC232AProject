package uni.aed.trees;

public class BSTNode {
    private int key;
    private BSTNode left,right;

    public BSTNode() {
        left=right=null;
    }

    public BSTNode(int key) {
        this.key = key;
    }

    
    public BSTNode(int key, BSTNode left, BSTNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "BSTNode{" + "key=" + key + ", left=" + left + ", right=" + right + '}';
    }    
    
}
