package uni.aed.graphTDA;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import uni.aed.graphTDA.DataGraph.DirectedGraph;
import uni.aed.graphTDA.DataGraph.UndirectedGraph;
import uni.aed.graphTDA.TopologicalSort.TopologicalSort;
import uni.aed.graphTDA.recubrimiento.Kruskal;
import uni.aed.graphTDA.recubrimiento.Prim;
import uni.aed.graphTDA.shortestpath.CostPathPair;
import uni.aed.graphTDA.shortestpath.Dijkstra;

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
                "3.- Dijkstra No Dirigido "+SEPARADOR+                
                "4.- Kruskal "+SEPARADOR+                
                "5.- Prim "+SEPARADOR+                
                "6.- Ordenamiento Topologico "+SEPARADOR+                
                "7.- Salir "+SEPARADOR+"Elija una opcion:");                
                opcion =scr.nextInt();            
                switch (opcion)
                {
                    case 1 -> {getUndirectedGraph();}                    
                    case 2 -> {getDirectedGraph();}                    
                    case 3 -> {getDijkstraUndirected();}                    
                    case 4 -> {getKruskal();}                    
                    case 5 -> {getPrim();}                    
                    case 6 -> {getTopologicalSort();}                    
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
    private void getDijkstraUndirected(){
        DataGraph.UndirectedGraph undirectedGraph=new UndirectedGraph();
        Vertex<Integer> start=undirectedGraph.v1;
        Vertex<Integer> end=undirectedGraph.v5;
        Map<Vertex<Integer>,CostPathPair<Integer>> map
                =Dijkstra.getShortesPaths(undirectedGraph.graph, start);
        
        CostPathPair<Integer> path,pair;
        System.out.println("Dijkstra: Ruta mas corta, start: "+start.getValue());
        for(Vertex<Integer> v: map.keySet()){
            System.out.println("v="+v.getValue());
            path=map.get(v);
            System.out.println("Dijkstra: Ruta mas corta, path: "+path);
        }
    }
    
    private void getKruskal(){
        DataGraph.UndirectedGraph undirectedGraph=new UndirectedGraph();
        CostPathPair<Integer> result=Kruskal.getMinimumSpanningTree(undirectedGraph.graph);
        System.out.println("Arbol de Expansion Minima: Kruskal: "+result);
    }
    private void getPrim(){
        DataGraph.UndirectedGraph undirectedGraph=new UndirectedGraph();
        Vertex<Integer> start=undirectedGraph.v1;
        CostPathPair<Integer> result=Prim.getMinimumSpanningTree(undirectedGraph.graph,start);
        System.out.println("Arbol de Expansion Minima: Prim: "+result);
    }
    
    private void getTopologicalSort(){
        DataGraph.DirectedGraph directedGraph=new DirectedGraph();
        List<Vertex<Integer>> result=TopologicalSort.sort(directedGraph.graph);
        System.out.println("Resultado del Ordenamiento Topologico:\n"+result.toString());
    }
}
