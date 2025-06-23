package uni.aed.graphTDA.recubrimiento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import uni.aed.graphTDA.Edge;
import uni.aed.graphTDA.Graph;
import uni.aed.graphTDA.Vertex;
import uni.aed.graphTDA.shortestpath.CostPathPair;

public class Kruskal {

    public Kruskal() {
    }
    public static CostPathPair<Integer> 
        getMinimumSpanningTree(Graph<Integer> graph){
        if(graph==null)
            throw (new NullPointerException("Grafo no puede ser nulo"));    
        //Kruskal funcion con grafos no dirigidos
        if(graph.getType()==Graph.TYPE.DIRECTED)
            throw (new IllegalArgumentException("El Grafo debe ser No dirigido"));
        int cost=0;
        final List<Edge<Integer>> path=new ArrayList<>();
        //preparar la data para almacenar informacion que es parte del arbol                
        //HashSet: permite almacenar no duplicados, no mantiene orden
        HashMap<Vertex<Integer>,HashSet<Vertex<Integer>>>
                membershipMap=new HashMap<>();
        for(Vertex<Integer> v:graph.getVertices()){
            HashSet<Vertex<Integer>> set=new HashSet<>();
            set.add(v);
            membershipMap.put(v, set);
        }
        //declara cola prioritaria y descargamos en ella todas las aristas del grafo
        final Queue<Edge<Integer>> edgeQueue=new PriorityQueue<>(graph.getEdges());
        while(!edgeQueue.isEmpty()){
            Edge<Integer> edge=edgeQueue.poll();//poll es equivalente a remove, a dequeue
            if(!isTheSamePart(edge.getFromVertex(),edge.getToVertex(),membershipMap)){
                union(edge.getFromVertex(),edge.getToVertex(),membershipMap);
                path.add(edge);
                cost+=edge.getCost();
            }
        }
        return (new CostPathPair<>(cost,path));
    }
    private static boolean isTheSamePart(Vertex<Integer> v1,
            Vertex<Integer> v2,HashMap<Vertex<Integer>,HashSet<Vertex<Integer>>>
                membershipMap ){
        return membershipMap.get(v1)==membershipMap.get(v2);
    }
    private static void union(Vertex<Integer> v1,
        Vertex<Integer> v2,HashMap<Vertex<Integer>,HashSet<Vertex<Integer>>>
            membershipMap ){
        HashSet<Vertex<Integer>> firstSet=membershipMap.get(v1);
        HashSet<Vertex<Integer>> secondSet=membershipMap.get(v2);        
        if(secondSet.size()>firstSet.size()){
            HashSet<Vertex<Integer>> tempSet=firstSet;
            firstSet=secondSet;
            secondSet=tempSet;
        }
        for(Vertex<Integer> v:secondSet)
            membershipMap.put(v, firstSet);
        //añadiendo todos los vertices desde el mas pequeño al mas grande
        firstSet.addAll(secondSet);
    }
}
