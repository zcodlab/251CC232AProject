package uni.aed.graphTDA.shortestpath;
//Algoritmo para determinar la ruta mas corta

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uni.aed.graphTDA.Edge;
import uni.aed.graphTDA.Graph;
import uni.aed.graphTDA.Vertex;

public class Dijkstra {
    
    public static Map<Vertex<Integer>,CostPathPair<Integer>>
    getShortesPaths(Graph<Integer> graph,Vertex<Integer> start){
        //tabla de vertices y aristas
        Map<Vertex<Integer>,List<Edge<Integer>>> paths=new HashMap<>();
        //tabla de vertices y sus costos
        Map<Vertex<Integer>,CostVertexPair<Integer>> costs=new HashMap<>();
        //invocamos al metodo sobrecargado getShortesPaths con cinco parametros
        getShortesPaths(graph,start,null,paths,costs);
        //tabla de vertices y costos de la ruta mas corta
        Map<Vertex<Integer>,CostPathPair<Integer>> map=new HashMap<>();
        //recorrer el mapa de vertices y sus costos
        for(CostVertexPair<Integer> pair:costs.values()){
            int cost=pair.getCost();
            Vertex<Integer> vertex=pair.getVertex();
            List<Edge<Integer>> path=paths.get(vertex);
            //consignamos en la tabla de vertices y costos de ruta
            map.put(vertex, new CostPathPair<>(cost,path));
        }
        return map;
    }
    public static CostPathPair<Integer>
            getShortesPaths(Graph<Integer> graph,Vertex<Integer> start,
                    Vertex<Integer> end,
                    Map<Vertex<Integer>, List<Edge<Integer>>> paths,
                    Map<Vertex<Integer>, CostVertexPair<Integer>> costs){
            return null;
            }
}
