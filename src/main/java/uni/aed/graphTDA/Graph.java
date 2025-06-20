package uni.aed.graphTDA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
    public boolean equals(Object g1) {
        //verificar si g1 es un Grafo
        if(!(g1 instanceof Graph))
            return false;
        //asignar el parametro previo cast a una variable local
        final Graph<T> g=(Graph<T>)g1;
        //verificamos si los dos grafo son del mismo tipo
        final boolean typeEquals=this.type==g.type;
        if(!typeEquals)
            return false;
        //verificar si los dos grafos tienen el mismo numero de vertices
        final boolean verticesSizeEquals=this.allVertices.size()==g.allVertices.size();
        if(!verticesSizeEquals)
            return false;
        //verificar si los dos grafos tienen el mismo numero de aristas
        final boolean edgesSizeEquals=this.allEdges.size()==g.allEdges.size();
        if(!edgesSizeEquals)
            return false;
        //verificar si los dos grafos tienen los mismo vertices
        //grafo actual
        final Object[] ov1=this.allVertices.toArray();
        Arrays.sort(ov1);
        //2 grafo
        final Object[] ov2=g.allVertices.toArray();
        Arrays.sort(ov2);
        //iteramos por todos los vertices del grafo actual
        for(int i=0;i<ov1.length;i++){
            final Vertex<T> v1= (Vertex<T>)ov1[i];
            final Vertex<T> v2= (Vertex<T>)ov2[i];
            //comparamos
            if(!v1.equals(v2))
                return false;
        }
        //comparamos aristas
        final Object[] oe1=this.allEdges.toArray();
        Arrays.sort(oe1);
        //2 grafo
        final Object[] oe2=g.allEdges.toArray();
        Arrays.sort(oe2);
        for(int i=0;i<ov1.length;i++){
            final Edge<T> e1=(Edge<T>)oe1[i];
            final Edge<T> e2=(Edge<T>)oe2[i];
            //comparamos
            if(!e1.equals(e2))
                return false;
        }        
        return true;
    }
    

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for(Vertex<T> v:allVertices)
            builder.append(v.toString());                    
        return builder.toString();
        
    }
    
    
    
    
}
