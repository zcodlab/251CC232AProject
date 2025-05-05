package uni.aed.tda.LinkedListTDA;

import uni.aed.tda.ListTDA.ListTDA;

public class LinkedListTDAMain {
    public static void main (String[] args){
        LinkedListTDAMain listaTDAMain=new LinkedListTDAMain();        
        listaTDAMain.testLinkedListTDAString();
        
    }
    private void testLinkedListTDAString(){
        ListTDA<String> lista=new LinkedListTDA<>();
        System.out.println("Antes de añadir elementos "+ lista.size());
        lista.add("Jose");
        lista.add("Beatriz");
        lista.add("Sandro");
        System.out.println("Visualizando la lista");
        System.out.println("Despues de añadir elementos "+ lista.size());
        System.out.println(lista.toString());
        System.out.println("Añadiendo en la posicion 2");
        
        lista.add(2,"Adelaida");        
        System.out.println("Visualizando la lista");
        System.out.println("Despues de añadir elementos "+ lista.size());
        System.out.println(lista.toString());
        
        
    }
    
}
