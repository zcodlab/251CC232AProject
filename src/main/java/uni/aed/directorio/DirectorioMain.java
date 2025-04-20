/*Solucion enunciado 2-pc1 de la linea 19 a la linea 69
*/
package uni.aed.directorio;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import uni.aed.model.Persona;
import uni.aed.sort.SortObject;

public class DirectorioMain {
    private static final Scanner scr=new Scanner(System.in).useDelimiter("\n");
    Directorio directorio = new DirectorioV1();
    Object[] sortedlist=null;
    public static void main(String[] args) {
        DirectorioMain directorioMain = new DirectorioMain();
        directorioMain.pc1Menu();                
    }    
    private void pc1Menu(){
        
        int opcion = 0;
        try{
            do{
                System.out.println("Ingrese opción\n1.Registrar Persona\n2.Ordenar por heapsort\n3.Visualizar Directorio\n4.Salir");
                opcion = scr.nextInt();
                switch (opcion){
                    case 1:registrarPersona();break;                      
                    case 2:ordenarPersonas();break;
                    case 3:visualizarDirectorio();break;
                    case 4:System.out.println("Saliendo...\n");break;
                    default:System.out.println("Opcion inválida");break;
                }
            }while(opcion!=4);
        }catch (Exception e){
            System.out.println("Error");
        }
    }
    private void registrarPersona(){
        Persona p = new Persona();
        System.out.println("Ingrese nombre");
        p.setName(scr.next());
        System.out.println("Ingrese edad");
        p.setAge(scr.nextInt());
        System.out.println("Ingrese género");
        p.setGender(scr.next().charAt(0));
        directorio.add(p);
    }
    private void ordenarPersonas(){
        System.out.println("Ingrese el atributo por el que ordenar : (1.Edad/2.Nombre)");
        switch (scr.nextInt()){
            case 1:
                sortedlist=directorio.sort(Persona.AGE,"HEAPSORT");                
                break;
            case 2:
                sortedlist=directorio.sort(Persona.NAME,"HEAPSORT");                
                break;
            default:
                break;
        }
        visualizarDirectorio();
    }
    private void visualizarDirectorio(){
        if (sortedlist==null){
            System.out.println( directorio.toString());
            return;
        }
        for(Object p: sortedlist)
            System.out.println( ((Persona)p).toString());        
    }
    
    private void menu(){
        String SEPARADOR="\n";
        int opcion=3;
        try{
            do{
                System.out.println("Test Directorio " +SEPARADOR+
                    "1.-Test Directorio V1,V2,V3 "+SEPARADOR+                    
                    "2.-Ordenamiento Personas - MergeSort "+SEPARADOR+
                    "3.-Ordenamiento Enteros - MergeSort "+SEPARADOR+                    
                    "4.-Salir "+SEPARADOR+ "Elija una opcion:");
                opcion=scr.nextInt();
                switch(opcion){
                    case 1->{start();}
                    case 2->{mergeSortPersona();}
                    case 3->{mergeSortEnteros();}                    
                    case 4->{System.out.println("Saliendo..."); return;}//salir del programa
                    default->System.out.println("Opcion Invalida....");
                }                
            }while(opcion!=4);            
        }catch(InputMismatchException e){
            System.out.println("Debe ingresar un numero "+ e.toString());
        }catch(Exception e){
            System.out.println("Se presento un error "+ e.toString());
        }
    }
    private void mergeSortPersona(){
        Directorio directorio=new DirectorioV1(4);
        Persona p1=new Persona("Sonya Smith",random(18, 70),random(0,1)==0?'M':'F');
        Persona p2=new Persona("Barack Obama",random(18, 70),random(0,1)==0?'M':'F');
        Persona p3=new Persona("Dina Boluarte",random(18, 70),random(0,1)==0?'M':'F');
        Persona p4=new Persona("Mick Jagger",random(18, 70),random(0,1)==0?'M':'F');     
        
        directorio.add(p1);
        directorio.add(p2);
        directorio.add(p3);
        directorio.add(p4);
        
        System.out.println("Data Persona Origen en Directorio ");
        System.out.println(directorio.toString());
        
        System.out.println("Mergesort:Ordenando por Nombre ");
        Object[] sortedlist = directorio.sort( Persona.NAME,"MERGESORT");        
        for(Object p: sortedlist)
            System.out.println( ((Persona)p).toString( ) );
        
        System.out.println("Mergesort:Ordenando por Edad ");
        sortedlist = directorio.sort( Persona.AGE,"MERGESORT");        
        for(Object p: sortedlist)
            System.out.println( ((Persona)p).toString( ) );
    }
    
    private void mergeSortEnteros(){
        Integer X[]={5,14,24,39,43,65,84,45};        
        System.out.println("Mergesort:Lista origen de Enteros ");        
        for(Object p: X)
            System.out.println( ((Integer)p).toString( ) );
        SortObject sortObject=new SortObject();                 
        sortObject.setX((Object[])X);
        sortObject.callMergeSort();
        System.out.println("Mergesort Ordenando Enteros: "+sortObject.toString());        
    }


    private void start( ) {
        String[] name = {"ape", "cat", "bee", "bat", "eel",
                         "dog", "gnu", "yak", "fox", "cow",
                         "hen", "tic", "man"};
        Persona p;
        Directorio ab;

        int version = Integer.parseInt(
                        JOptionPane.showInputDialog(null,"Uso de Directorio Version #:"));

        switch (version) {
            case 1:  ab = new DirectorioV1(); break;
            case 2:  ab = new DirectorioV2(); break;            
            default: ab = new DirectorioV1(); break;
        }

        for (int i = 0; i < name.length; i++) {
            p = new Persona(name[i], random(10, 50),
                            random(0,1)==0?'M':'F'); //if(random(0,1) ==0) 'M' else 'F'
            ab.add(p);
        }
        System.out.println("Visualizando el Directorio");
        System.out.println( ab.toString());
        
        System.out.println(" ");
        
        Persona[] sortedlist = ab.sort( Persona.AGE );
        for (int i = 0; i < sortedlist.length; i++) {
            System.out.println( sortedlist[i].toString( ) );
        }
        
        System.out.println(" ");
        System.out.println("Visualizando el Directorio");
        System.out.println( ab.toString());
        
        System.out.println(" ");

        sortedlist = ab.sort( Persona.NAME );
        for (int i = 0; i < sortedlist.length; i++) {
            System.out.println( sortedlist[i].toString( ) );
        }
        
        System.out.println(" ");
        System.out.println("Visualizando el Directorio");        
        System.out.println( ab.toString());
        
        System.out.println("Eliminando el elemento fox");
        boolean status=ab.delete("fox");
        System.out.println( ab.toString());   
        
        String valor="cow";        
        System.out.println( "El valor buscado "+valor+ " se encontro en la posicion: "+ab.search(valor, "LINEAL"));
        
    }    
    

    /**
     * Returns a random integer between low
     * and high, inclusive.
     *
     * @param low  the low bound of the random number
     * @param high the high bound of the random number
     *
     * @return a random integer between low and high
     */
    private int random(int low, int high) {
        return (int) Math.floor(Math.random() * (high - low + 1)) + low;
    }
}
