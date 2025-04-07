package uni.aed.sort;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SortObjectMain {
    private static final Scanner scr=new Scanner(System.in).useDelimiter("\n");    
    private static SortObject sort;
    private Object[] X=null;
    
    public static void main(String[] args){
        SortObjectMain sortObjectMain=new SortObjectMain();        
        sort=new SortObject();
        sortObjectMain.menu();        
    }
    private void menu(){
        String SEPARADOR="\n";
        int opcion=3;
        try{
            do{
                System.out.println("Algoritmos de Busqueda y Ordenamiento " +SEPARADOR+
                    "1.-Carga Fija de Datos en Array "+SEPARADOR+
                    "2.-Carga Personalizada de Datos en Array "+SEPARADOR+
                    "3.-Visualizar Array "+SEPARADOR+                    
                    "4.-Ordenamiento MergeSort "+SEPARADOR+                    
                    "5.-Salir "+SEPARADOR+ "Elija una opcion:");
                opcion=scr.nextInt();
                switch(opcion){
                    case 1->{carga();visualizar();}
                    case 2->{cargaPersonalizada();visualizar();}
                    case 3->{visualizar();}                                                          
                    case 4->{callMergeSort();}                    
                    case 5->{System.out.println("Saliendo..."); return;}//salir del programa
                    default->System.out.println("Opcion Invalida....");
                }                
            }while(opcion!=5);            
        }catch(InputMismatchException e){
            System.out.println("Debe ingresar un numero "+ e.toString());
        }catch(Exception e){
            System.out.println("Se presento un error "+ e.toString());
        }
    }
    
    private void carga(){
        //Integer[] Y={15,1,25,60,69,86,3,78,2,10};
        String[] Y = {"ape", "cat", "bee", "bat", "eel",
                         "dog", "gnu", "yak", "fox", "cow",
                         "hen", "tic", "man"};
        X=Y.clone();        
        sort.setX(X);
    }
    private void cargaPersonalizada(){
        System.out.println("Ingrese el tamaño del array");
        int N=scr.nextInt();
        X=new Object[N];
        for(int i=0;i<X.length;i++){
            System.out.println("Ingrese el valor X["+i+"]=");
            X[i]=scr.nextInt();
        }
        sort.setX(X);
    }
    
    private void visualizar(){
        System.out.println("El array contiene los siguientes elementos:");
        System.out.println(sort.toString());
    }
    private void callMergeSort(){
        Object[] Y=X.clone();
        sort.setX(Y);
        System.out.println("Array inicial: " + sort.toString());
        sort.callMergeSort();
        System.out.println("Array final: " + sort.toString());        
    }
}
