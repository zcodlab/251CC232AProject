package uni.aed.trees;

import uni.aed.tda.LinkedListTDA.LinkedListTDA;
import uni.aed.tda.ListTDA.IteratorTDA;
import uni.aed.tda.ListTDA.ListTDA;

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
    private void print(StringBuilder buffer, String prefix, String childrenPrefix){
        ListTDA<BSTNode> children =new LinkedListTDA<>();
        children.add(left);
        children.add(right);
        
        buffer.append(prefix);
        buffer.append(key);
        buffer.append('\n');
        
        for(IteratorTDA<BSTNode> it=children.iterador(); it.hasNext();){
            BSTNode next =it.next();
            if(next==null)
                continue;
            if(it.hasNext())
                next.print(buffer, childrenPrefix + "---", childrenPrefix +"|   ");
            else
                next.print(buffer, childrenPrefix + "+++", childrenPrefix +"   ");
        }
    }

    @Override
    public String toString() {
        StringBuilder buffer=new StringBuilder();
        print(buffer,"","");
        return buffer.toString();
    }    
    
}
