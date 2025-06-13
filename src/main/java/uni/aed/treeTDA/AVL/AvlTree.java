package uni.aed.treeTDA.AVL;

public class AvlTree<E extends Comparable<E>> {    
    private static final int NOT_FOUND=-1;
    AvlTreeNode<E> root;    
    
    public void add(E key){
        if(findAvlTreeNode(root,key)==null){
            root=BSTInsert(root,key);                        
        }
    }
    private AvlTreeNode<E> BSTInsert(AvlTreeNode<E> root, E key){
        if(root==null)
            return new AvlTreeNode(key);
        else if(key.compareTo(root.getKey()) < 0)
            root.setLeft(BSTInsert(root.getLeft(),key));
        else
            root.setRight(BSTInsert(root.getRight(),key));
        //proceso para validar si el arbol esta balanceado
        return balanceTree(root);
    }
    
    private AvlTreeNode<E> findAvlTreeNode(AvlTreeNode<E> root,E key){
        if(root==null || key.compareTo(root.getKey())==0)
            return root;
        if(key.compareTo(root.getKey()) < 0)
            return findAvlTreeNode(root.getLeft(),key);
        else
            return findAvlTreeNode(root.getRight(),key);
    }
    
    private AvlTreeNode<E> balanceTree(AvlTreeNode<E> root){
        updateHeight(root);
        int balance=Balance(root);
        if(balance>1){
            if(Balance(root.getRight())<0){
                root.setRight(rotateRigth(root.getRight()));
                return rotateLeft(root);                
            }else 
                return rotateLeft(root);                
        }
        if(balance<-1){
            if(Balance(root.getLeft())>0){
                root.setLeft(rotateLeft(root.getLeft()));
                return rotateRigth(root);                
            }else
                return rotateRigth(root);                
        }
        return root;
    }
    private void updateHeight(AvlTreeNode<E> key){
        key.setHeight(Math.max(Height(key.getLeft()),Height(key.getRight())) + 1);
    }
    
    private int Height(AvlTreeNode<E> key){
        if(key==null)
            return 0;
        else
            return key.getHeight();
    }
    //calculando el factor de balance
    private int Balance(AvlTreeNode<E> key){
        if(key==null)
            return 0;
        else
            return (Height(key.getRight()) - Height(key.getLeft()));
    }
    
    private AvlTreeNode<E> rotateLeft(AvlTreeNode<E> x){
        AvlTreeNode<E> y=x.getRight();
        AvlTreeNode<E> T2=y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        updateHeight(x);
        updateHeight(y);        
        return y;
    }
    
    private AvlTreeNode<E> rotateRigth(AvlTreeNode<E> y){
        AvlTreeNode<E> x=y.getLeft();
        AvlTreeNode<E> T2=x.getRight();        
        x.setRight(y);
        y.setLeft(T2);        
        updateHeight(y);
        updateHeight(x);        
        return x;        
    }
    
    public String PreOrder(){
        return PreOrder(root);
    }
    private String PreOrder(AvlTreeNode<E> node){//VLR
        StringBuilder tree = new StringBuilder();
        if(node!=null){
            tree.append(node.getKey());
            tree.append(",");
            tree.append(PreOrder(node.getLeft()));
            tree.append(PreOrder(node.getRight()));            
        }
        return tree.toString();
            
    }
    public int search(E key){
        if(findAvlTreeNode(root, key)==null)
            return 0;
        else
            return 1;
    }
    public String delete(E key){
        if(findAvlTreeNode(root, key)!=null){
            root=Remove(root, key);          
            return root.toString();            
        }else
            return String.valueOf(NOT_FOUND);
    }
    private AvlTreeNode<E> Remove(AvlTreeNode<E> root, E key){
        if(root==null)
            return root;
        else if(key.compareTo(root.getKey()) < 0)
            root.setLeft(Remove(root.getLeft(),key));
        else if(key.compareTo(root.getKey()) > 0)
            root.setRight(Remove(root.getRight(),key));
        else{
            if(root.getRight()==null)
                root=root.getLeft();
            else if(root.getLeft()==null)
                root=root.getRight();
            else{
                AvlTreeNode<E> temp=Succesor(root.getRight());
                root.setKey(temp.getKey());
                root.setRight(Remove(root.getRight(),root.getKey()));
            }                           
        }
        if(root==null)
            return root;
        else
            return balanceTree(root); 
    }
    private AvlTreeNode<E> Succesor(AvlTreeNode<E> root){
        if(root.getLeft()!=null)
            return Succesor(root.getLeft());
        else
            return root;
    }

    @Override
    public String toString() {
        return root.toString();    
    }
    
    
}
