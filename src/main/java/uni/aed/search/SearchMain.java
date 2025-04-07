package uni.aed.search;

import java.util.InputMismatchException;
import java.util.Scanner;
import uni.aed.sort.Sort;

public class SearchMain {
    private static final Scanner scr=new Scanner(System.in).useDelimiter("\n");
    private static Search search;
    private static Sort sort;
    private Integer[] X=null;
    
    public static void main(String[] args){
        SearchMain searchMain=new SearchMain();
        search=new Search();
        sort=new Sort();
        searchMain.menu();        
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
                    "4.-Busqueda Lineal "+SEPARADOR+
                    "5.-Busqueda Binaria "+SEPARADOR+
                    "6.-Ordenamiento Burbuja "+SEPARADOR+
                    "7.-Ordenamiento Seleccion "+SEPARADOR+
                    "8.-Ordenamiento Insercion "+SEPARADOR+
                    "9.-Ordenamiento Insercion Binaria"+SEPARADOR+                        
                    "10.-Ordenamiento HeapSort"+SEPARADOR+                        
                    "11.-Salir "+SEPARADOR+ "Elija una opcion:");
                opcion=scr.nextInt();
                switch(opcion){
                    case 1->{carga();visualizar();}
                    case 2->{cargaPersonalizada();visualizar();}
                    case 3->{visualizar();}                    
                    case 4->{callSearchLineal();}                    
                    case 5->{callSearchBinaria();}                    
                    case 6->{callBubbleWuSort();}                    
                    case 7->{callSelectionWuSort();}                    
                    case 8->{callInsercionSort();}                    
                    case 9->{callInsercionBinariaSort();}                    
                    case 10->{callHeapSort();}                    
                    case 11->{System.out.println("Saliendo..."); return;}//salir del programa
                    default->System.out.println("Opcion Invalida....");
                }                
            }while(opcion!=11);            
        }catch(InputMismatchException e){
            System.out.println("Debe ingresar un numero "+ e.toString());
        }catch(Exception e){
            System.out.println("Se presento un error "+ e.toString());
        }
    }
    
    private void carga(){
        Integer[] Y={15,1,25,60,69,86,3,78,2,10};
        X=Y.clone();
        search.setX(X);
    }
    private void cargaPersonalizada(){
        System.out.println("Ingrese el tamaño del array");
        int N=scr.nextInt();
        X=new Integer[N];
        for(int i=0;i<X.length;i++){
            System.out.println("Ingrese el valor X["+i+"]=");
            X[i]=scr.nextInt();
        }
        search.setX(X);
    }
    
    private void visualizar(){
        System.out.println("El array contiene los siguientes elementos:");
        System.out.println(search.toString());
    }
    private void callSearchLineal(){        
        System.out.println("Ingrese el valor a buscar:");
        int valor=scr.nextInt();
        int pos=search.searchLineal(valor);
        if(pos==-1)
            System.out.println("El valor buscado "+valor+" no existe");
        else
            System.out.println("El valor buscado "+valor+" se ubico en la posicion "+ pos);                    
    }
    private void callSearchBinaria(){        
        System.out.println("Ingrese el valor a buscar:");
        int valor=scr.nextInt();
        //callBubbleWuSort();
        callSelectionWuSort();
        search.setX(sort.getX());
        int pos=search.searchBinaria(valor);
        if(pos==-1)
            System.out.println("El valor buscado "+valor+" no existe");
        else
            System.out.println("El valor buscado "+valor+" se ubico en la posicion "+ pos);                    
        System.out.println("La busqueda binaria realizo "+search.getnComp()+" comparaciones");
        System.out.println(search.getAnalisis());
        
    }
    
    private void callBubbleWuSort(){  
        Integer[] Y=X.clone();
        sort.setX(Y);//pasando el array origen
        System.out.println("Array inicial: " + sort.toString());
        sort.bubbleWuSort();
        System.out.println("Array final: " + sort.toString());
    }
    
    private void callSelectionWuSort(){        
        Integer[] Y=X.clone();
        sort.setX(Y);//pasando el array origen
        System.out.println("Array inicial: " + sort.toString());
        sort.selectionWuSort();
        System.out.println("Array final: " + sort.toString());
    }
    
    private void callInsercionSort(){
        Integer[] Y=X.clone();
        sort.setX(Y);//pasando el array origen
        System.out.println("Array inicial: " + sort.toString());
        sort.insercionSort();
        System.out.println("Array final: " + sort.toString());
        
    }
    private void callInsercionBinariaSort(){
        Integer[] Y=X.clone();
        sort.setX(Y);//pasando el array origen
        System.out.println("Array inicial: " + sort.toString());
        sort.insercionBinariaSort();
        System.out.println("Array final: " + sort.toString());
        
    }
    private void callHeapSort(){
        Integer[] Y=X.clone();
        sort.setX(Y);//pasando el array origen
        System.out.println("Array inicial: " + sort.toString());
        sort.heapSort();
        System.out.println("Array final: " + sort.toString());
        
    }
    
    
}
