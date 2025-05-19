package uni.aed.tda.LinkedListTDA;

import java.util.Scanner;
import uni.aed.model.Persona;
import uni.aed.tda.ListTDA.ListTDA;

public class LinkedListTDAMain {
    public static void main(String[] args) {        
        LinkedListTDAMain lista=new LinkedListTDAMain();
        try{
            //lista.testLinkedListTDAString();
            //lista.testLinkedListTDAPersona();
            //lista.testLinkedListTDAManager();
            //lista.testLinkedListTDAUnion();
            lista.pc2();
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());        
        }        
        
    }
    /*Solucion PC2:1*/
    private void pc2(){
        Scanner scr = new Scanner(System.in).useDelimiter("\n");
        ListTDA<String> l1 = new LinkedListTDA<>();
        ListTDA<String> l2 = new LinkedListTDA<>();
        ListTDA<String> result = new LinkedListTDA<>();
        boolean active = true;
        while(active){
            System.out.println("Menu:\n1.Crear lista 1\n2.Crear lista 2\n3.Union\n4.Interseccion\n5.Diferencia\n6.Visualizar resultado\n7.Salir\nIngrese una opcion:");
            int opcion = scr.nextInt();            
            switch (opcion){
                case 1 -> {                                                     
                    cargarLista(l1,scr, "1");
                    result.clear();
                    break;
                }
                case 2 -> {                                        
                    cargarLista(l2,scr, "2");
                    result.clear();
                    break;
                }
                case 3 -> {                    
                    result = result.union(l1,l2);
                    System.out.println("Lista resultante union: "+result.toString());                    
                }
                case 4 -> {
                    result = result.interseccion(l1,l2);
                    System.out.println("Lista resultante interseccion: "+result.toString());                    
                }
                case 5 -> {
                    result = result.diferencia(l1,l2);
                    System.out.println("Lista resultante diferencia: "+result.toString());                    
                }
                case 6 -> {
                    visualizar(l1,l2,result);                
                }
                default -> {
                    active = false;
                    scr.close();
                }
            }
        }

    }
    
    private void cargarLista(ListTDA<String> l,Scanner sc, String id) {        
        System.out.println("Ingresar tamaño de la lista " + id + " :");
        int n = sc.nextInt();        
        for (int i = 0; i < n; i++) {
            System.out.print(" Elemento " + (i + 1) + ": ");
            l.add(sc.next());
        }        
    }
    
    private void visualizar(ListTDA<String> l1,ListTDA<String> l2,ListTDA<String> result) {   
        System.out.println("Lista1 : "+l1.toString());                    
        System.out.println("Lista2 : "+l2.toString());                    
        System.out.println("Lista resultante : "+result.toString());                    
    }
    
    private void testLinkedListTDAString(){
        ListTDA<String> linkedListTDA = new LinkedListTDA<>();
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+linkedListTDA.size());
        linkedListTDA.add("Jose");
        linkedListTDA.add("Beatriz");
        linkedListTDA.add("Sandro");
        linkedListTDA.add("Franklin");
        linkedListTDA.add(2,"Adelaida");        
        System.out.println("Despues de añadir elementos:");	
        System.out.println("Size = "+linkedListTDA.size());
        System.out.println(linkedListTDA.toString());
        String elemento="Adelaida";
        if (linkedListTDA.contain(elemento)==true){            
            System.out.println("El elemento buscado: "+ elemento +" se encuentra en la posicion: "+ linkedListTDA.indexOf(elemento)+" se procedera a su eliminacion.");            
            System.out.println("Eliminando el elemento "+ elemento +" luego de ubicarlo en la lista");
            linkedListTDA.delete(linkedListTDA.indexOf(elemento));
        }else
            System.out.println("El elemento buscado no se encuentra en el Registro");
        //imprimiendo elementos de la LinkedList        
        System.out.println("Añadiedo 1 registro en la posicion 2: Steve Jobs");
        linkedListTDA.add(2, "Steve Jobs");
        //imprimiendo elementos de la LinkedList
        System.out.println(linkedListTDA.toString()); 
    }
    private void testLinkedListTDAPersona(){
        ListTDA<Persona> linkedListTDA = new LinkedListTDA<>();
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+linkedListTDA.size());
        
        Persona p1=new Persona("Sonya Smith",30,'F');
        Persona p2=new Persona("Barack Obama",60,'M');
        Persona p3=new Persona("Dina Boluarte",50,'F');
        Persona p4=new Persona("Mick Jagger",75,'M');
        
        linkedListTDA.add(p1);
        linkedListTDA.add(p2);
        linkedListTDA.add(p3);
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+linkedListTDA.size());
        System.out.println(linkedListTDA.toString());
                
        linkedListTDA.add(1,p4);   
        System.out.println("Despues de añadir 1 elemento: Mick Jagger, posicion 1");	
        System.out.println("Size = "+linkedListTDA.size());        
        System.out.println(linkedListTDA.toString());
        
        linkedListTDA.add(4,p1);   
        System.out.println("Despues de añadir 1 elemento: Sonya Smith, posicion 4");	
        System.out.println("Size = "+linkedListTDA.size());        
        System.out.println(linkedListTDA.toString());
        
        System.out.println("Buscando 1 elemento: Elon Musk");	
        Persona p5=new Persona("Elon Musk",60,'M');
        if (linkedListTDA.contain(p5)==true){            
            System.out.println("El elemento buscado: "+ p5.getName() +" se encuentra en la posicion: "+ linkedListTDA.indexOf(p5)+" se procedera a su eliminacion.");            
            System.out.println("Eliminando el elemento "+ p5.getName() +" luego de ubicarlo en la lista");
            linkedListTDA.delete(linkedListTDA.indexOf(p5));
        }else
            System.out.println("El elemento buscado no se encuentra en el Registro");
        
        System.out.println("Buscando 1 elemento: Barack Obama");
        if (linkedListTDA.contain(p2)==true){            
            System.out.println("El elemento buscado: "+ p2.getName() +" se encuentra en la posicion: "+ linkedListTDA.indexOf(p2)+" se procedera a su eliminacion.");            
            System.out.println("Eliminando el elemento "+ p2.getName() +" luego de ubicarlo en la lista");
            linkedListTDA.delete(linkedListTDA.indexOf(p2));
        }else
            System.out.println("El elemento buscado no se encuentra en el Registro");
        //imprimiendo elementos de la LinkedList        
        System.out.println(linkedListTDA.toString());
        
        System.out.println("Añadiedo 1 registro en la posicion 2: Zhang Yiming");
        linkedListTDA.add(2, new Persona("Zhang Yiming",45,'M'));
        //imprimiendo elementos de la LinkedList        
        System.out.println(linkedListTDA.toString());
        
        Persona p6=new Persona("Nicol Kidman",30,'F');
        Persona p7=new Persona("Robert D'Niro",60,'M');
        Persona p8=new Persona("Silvestre Stallone",50,'F');
        Persona p9=new Persona("Natali Portman",35,'M');
        
        linkedListTDA.add(p6);
        linkedListTDA.add(p7);
        linkedListTDA.add(p8);
        linkedListTDA.add(p9);
        System.out.println("Visualizando la Lista");	
        System.out.println("N° elementos: = "+linkedListTDA.size());
        System.out.println(linkedListTDA.toString());
        linkedListTDA.delete(10, 12);
        System.out.println("Visualizando la Lista");	
        System.out.println("N° elementos: = "+linkedListTDA.size());
        System.out.println(linkedListTDA.toString());
        
    }    
    
}
