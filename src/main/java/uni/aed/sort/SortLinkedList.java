package uni.aed.sort;

import uni.aed.doublelinkedlist.DNodo;
import uni.aed.doublelinkedlist.DoubleLinkedList;

public class SortLinkedList {
    public static void heapsort(DoubleLinkedList lista){
        int n=lista.size();
        //construir el heap
        for(int i=n/2 - 1;i>=0;i--)
            heapify(lista,n,i);
        //extraer los elementos del heap
        for(int i=n-1;i>0;i--){
            intercambio(lista,0,i);
            heapify(lista,i,0);
        }        
    }
    private static void heapify(DoubleLinkedList lista,int n,int i){
        DNodo raiz=lista.getNodo(i);
        int mayor=i;
        int izq=2*i+1;
        int der=2*i+2;
        if(izq<n && lista.getNodo(izq).getData()>raiz.getData())
            mayor=izq;
        if(der<n 
            && lista.getNodo(der).getData()>lista.getNodo(mayor).getData())
            mayor=der;
        if(mayor!=i){
            intercambio(lista,i,mayor);
            heapify(lista,n,mayor);
        }
    }
    
    public static void intercambio(DoubleLinkedList lista,int i,int j){
        DNodo nodoI=lista.getNodo(i);
        DNodo nodoJ=lista.getNodo(j);
        int temp=nodoI.getData();
        nodoI.setData(nodoJ.getData());
        nodoJ.setData(temp);
    }
    
}
