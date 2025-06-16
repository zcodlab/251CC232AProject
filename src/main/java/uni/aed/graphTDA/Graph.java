package uni.aed.graphTDA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/*Grafo puede ser dirigido, no dirigido
*Un grafo es una representacion abstracta de un conjunto 
*de objetos donde algunos pares estan conectados por aristas
*/
public class Graph<T extends Comparable<T>> {
    public enum TYPE{
        DIRECTED,UNDIRECTED
    }
    private List<Vertex<T>> allVertices=new ArrayList<>();
    private List<Edge<T>> allEdges=new ArrayList<>();    
    private TYPE type=TYPE.UNDIRECTED;//predeterminando el tipo de grafo como no dirigido
    //1° constructor
    public Graph() {
    }
    //2° constructor
    public Graph(TYPE type) {
        this.type=type;
    }
    //3° constructor
    public Graph(Graph<T> g) {
        //descargando el tipo del parametro en el objeto actual
        this.type=g.type;
        //descargando vertices en el grafo actual
        for(Vertex<T> v:g.getVertices())
            this.allVertices.add(new Vertex<T>(v));
        //descargamos aristas en el grafo actual
        for(Vertex<T> v:g.getVertices()){
            for(Edge<T> e:v.getEdges())
                this.allEdges.add(e);
        }
    }
    //4° constructor
    public Graph(Collection<Vertex<T>> vertices,Collection<Edge<T>> edges){
        this(TYPE.UNDIRECTED,vertices,edges);
    }
    //5° constructor
    public Graph(TYPE type,Collection<Vertex<T>> vertices,Collection<Edge<T>> edges){
        this(type);
        this.allVertices.addAll(vertices);
        this.allEdges.addAll(edges);
        //recorremos la coleccion de aristas
        for(Edge<T> e:edges){
            final Vertex<T> from=e.getFromVertex();
            final Vertex<T> to=e.getToVertex();
            if(!this.allVertices.contains(from) ||
                !this.allVertices.contains(to))
                continue;
            from.addEdge(e);
            if(this.type==TYPE.UNDIRECTED){
                Edge<T> reciproca=new Edge<T>(e.getCost(),to,from);//arista inversa, por ser bidireccional
                to.addEdge(reciproca);
                this.allEdges.add(reciproca);
            }
        }
            
    }

    public List<Vertex<T>> getVertices() {
        return allVertices;
    }

    public List<Edge<T>> getEdges() {
        return allEdges;
    }

    public TYPE getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Graph<?> other = (Graph<?>) obj;
        if (!Objects.equals(this.allVertices, other.allVertices)) {
            return false;
        }
        if (!Objects.equals(this.allEdges, other.allEdges)) {
            return false;
        }
        return this.type == other.type;
    }
    

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for(Vertex<T> v:allVertices)
            builder.append(v.toString());                    
        return builder.toString();
        
    }
    
    
    
    
}
