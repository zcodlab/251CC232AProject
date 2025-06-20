package uni.aed.graphTDA;

import java.util.InputMismatchException;
import java.util.Scanner;
import uni.aed.graphTDA.DataGraph.DirectedGraph;
import uni.aed.graphTDA.DataGraph.UndirectedGraph;

public class GraphMain {
    private static Scanner scr;
    private static int opcion=1;
    private static String SEPARADOR="\n";
    private static String Rpta="S";
    public static void main(String[] args) {
         GraphMain g=new GraphMain();
         scr=new Scanner(System.in).useDelimiter(SEPARADOR);
         g.menu();
    }
    private void menu(){        
        try{
            do			
            {	
                System.out.print("Grafos"+SEPARADOR+
                "1.- Grafo No Dirigido "+SEPARADOR+                
                "2.- Grafo Dirigido "+SEPARADOR+                
                "3.- Salir "+SEPARADOR+"Elija una opcion:");                
                opcion =scr.nextInt();            
                switch (opcion)
                {
                    case 1 -> {getUndirectedGraph();}                    
                    case 2 -> {getDirectedGraph();}                    
                    default -> {break;}
                }	            
                System.out.print("Para continuar con las operaciones pulsa S; Para finalizar pulse N: ");
                Rpta=scr.next().toUpperCase();			
            }while(Rpta.equals("S")==true);	
        }catch(InputMismatchException ex) {
            System.out.println("Debe ingresar obligatoriamente un número entero como opcion elegida.");
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }finally{            
            scr.close();
        }
    }
    
    private void getUndirectedGraph(){
        System.out.println("Grafo No Dirigido");
        DataGraph.UndirectedGraph undirectedGraph=new UndirectedGraph();
        System.out.println(undirectedGraph.graph.toString());
    }
    private void getDirectedGraph(){
        System.out.println("Grafo Dirigido");
        DataGraph.DirectedGraph directedGraph=new DirectedGraph();
        System.out.println(directedGraph.graph.toString());
    }
}
