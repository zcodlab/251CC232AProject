package uni.aed.circlelinkedlist.Joshepus;

import java.util.Scanner;
import uni.aed.circlelinkedlist.CircleLinkedList;

public class JoshepusMain {
    CircleLinkedList lista=new CircleLinkedList();
    int M;
    public static void main(String[] args){
        boolean salir=false;
        JoshepusMain joshepus=new JoshepusMain();
        Scanner scr=new Scanner(System.in).useDelimiter("\n");
        while(!salir){
            System.out.println("Caso: Joshepus - Elija una opcion de Menu");
            System.out.println("a) Definir M");
            System.out.println("b) Registrar Estudiantes");
            System.out.println("c) Ordenar Estudiantes");
            System.out.println("d) Remover cada N-esimo Estudiante");
            System.out.println("e) visualizar la lista");
            System.out.println("f) Salir");
            String opcion=scr.next();
            switch(opcion){
                case "a"->{ System.out.println("Inserte M");
                            int m=scr.nextInt();
                            }
                case "b"->{ joshepus.registrar();}                
            }
            
            
            
        }
    }
    private void definirM(int m){
        M=m;
    }
    private void registrar(){
        for(int i=0;i<M;i++)
            lista.addLast(random(1,10));
    }
    private int random(int low, int high){
        return (int) Math.floor(Math.random()*(high-low+1) + low);
    }
    private void remover(int n){
        System.out.println("Removiendo cada N elementos de la lista");
        System.out.println("El sobreviviente es: "+ lista.remover(n));        
    }
    private void visualizar(){
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());
    }
    
}
