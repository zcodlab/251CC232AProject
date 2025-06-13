package uni.aed.treeTDA.TBT;

import uni.aed.model.Persona;

public class TBTMain {
    StringBuilder str=new StringBuilder();
    public static void main(String[] args){
        TBTMain tBTMain=new TBTMain();
        //tBTMain.testTbtTDAInteger();        
        //tBTMain.testTbtTDAString();
        tBTMain.testTbtTDAPersona();
    }
    private void testTbtTDAInteger(){
        TBT<Integer> tbt=new TBT<>();
        tbt.add(15);
        tbt.add(4);
        tbt.add(20);
        tbt.add(17);
        tbt.add(19);
        System.out.println("Viusualizando el TBT");
        System.out.println(tbt.toString());
        
        System.out.println("Realizando un recorrido Inorder(LVR)");
        tbt.TBTInOrder(str);
        System.out.println(str.toString());
        
    }
     private void testTbtTDAString(){
        TBT<String> tree=new TBT<>();
        tree.add("Jose");
        tree.add("Beatriz");
        tree.add("Ana");
        tree.add("Mario");
        tree.add("Ronald");   
        System.out.println("Viusualizando el TBT");
        System.out.println(tree.toString());        
    }
    private void testTbtTDAPersona(){
        TBT<Persona> tree=new TBT<>();
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
    }
}
