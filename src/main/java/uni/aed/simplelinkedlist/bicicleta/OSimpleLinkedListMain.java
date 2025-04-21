package uni.aed.simplelinkedlist.bicicleta;

import uni.aed.model.Bicicleta;

public class OSimpleLinkedListMain {
    public static void main(String[] args){
        OSimpleLinkedListMain listaMain=new OSimpleLinkedListMain();       
        listaMain.testOSimpleLinkedList();
    }
    private void testOSimpleLinkedList(){
        OSimpleLinkedList lista=new OSimpleLinkedList();
        Bicicleta b1=new Bicicleta("Sonya Smith");
        Bicicleta b2=new Bicicleta("Barack Obama");
        Bicicleta b3=new Bicicleta("Kamala Harris");
        Bicicleta b4=new Bicicleta("Dina Boluarte");
        Bicicleta b5=new Bicicleta("Steve Jobs");
        Bicicleta b6=new Bicicleta("Sonya Smith");
        Bicicleta b7=new Bicicleta("Bill Gates");
        Bicicleta b8=new Bicicleta("Sonya Smith");
        lista.addLast(b1);
        lista.addLast(b2);
        lista.addLast(b3);
        lista.addLast(b4);
        lista.addLast(b5);
        lista.addLast(b6);
        lista.addLast(b7);
        lista.addLast(b8);
        System.out.println("Visualizando la Lista enlazada:");
        System.out.println(lista.toString());                 
        System.out.println("El nombre del propietario de la bicicleta se ubico en la posicion:"+lista.searchDuplicados(b1));
    }
}
