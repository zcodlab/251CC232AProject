package uni.aed.treeTDA.TBT;

public class TBT<E extends Comparable<E>> {
    public static final int NOT_FOUND=-1;
    private TBTNode<E> root;
    public TBT() {
        root=null;
    }    
    public void add(E value){
        TBTNode<E> newNode= new TBTNode<>(value);
        TBTNode<E> p=root;
        TBTNode<E> prev=null;
        if(root==null){
            root=newNode; 
            return;
        }
        while(p!=null){
            prev=p;
            if(value.compareTo(p.getKey())<0)
                p=p.getLeft();
            else{
                if(!p.isSuccesor())
                    p=p.getRight();
                else
                    break;}}
        if(value.compareTo(prev.getKey())<0){
            prev.setLeft(newNode);
            newNode.setSuccesor(true);
            newNode.setRight(prev);
        }else{
            if(prev.isSuccesor()){                
                prev.setSuccesor(false);
                newNode.setSuccesor(true);
                newNode.setRight(prev.getRight());
            }
            prev.setRight(newNode);
        }
    }    
    
    protected void visit(TBTNode p,StringBuilder str){
        if(p==null){
            str.append(NOT_FOUND);
            return;
        }
        if (!str.isEmpty()) 
            str.append(",");  
        str.append(p.getKey());   
    }    
    protected void TBTInOrder(StringBuilder str){ //LVR
        TBTNode<E> prev;
        TBTNode<E> p=root;
        if(p==null)
            return;
        while(p.getLeft()!=null)
            p=p.getLeft();
        while(p!=null){
            visit(p,str);
            prev=p;
            p=p.getRight();
            if(p!=null && !prev.isSuccesor()){
                while(p.getLeft()!=null)
                    p=p.getLeft();
            }
                
        }
    }

    @Override
    public String toString() {
         return root.toString();      
    }
    
}
