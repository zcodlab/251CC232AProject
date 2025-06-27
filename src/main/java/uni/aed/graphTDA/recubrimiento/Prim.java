package uni.aed.graphTDA.recubrimiento;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import uni.aed.graphTDA.Edge;
import uni.aed.graphTDA.Graph;
import uni.aed.graphTDA.Vertex;
import uni.aed.graphTDA.shortestpath.CostPathPair;

public class Prim {

    public Prim() {
    }
    public static CostPathPair<Integer> 
        getMinimumSpanningTree(Graph<Integer> graph, Vertex<Integer> start){
        if(graph==null)
            throw (new NullPointerException("Grafo no puede ser nulo")); 
        //Algoritmo de Prim solo funciona con grafos no dirigidos
        if(graph.getType()==Graph.TYPE.DIRECTED)
            throw (new IllegalArgumentException("El Grafo debe ser No dirigido"));
        int cost=0;
        final Set<Vertex<Integer>> unvisited=new HashSet<>();
        unvisited.addAll(graph.getVertices());
        unvisited.remove(start);
        //lista de aristas que conformaran la ruta
        final List<Edge<Integer>> path=new ArrayList<>();
        //lista de aristas disponibles priorizadas por costo o peso
        final Queue<Edge<Integer>> edgesAvailable=new PriorityQueue<>();
        Vertex<Integer> vertex=start;
        while(!unvisited.isEmpty()){
            //Agregar todas las aristas de los vertices no vistados
            for(Edge<Integer> e:vertex.getEdges()){
                //si el vertice adyacente esta como no visitado,la arista se descarga en la lista de aristas disponibles
                if(unvisited.contains(e.getToVertex()))
                    edgesAvailable.add(e);
            }
            //Remover la arista con costo mas bajo (se obtiene de la cola prioritaria)
            final Edge<Integer> e=edgesAvailable.remove();
            cost+=e.getCost();
            path.add(e);//consignamos la arista con costo minimo en la ruta resultante
            
            vertex=e.getToVertex();
            unvisited.remove(vertex);
        }
        return (new CostPathPair<Integer>(cost,path));
    }
}
