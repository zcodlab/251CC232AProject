package uni.aed.tda.LinkedListTDA;

import uni.aed.tda.ListTDA.ListTDA;

public class LinkedListTDAMain {
    public static void main (String[] args){
        LinkedListTDAMain listaTDAMain=new LinkedListTDAMain();        
        
    }
    private void testLinkedListTDAString(){
        ListTDA<String> lista=new LinkedListTDA<>();
        System.out.println("Antes de añadir elementos "+ lista.size());
        lista.add("Jose");
        lista.add("Beatriz");
        lista.add("Sandro");
        System.out.println("Despues de añadir elementos "+ lista.size());
        
        
    }
    
}
