package uni.aed.graphTDA.TopologicalSort;

import java.util.ArrayList;
import java.util.List;
import uni.aed.graphTDA.Edge;
import uni.aed.graphTDA.Graph;
import uni.aed.graphTDA.Vertex;
//Ordenamiento Topologico aplica para grafos dirigidos, considera las aristas salientes en la clasificacion topologica
public class TopologicalSort {

    public TopologicalSort() {
    }
    public static final List<Vertex<Integer>> sort(Graph<Integer> graph){
        if(graph==null)
            throw (new NullPointerException("Grafo no puede ser nulo")); 
        if(graph.getType()!=Graph.TYPE.DIRECTED)
            throw (new IllegalArgumentException("El Grafo debe ser Dirigido"));
        //Realizamos una copia del Grafo que ingresa como parametro
        final Graph<Integer> clone=new Graph<>(graph);
        //Lista de nodos clasificados
        final List<Vertex<Integer>> sorted= new ArrayList<>();
        //Lista de nodos sin arista salientes
        final List<Vertex<Integer>> nOutgoing= new ArrayList<>();
        //Lista de aristas
        final List<Edge<Integer>> edges= new ArrayList<>();
        //descargamos la coleccion de aristas en la lista edges
        edges.addAll(clone.getEdges());
        //ubicar los vertices que no tienen aristas salientes
        for(Vertex<Integer> v: clone.getVertices()){
            //si no tiene aristas lo consignamos en la lista de vertices sin aristas salientes
            if(v.getEdges().isEmpty())
                nOutgoing.add(v);
        }
        //mientras tenemos vertices que no tiene aristas salientes
        while(!nOutgoing.isEmpty()){
            final Vertex<Integer> current=nOutgoing.remove(0);
            sorted.add(current);
            //eliminar las aristas del vertice removido de nOutgoing
            int i=0;
            while(i<edges.size()){
                //recuperamos la arista de la posicion
                final Edge<Integer> e=edges.get(i);
                //determinar el vertice origen de la arista
                final Vertex<Integer> from = e.getFromVertex();
                final Vertex<Integer> to = e.getToVertex();
                //ubicar la arista hacia el vertice actual
                if(to.equals(current)){
                    edges.remove(e);
                    from.getEdges().remove(e);
                }else
                    i++;
                //si el numero de aristas del vertice origen se quedo sin aristas salientes                
                //entonces lo agregamos a la lista nOutgoing
                if(from.getEdges().isEmpty())
                    nOutgoing.add(from);
            }
        }
        if(!edges.isEmpty())//si la lista de aristas no esta vacia, debe haber algun error
            return null;
        return sorted;//retornamos la clasificacion topologica realizada
    }
}
