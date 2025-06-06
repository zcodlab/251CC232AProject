package uni.aed.trees.TBT;

public class TBTMain {
    public static void main(String[] args){
        TBTMain tBTMain=new TBTMain();
        tBTMain.testInsert();
        
    }
    private void testInsert(){
        TBT tbt=new TBT();
        tbt.insert(15);
        tbt.insert(4);
        tbt.insert(20);
        tbt.insert(17);
        tbt.insert(19);
        
        //incompleto, falta implementar el metodo print
        //System.out.println("Visualizar arbol");
        //System.out.println(tbt.toString());
        
        System.out.println("Realizando un recorrido primero en profundidad: inOrder");
        tbt.TBTInOrder();
    }
    
}
