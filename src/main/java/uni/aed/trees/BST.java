package uni.aed.trees;

import uni.aed.queueTDA.LinkedQueueTDA;
import uni.aed.queueTDA.QueueTDA;

public class BST {
    public static final int NOT_FOUND=-1;
    public static final int IS_EMPTY=0;
    public static final int FOUND=1;    
    private BSTNode root;

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
    
    public BSTNode search(int e){
        return search(root,e);
    }
    private BSTNode search(BSTNode p,int e){
        while(p!=null){
            if(e==p.getKey())
                return p;
            else if(e<p.getKey())
                p=p.getLeft();
            else
                p=p.getRight();
        }
        return null;
    }
    
    public void visit(BSTNode p,StringBuilder str){
        if(p==null)
            str.append(NOT_FOUND);
        if(!str.isEmpty())
            str.append(",");
        if(p!=null)
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
    public void preorder(StringBuilder str){
        preorder(root,str);
    }
    private void preorder(BSTNode p,StringBuilder str){
        if(p!=null){
            visit(p,str);            //V
            preorder(p.getLeft(),str);//L            
            preorder(p.getRight(),str);//R
        }            
    }
    
    public void postorder(StringBuilder str){
        postorder(root,str);
    }
    private void postorder(BSTNode p,StringBuilder str){
        if(p!=null){            
            postorder(p.getLeft(),str);//L            
            postorder(p.getRight(),str);//R
            visit(p,str);            //V
        }            
    }    
    //recorrido primero en amplitud
    public void breadthFirst(StringBuilder str){
        BSTNode p=root;
        QueueTDA<BSTNode> queue=new LinkedQueueTDA<>();
        if(p!=null){
            queue.enqueue(p);
            while(!queue.isEmpty()){
                p=queue.dequeue();
                visit(p,str);
                if(p.getLeft()!=null)
                    queue.enqueue(p.getLeft());
                if(p.getRight()!=null)
                    queue.enqueue(p.getRight());
            }
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }
    
}
