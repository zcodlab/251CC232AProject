package uni.aed.treeTDA;

public class BstNodeTDA<E> {
    private E key;
    private BstNodeTDA<E> left,right;
    private static final String SEPARADOR = "\n";

    public BstNodeTDA() {
        left=right=null;
    }

    public BstNodeTDA(E key) {
        this.key = key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public void setLeft(BstNodeTDA left) {
        this.left = left;
    }

    public void setRight(BstNodeTDA right) {
        this.right = right;
    }

    public E getKey() {
        return key;
    }

    public BstNodeTDA getLeft() {
        return left;
    }

    public BstNodeTDA getRight() {
        return right;
    }
    
    
    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        // Escribe el nodo actual
        buffer.append(prefix);
        buffer.append(key);
        buffer.append(SEPARADOR);

        // Lógica de impresión del subárbol izquierdo
        if (left != null && right != null) {
            // Ambos hijos existen
            left.print(buffer, childrenPrefix + "---", childrenPrefix + "   ");
            right.print(buffer, childrenPrefix + "+++", childrenPrefix + "|   ");
        } else if (left != null)
            // Solo hijo izquierdo
            left.print(buffer, childrenPrefix + "---", childrenPrefix + "   ");
        else if (right != null)
            // Solo hijo derecho
            right.print(buffer, childrenPrefix + "+++", childrenPrefix + "   ");        
    }
    
    @Override
    public String toString(){
        StringBuilder buffer=new StringBuilder();
        print(buffer,"","");
        return buffer.toString();
    }   
    
    
}
