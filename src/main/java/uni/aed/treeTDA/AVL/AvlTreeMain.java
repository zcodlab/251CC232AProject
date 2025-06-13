package uni.aed.treeTDA.AVL;

import uni.aed.model.Persona;
import uni.aed.treeTDA.BstTDA;

public class AvlTreeMain {
    
    public static void main(String[] args){
        AvlTreeMain avlTreeMain=new AvlTreeMain();
        //avlTreeMain.testBstTDAInteger();
        //avlTreeMain.testBstTDAString();
        avlTreeMain.testBstTDAPersona();
    }
    private void testBstTDAInteger(){
        BstTDA<Integer> bst =new BstTDA<>();
        bst.add(10);
        bst.add(20);
        bst.add(30);
        bst.add(40);
        bst.add(50);
        bst.add(25);
        System.out.println("Visualizando el arbol BST");
        System.out.println(bst.toString());        
        
        AvlTree<Integer> tree =new AvlTree<>();        
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(25);
        System.out.println("Visualizando el arbol AVL");
        System.out.println(tree.toString());        
        
        System.out.println("Realizando el recorrido en profundidad- preorder(LVR)");
        System.out.println(tree.PreOrder());
        System.out.println("Eliminando nodo 20 en el arbol");
        System.out.println(tree.delete(20));
        System.out.println("Visualizando el arbol despues de la operacion");
        System.out.println(tree.toString());
        System.out.println("Realizando el recorrido en profundidad- preorder(LVR)");
        System.out.println(tree.PreOrder());
        System.out.println("Eliminando nodo 200 en el arbol");
        System.out.println(tree.delete(200));
        System.out.println("Visualizando el arbol despues de la operacion");
        System.out.println(tree.toString());
        System.out.println("Realizando el recorrido en profundidad- preorder(LVR)");
        System.out.println(tree.PreOrder());
    }
    private void testBstTDAString(){
        BstTDA<String> bst =new BstTDA<>();
        bst.add("Ana");
        bst.add("Beatriz");        
        bst.add("Jose");
        bst.add("Mario");
        bst.add("Ronald"); 
        System.out.println("Visualizando el arbol BST");
        System.out.println(bst.toString());  
         
        AvlTree<String> tree=new AvlTree<>();
        tree.add("Ana");
        tree.add("Beatriz");        
        tree.add("Jose");
        tree.add("Mario");
        tree.add("Ronald");   
        System.out.println("Visualizando el arbol AVL");
        System.out.println(tree.toString());           
        
        System.out.println("Eliminando nodo Ana en el arbol");
        System.out.println(tree.delete("Ana"));
        System.out.println("Visualizando el arbol despues de la operacion");
        System.out.println(tree.toString());
        System.out.println("Realizando el recorrido en profundidad- preorder(LVR)");
        System.out.println(tree.PreOrder());
        System.out.println("Eliminando nodo Donald en el arbol");
        System.out.println(tree.delete("Donald"));
        System.out.println("Visualizando el arbol despues de la operacion");
        System.out.println(tree.toString());
        System.out.println("Realizando el recorrido en profundidad- preorder(LVR)");
        System.out.println(tree.PreOrder());
    }
    private void testBstTDAPersona(){
        BstTDA<Persona> bst =new BstTDA<>();
        Persona p1=new Persona("Barack Obama",60,'M');
        Persona p2=new Persona("Dina Boluarte",50,'F');
        Persona p3=new Persona("Donald Trump",75,'M');
        Persona p4=new Persona("Elon Musk",60,'M');        
        Persona p5=new Persona("Mick Jagger",70,'M');
        Persona p6=new Persona("Sonya Smith",30,'F');      
        Persona p7=new Persona("Javier Macias",35,'M');
        
        bst.add(p1);
        bst.add(p2);
        bst.add(p3);
        bst.add(p4);
        bst.add(p5); 
        bst.add(p6); 
        System.out.println("Visualizando el arbol BST");
        System.out.println(bst.toString());  
         
        AvlTree<Persona> tree=new AvlTree<>();
        tree.add(p1);
        tree.add(p2);
        tree.add(p3);
        tree.add(p4);
        tree.add(p5); 
        tree.add(p6);  
        System.out.println("Visualizando el arbol AVL");
        System.out.println(tree.toString());           
        
        System.out.println("Eliminando nodo Barack en el arbol");
        System.out.println(tree.delete(p1));
        System.out.println("Visualizando el arbol despues de la operacion");
        System.out.println(tree.toString());
        System.out.println("Realizando el recorrido en profundidad- preorder(LVR)");
        System.out.println(tree.PreOrder());
        System.out.println("Eliminando nodo Donald en el arbol");
        System.out.println(tree.delete(p3));
        System.out.println("Visualizando el arbol despues de la operacion");
        System.out.println(tree.toString());
        System.out.println("Realizando el recorrido en profundidad- preorder(LVR)");
        System.out.println(tree.PreOrder());
    }
}
