package uni.aed.trees;
public class BST {
    public static final int NOT_FOUND=-1;
    public static final int IS_EMPTY=0;
    public static final int FOUND=1;    
    protected BSTNode root;

    public BST() {
        this.root=null;
    }    
    public void insert(int e){
        BSTNode p=root,prev=null;
        while(p!=null){
            prev=p;
            if(p.getKey()<e)
                p=p.getRight();
            else
                p=p.getLeft();
        }
        if(root==null)
            root=new BSTNode(e);
        else if(prev.getKey()<e)
            prev.setRight(new BSTNode(e));
        else
            prev.setLeft(new BSTNode(e));
    }
    
    public void visit(BSTNode p,StringBuilder str){
        if(p==null)
            str.append(NOT_FOUND);
        if(!str.isEmpty())
            str.append(",");
        str.append(p.getKey());
    }
    
    //LVR:recorrido primero en profundidad: inorder
    public void inorder(StringBuilder str){
        inorder(root,str);
    }
    private void inorder(BSTNode p,StringBuilder str){
        if(p!=null){
            inorder(p.getLeft(),str);//L
            visit(p,str);            //V
            inorder(p.getRight(),str);//R
        }            
    }
    
}
