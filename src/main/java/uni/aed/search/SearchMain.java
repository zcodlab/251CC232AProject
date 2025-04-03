package uni.aed.search;

import java.util.Scanner;
import uni.aed.sort.Sort;

public class SearchMain {
    private static Search search;
    
    public static void main(String[] args){
        SearchMain searchMain=new SearchMain();
        search=new Search();
        searchMain.carga();
        searchMain.visualizar();
        //searchMain.callSearchLineal();
        searchMain.callSearchBinaria();
    }
    private void carga(){
        Integer[] X={15,1,25,60,69,86,3,78,2,10};
        search.setX(X);
    }
    private void visualizar(){
        System.out.println("El array contiene los siguientes elementos:");
        System.out.println(search.toString());
    }
    private void callSearchLineal(){
        Scanner scr=new Scanner(System.in);
        System.out.println("Ingrese el valor a buscar:");
        int valor=scr.nextInt();
        int pos=search.searchLineal(valor);
        if(pos==-1)
            System.out.println("El valor buscado "+valor+" no existe");
        else
            System.out.println("El valor buscado "+valor+" se ubico en la posicion "+ pos);                    
    }
    private void callSearchBinaria(){
        Scanner scr=new Scanner(System.in);
        System.out.println("Ingrese el valor a buscar:");
        int valor=scr.nextInt();
        //callBubbleWuSort();
        callSelectionWuSort();
        int pos=search.searchBinaria(valor);
        if(pos==-1)
            System.out.println("El valor buscado "+valor+" no existe");
        else
            System.out.println("El valor buscado "+valor+" se ubico en la posicion "+ pos);                    
        
    }
    
    private void callBubbleWuSort(){
        Sort sort=new Sort();
        sort.setX(search.getX());
        System.out.println("Array inicial: " + sort.toString());
        sort.bubbleWuSort();
        System.out.println("Array final: " + sort.toString());
    }
    
    private void callSelectionWuSort(){
        Sort sort=new Sort();
        sort.setX(search.getX());
        System.out.println("Array inicial: " + sort.toString());
        sort.selectionWuSort();
        System.out.println("Array final: " + sort.toString());
    }
    
}
