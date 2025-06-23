package uni.aed.graphTDA.shortestpath;
//Algoritmo para determinar la ruta mas corta
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import uni.aed.graphTDA.Edge;
import uni.aed.graphTDA.Graph;
import uni.aed.graphTDA.Vertex;
public class Dijkstra {   
    //metodo determinar la ruta mas corta
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
            
                if(graph==null)
                    throw (new NullPointerException("Grafo no puede ser nulo"));
                if(start==null)
                    throw (new NullPointerException("Vertice inicial no puede ser nulo"));
                //Considerando que Dijkstra solo considera pesos positivos
                boolean hasNegativeEdge=checkForNegativeEdge(graph.getVertices());
                if(hasNegativeEdge)
                    throw (new IllegalArgumentException("Aristas con pesos negativos no estan permitidos"));
                //inicializando la Tabla paths
                for(Vertex<Integer> v:graph.getVertices())
                    paths.put(v,new ArrayList<>());
                //recorrer el grafo y por cada vertice comparamos con el vertice inicial
                for(Vertex<Integer> v:graph.getVertices()){
                    if(v.equals(start))//seteamos pero cero al vertice inicial
                        costs.put(v, new CostVertexPair<>(0,v));
                    else//sino es el vertice inicial
                        costs.put(v, new CostVertexPair<>(Integer.MAX_VALUE,v));
                }
                //declara cola prioritaria
                final Queue<CostVertexPair<Integer>> unvisited=new PriorityQueue<>();
                //añadir a la cola la tabla de costos del vertice inicial
                unvisited.add(costs.get(start));
                //recorrer la cola
                while(!unvisited.isEmpty()){
                    //desencolar el elemento de la cola
                    final CostVertexPair<Integer> pair=unvisited.remove();
                    //obtiene el vertice del elemento desencolado
                    final Vertex<Integer> vertex=pair.getVertex();
                    //recorriendo las arista adyacentes
                    for(Edge<Integer> e:vertex.getEdges()){                        
                        //recuperar el costo del vertice adyacente
                        final CostVertexPair<Integer> toPair=costs.get(e.getToVertex());
                        final CostVertexPair<Integer> lowestCostToThisVertex=costs.get(vertex);
                        final int cost=lowestCostToThisVertex.getCost()+e.getCost();
                        //verificar si el costo del objeto adyancente es infinito
                        if(toPair.getCost()==Integer.MAX_VALUE){
                            //desencolar temporalmente el objeto toPair, actualizar su costo y volverlo a encolar
                            unvisited.remove(toPair);
                            toPair.setCost(cost);
                            unvisited.add(toPair);
                            //recupera la lista de aristas del vertice adyancente
                            List<Edge<Integer>> set=paths.get(e.getToVertex());
                            set.addAll(paths.get(e.getFromVertex()));
                            set.add(e);
                        }else if(cost<toPair.getCost()){
                            //encontro una ruta mas corta, entonces desencolar temporalmente 
                            //el objeto toPair, actualizar su costo y volverlo a encolar
                            unvisited.remove(toPair);
                            toPair.setCost(cost);
                            unvisited.add(toPair);
                            //actualizar la ruta
                            List<Edge<Integer>> set=paths.get(e.getToVertex());
                            set.clear();
                            set.addAll(paths.get(e.getFromVertex()));
                            set.add(e);
                        }
                    }
                    //condiciones de terminacion del ciclo
                    if(end!=null && vertex.equals(end))
                        break;
                }
                if(end!=null){
                    final CostVertexPair<Integer> pair=costs.get(end);
                    final List<Edge<Integer>> set=paths.get(end);
                    return (new CostPathPair<>(pair.getCost(),set));
                }
                return null;
    }
    private static boolean checkForNegativeEdge(Collection<Vertex<Integer>> vertices){
        for(Vertex<Integer> v: vertices){
            for(Edge<Integer> e: v.getEdges()){
                if(e.getCost()<0)
                    return true;
            }                
        }
        return false;
    }
}
