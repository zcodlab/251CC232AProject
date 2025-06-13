package uni.aed.treeTDA;

import uni.aed.model.Persona;

public class BstTDAMain {
    StringBuilder str=new StringBuilder();
    public static void main(String[] args){
        BstTDAMain bSTMain=new BstTDAMain();    
        //bSTMain.testBstTDAInteger();
        //bSTMain.testBstTDAString();
        bSTMain.testBstTDAPersona();        
    }
    
    private void testBstTDAInteger(){
        BstTDA<Integer> tree=new BstTDA<>();
        tree.add(15);
        tree.add(4);
        tree.add(20);
        tree.add(17);
        tree.add(19);   
        System.out.println(tree.toString());        
    }
    private void testBstTDAString(){
        BstTDA<String> tree=new BstTDA<>();
        tree.add("Jose");
        tree.add("Beatriz");
        tree.add("Ana");
        tree.add("Mario");
        tree.add("Ronald");   
        System.out.println(tree.toString());        
    }
    
    private void testBstTDAPersona(){
        BstTDA<Persona> tree=new BstTDA<>();
        Persona p1=new Persona("Elon Musk",60,'M');        
        Persona p2=new Persona("Barack Obama",60,'M');
        Persona p3=new Persona("Dina Boluarte",50,'F');
        Persona p4=new Persona("Mick Jagger",70,'M');
        Persona p5=new Persona("Sonya Smith",30,'F');        
        Persona p6=new Persona("Donald Trump",75,'M');
        Persona p7=new Persona("Javier Macias",35,'M');
        
        tree.add(p1);
        tree.add(p2);
        tree.add(p3);
        tree.add(p4);
        tree.add(p5);
        tree.add(p6);
        System.out.println("Visualizando el arbol");
        System.out.println(tree.toString());        
        
        System.out.println("Realizando una llamanda inorder(LVR)");        
        tree.inorder(str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando una llamanda preorder(VLR)");
        str.setLength(0);
        tree.preorder(str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando una llamanda postorder(LRV)");
        str.setLength(0);
        tree.postorder(str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando una busqueda del elemento Barack Obama");
        str.setLength(0);
        tree.visit(tree.search(p2),str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando una busqueda del elemento Javier Macias");
        str.setLength(0);
        tree.visit(tree.search(p7),str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando una llamada al metodo primero en amplitud");        
        str.setLength(0);
        tree.breadthFirst(str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando eliminacion por copiado del nodo raiz: Elon Musk");        
        int result=tree.deleteByCopying(p1);
        if (result!=1)
            System.out.println("\nEl valor a eliminar "+p1.getName().toString()+" no se encuentra en el arbol o el arbol se encuentra vacio");
        System.out.println("Visualizando el arbol");
        System.out.println(tree.toString());        
        
        
        System.out.println("\nRealizando eliminacion por fusion del nodo raiz: Donald Trump");        
        result=tree.deleteByMerging(p6);
        if (result!=1)
            System.out.println("\nEl valor a eliminar "+p6.getName().toString()+" no se encuentra en el arbol o el arbol se encuentra vacio");
        System.out.println("Visualizando el arbol");
        System.out.println(tree.toString());        
    }
    
    private void add(){
        StringBuilder str=new StringBuilder();
        BstTDA<Integer> tree=new BstTDA();
        tree.add(10);
        tree.add(5);
        tree.add(20);
        tree.add(4);
        tree.add(6);
        tree.add(15);
        tree.add(30);
        tree.add(0);
        tree.add(7);
        tree.add(13);
        tree.add(8);
        System.out.println("Realizando una llamanda inorder(LVR)");        
        tree.inorder(str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando una llamanda preorder(VLR)");
        str.setLength(0);
        tree.preorder(str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando una llamanda postorder(LRV)");
        str.setLength(0);
        tree.postorder(str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando una busqueda del elemento 13");
        str.setLength(0);
        tree.visit(tree.search(13),str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando una llamada al metodo primero en amplitud");        
        str.setLength(0);
        tree.breadthFirst(str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando eliminacion por copiado del nodo raiz: 10");
        str.setLength(0);
        int result=tree.deleteByCopying(10);
        if (result!=1)
            System.out.println("\nEl valor a eliminar no se encuentra en el arbol o el arbol se encuentra vacio: 10");
        tree.inorder(str);
        System.out.println(str.toString());
        
        System.out.println("\nRealizando eliminacion por fusion del nodo raiz: 10");
        str.setLength(0);
        result=tree.deleteByMerging(20);
        if (result!=1)
            System.out.println("\nEl valor a eliminar no se encuentra en el arbol o el arbol se encuentra vacio: 10");
        tree.inorder(str);
        System.out.println(str.toString());
    }
    
}
