package uni.aed.trees.AVL;

public class AvlTreeNode<E> {
    private E key;
    private int height;
    private AvlTreeNode<E> left;
    private AvlTreeNode<E> right;
    private static final String SEPARADOR="\n";

    public AvlTreeNode(E key) {
        this.key = key;
        this.height=1;//todo nuevo nodo nace con una altura 1
        this.left=null;
        this.right=null;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLeft(AvlTreeNode<E> left) {
        this.left = left;
    }

    public void setRight(AvlTreeNode<E> right) {
        this.right = right;
    }

    public E getKey() {
        return key;
    }

    public int getHeight() {
        return height;
    }

    public AvlTreeNode<E> getLeft() {
        return left;
    }

    public AvlTreeNode<E> getRight() {
        return right;
    }
    
    private void print(StringBuilder buffer, String prefix, String childrenPrefix){        
        buffer.append(prefix);
        buffer.append(key);
        buffer.append(SEPARADOR);
        
        if(left!=null && right!=null){
            //ambos hijos existen
            left.print(buffer, childrenPrefix + "---", childrenPrefix +"   ");
            right.print(buffer, childrenPrefix + "+++", childrenPrefix +"|   ");
        }else if(left!=null)//tiene hijo izq
            left.print(buffer, childrenPrefix + "---", childrenPrefix +"   ");
        else if(right!=null)
            right.print(buffer, childrenPrefix + "+++", childrenPrefix +"|   ");
    }
    

    @Override
    public String toString() {
        StringBuilder buffer=new StringBuilder();
        print(buffer,"","");
        return buffer.toString();
    }
    
    
    
}
