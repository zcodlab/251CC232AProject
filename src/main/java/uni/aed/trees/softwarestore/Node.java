package uni.aed.trees.softwarestore;

public class Node<E> {
    private static final String SEPARADOR = "\n";
    private E key;
    private int filePosition;
    private Node left;
    private Node right;

    public Node(E key, int filePosition) {
        this.key = key;
        this.filePosition = filePosition;
        this.left=null;
        this.right=null;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public void setFilePosition(int filePosition) {
        this.filePosition = filePosition;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public E getKey() {
        return key;
    }

    public int getFilePosition() {
        return filePosition;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
    
    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        // Escribe el nodo actual
        buffer.append(prefix);
        buffer.append(key+"(fp:"+filePosition+")");
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
