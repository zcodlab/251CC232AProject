/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.pruebaentrada;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Prueba de Entrada 251
 * Programa que que permite registrar tres personas y calcular la edad promedio
 * @author uni.cc232
 */
public class AgendaMain {
    private static int N = 0;
    private static final Scanner scr=new Scanner(System.in).useDelimiter("\n");    
    private static Agenda agenda;
    
    public static void main(String[] args){        
        AgendaMain agendaMain=new AgendaMain();
        agendaMain.menu();        
    }
    
   private void menu(){        
        char Rpta='S';				
	String SEPARADOR="\n";	                            
        try{            
            do			
            {	
                System.out.print("Agenda Electrónica"+SEPARADOR+
                "1.- Registrar Persona "+SEPARADOR+
                "2.- Imprimir Agenda "+SEPARADOR+
                "3.- Imprimir Edad Promedio "+SEPARADOR+                                
                "4.- Salir "+SEPARADOR+
                "Elija una opcion:");                
                
                int opcion =scr.nextInt();            
                switch (opcion)
                {
                    case 1 -> {registrarPersona();}
                    case 2 -> {imprimirDirectorio();}
                    case 3 -> {imprimirEdadPromedio();}                    
                    default -> {break;}
                }	            
                System.out.print("Para continuar con las operaciones pulsa S; Para finalizar pulse N: ");
                Rpta=(scr.next()).toUpperCase().charAt(0);                
            }while(Rpta=='S');	
        }catch(InputMismatchException e) {
            System.out.println("Debe ingresar obligatoriamente un número entero como opcion elegida." + e.toString());
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        scr.close();
    }
    
   private void registrarPersona(){
       if (N==0){
            System.out.println("Ingrese el tamaño del Directorio:");
            N=scr.nextInt();
            if (N<1){
                System.out.println("El tamaño del Directorio debe ser un entero mayor a 1:");
                return;
            }
            agenda=new Agenda(N);
       }
       
       System.out.println("Ingrese datos de la Persona:");
       
       System.out.println("Ingrese Nombre:");
       String nombre=scr.next();
       System.out.println("Ingrese Edad:");
       int edad=scr.nextInt();
       System.out.println("Ingrese Genero:");
       char genero=(scr.next()).toUpperCase().charAt(0);
       
       Persona p=new Persona(nombre,edad,genero);
       agenda.registrarPersona(p);
   }
   private void imprimirDirectorio(){
       System.out.println(agenda.toString());
   }
   private void imprimirEdadPromedio(){
       System.out.println("La Edad Promedio es: " + agenda.calcularEdadPromedio());
   }
   
}
