package uni.aed.tda.LinkedListTDA;

import uni.aed.model.Persona;
import uni.aed.tda.ListTDA.ListTDA;

public class LinkedListTDAMain {
    public static void main (String[] args){
        LinkedListTDAMain listaTDAMain=new LinkedListTDAMain();        
        listaTDAMain.testLinkedListTDAString();
        listaTDAMain.testLinkedListTDAPersona();
        
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
        
        String elemento="Adelaida";
        if(lista.contain(elemento)==true){
            System.out.println("El elemento buscado "+ elemento+ " se encuentra en la posicion "+ lista.indexOf(elemento) +" se procedera a su eliminacion");
            System.out.println("Eliminando el elemento "+ elemento);
            lista.delete(lista.indexOf(elemento));
        }else
            System.out.println("Elemento "+ elemento+ " no se encontro en el registro");
        
        System.out.println("Visualizando la lista");
        System.out.println("Despues de añadir elementos "+ lista.size());
        System.out.println(lista.toString());
        
    }
    private void testLinkedListTDAPersona(){
        ListTDA<Persona> lista=new LinkedListTDA<>();
        System.out.println("Antes de añadir elementos "+ lista.size());
        Persona p1=new Persona("Sonya Smith",30,'F');
        Persona p2=new Persona("Barack Obama",60,'M');
        Persona p3=new Persona("Dina Boluarte",50,'F');
        Persona p4=new Persona("Donal Trump",65,'M');
        
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);        
        
        System.out.println("Visualizando la lista");
        System.out.println("Despues de añadir elementos "+ lista.size());
        System.out.println(lista.toString());
        
        Persona p5=new Persona("Steve Jobs",53,'M');
        
        lista.add(2,p5);        
        System.out.println("Visualizando la lista");
        System.out.println("Despues de añadir elementos "+ lista.size());
        System.out.println(lista.toString());        

        if(lista.contain(p4)==true){
            System.out.println("El elemento buscado "+ p4.getName()+ " se encuentra en la posicion "+ lista.indexOf(p4) +" se procedera a su eliminacion");
            System.out.println("Eliminando el elemento "+ p4.getName());
            lista.delete(lista.indexOf(p4));
        }else
            System.out.println("Elemento "+ p4.toString()+ " no se encontro en el registro");
        
        System.out.println("Visualizando la lista");
        System.out.println("Despues de añadir elementos "+ lista.size());
        System.out.println(lista.toString());
        
    }
}
