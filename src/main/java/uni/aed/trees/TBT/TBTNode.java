package uni.aed.trees.TBT;
//Considerando TBT Unidireccional
public class TBTNode {
    protected int key;    
    protected TBTNode left;
    protected TBTNode right;    
    protected boolean succesor;

    public TBTNode(int key) {
        this(key,null,null );
    }

    public TBTNode(int key, TBTNode left, TBTNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.succesor = false;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append("key=" + key+", succesor="+succesor+"");
        if(this.left!=null)
            str.append(" left=" + left.key );
        if(this.right!=null)
            str.append(" right=" + right.key );
        
        return str.toString();
    }
    
    
    
    
    
}
