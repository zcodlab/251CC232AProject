package uni.aed.trees.AVL;

import uni.aed.model.Persona;

public class AvlTreeMain {    
    public static void main(String[] args){
        AvlTreeMain avl=new AvlTreeMain();
        avl.testAvlInteger();
        //avl.testAvlString();
        //avl.testAvlPersona();
        
    }
    private void testAvlInteger(){
        AvlTree<Integer> tree=new AvlTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(25);
        System.out.println("Visualizando el arbol AVL");
        System.out.println(tree.toString());                
        
        System.out.println("Eliminando el nodo 20 en el arbol");
        System.out.println(tree.delete(20));
        
        System.out.println("Visualizando el arbol AVL");
        System.out.println(tree.toString());                
        
        System.out.println("Eliminando el nodo 200 en el arbol");
        System.out.println(tree.delete(200));
        
        System.out.println("Visualizando el arbol AVL");
        System.out.println(tree.toString());                
    }
    
    private void testAvlString(){
        AvlTree<String> tree=new AvlTree<>();
        tree.add("Ana");
        tree.add("Beatriz");
        tree.add("Jose");
        tree.add("Mario");
        tree.add("Ronald");        
        System.out.println("Visualizando el arbol AVL");
        System.out.println(tree.toString());                
    }
    private void testAvlPersona(){
        AvlTree<Persona> tree=new AvlTree<>();
        Persona p1=new Persona("Barack Obama",random(18, 70),random(0,1)==0?'M':'F');
        Persona p2=new Persona("Dina Boluarte",random(18, 70),random(0,1)==0?'M':'F');
        Persona p3=new Persona("Donald Trump",random(18, 70),random(0,1)==0?'M':'F');              
        Persona p4=new Persona("Mick Jagger",random(18, 70),random(0,1)==0?'M':'F');      
        Persona p5=new Persona("Sonya Smith",random(18, 70),random(0,1)==0?'M':'F');
        tree.add(p1);
        tree.add(p2);
        tree.add(p3);
        tree.add(p4);
        tree.add(p5);        
        System.out.println("Visualizando el arbol AVL");
        System.out.println(tree.toString());                
    }
    private int random(int low, int high) {
        return (int) Math.floor(Math.random() * (high - low + 1)) + low;
    }
}
