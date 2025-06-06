package uni.aed.trees;
public class BSTMain {
    public static void main(String[] args){
        BSTMain bSTMain=new BSTMain();
        bSTMain.testDeleteByCopying();
        //bSTMain.testInsert();
        
    }
    private void testInsert(){
        BST tree =new BST();
        tree.insert(15);
        tree.insert(4);
        tree.insert(20);
        tree.insert(17);
        tree.insert(19);    
        
        System.out.println("Visualizar arbol");
        System.out.println(tree.toString());
        
        
        StringBuilder str=new StringBuilder();
        System.out.println("Realizando una llamada inorder(LVR)");
        tree.inorder(str);
        System.out.println(str.toString());
        
        System.out.println("Realizando una llamada preorder(LVR)");
        str.setLength(0);
        tree.preorder(str);
        System.out.println(str.toString());
        
        System.out.println("Realizando una llamada postorder(LVR)");
        str.setLength(0);
        tree.postorder(str);
        System.out.println(str.toString());
        
        System.out.println("Realizando recorrido primero en amplitud");
        str.setLength(0);
        tree.breadthFirst(str);
        System.out.println(str.toString());
        
        System.out.println("Realizando busqueda del elemento 17");
        str.setLength(0);
        tree.visit(tree.search(17), str);
        System.out.println(str.toString());
        
        System.out.println("Realizando busqueda del elemento 170");
        str.setLength(0);
        tree.visit(tree.search(170), str);
        System.out.println(str.toString());
    }
    
    private void testDeleteByCopying(){
        BST tree =new BST();
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.insert(4);
        tree.insert(6);    
        tree.insert(15);    
        tree.insert(30);    
        tree.insert(0);    
        tree.insert(7);    
        tree.insert(13);    
        tree.insert(8);    
        
        System.out.println("Visualizar arbol");
        System.out.println(tree.toString());
        
        System.out.println("Realizando la eliminacion por copiado del nodo raiz 10");
        int result=tree.deleteByCopying(10);
        if(result==-1)
            System.out.println("El valor a eliminar no se ubico en el arbol");
        
        System.out.println("Visualizar arbol");
        System.out.println(tree.toString());
    }
    
}
