package uni.aed.sort.matriz;

import uni.aed.sort.Sort; // Se asume que hay una clase externa para ordenar (QuickSort)
import java.util.Random;

public class Serie {    
    private int  rango_ini = 100;    
    private Integer[] datos;  // Arreglo que guarda los 100 números aleatorios
    private Sort sort;        // Instancia del algoritmo de ordenamiento

    public Serie(int n,int rango) {
        datos = new Integer[n];  // Se inicializa con 100 posiciones
        rango_ini=rango;
        sort = new Sort();         // Se crea el objeto para usar QuickSort
    }

    // Método para generar números aleatorios entre 100 y 200
    public void generar() {
        Random r = new Random();
        for (int i = 0; i < datos.length; i++) {
            datos[i] = r.nextInt(rango_ini + 1) + rango_ini; // Números en el rango [100, 200]
        }
    }

    // Ordeno la serie usando QuickSort
    public void ordenar() {
        sort.setX(datos); // Configuro los datos en el objeto Sort
        sort.QuickSort(datos, 0, datos.length - 1); // Aplico QuickSort
    }

    // Devuelve los datos generados/ordenados
    public Integer[] getDatos() {
        return datos;
    }
    
    @Override
    public String toString() {        
        StringBuilder str=new StringBuilder();
        for (int i = 0; i < datos.length; i++) {
            str.append(datos[i] + " ");            
            if ((i + 1) % 10 == 0) str.append("\n"); // Salto de línea cada 10 números
        }        
        return str.toString();        
    }
}
