package uni.aed.treeTDA.TBT;

public class TBTNode<E> {
    private E key;
    private boolean succesor;
    private TBTNode<E> left;
    private TBTNode<E> right;
    private static final String SEPARADOR = "\n";

    public TBTNode(E key) {
        this(key,null,null );
    }

    public TBTNode(E key, TBTNode<E> left, TBTNode<E> right) {
        this.key = key;
        this.succesor=false;
        this.left = left;
        this.right = right;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public void setSuccesor(boolean succesor) {
        this.succesor = succesor;
    }

    public void setLeft(TBTNode<E> left) {
        this.left = left;
    }

    public void setRight(TBTNode<E> right) {
        this.right = right;
    }

    public E getKey() {
        return key;
    }

    public boolean isSuccesor() {
        return succesor;
    }

    public TBTNode<E> getLeft() {
        return left;
    }

    public TBTNode<E> getRight() {
        return right;
    }
    
    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(key);
        //indica si el nodo tiene un hijo o hilo
        if (right != null) {
            if(succesor)
                buffer.append("->hilo hacia:").append(right.key);
        }
        
        buffer.append(SEPARADOR);
        // Imprimir hijo izquierdo si existe
        if (left != null) {
            left.print(buffer, childrenPrefix + "+++", childrenPrefix + "   ");
        }

        // Imprimir hijo derecho solo si NO es un hilo (es un hijo real)
        if (right != null && !succesor) {
            right.print(buffer, childrenPrefix + "---", childrenPrefix + "|   ");
        }
    }
    
    
    @Override
    public String toString(){
        StringBuilder buffer=new StringBuilder();
        print(buffer,"","");
        return buffer.toString();
    }   
}
