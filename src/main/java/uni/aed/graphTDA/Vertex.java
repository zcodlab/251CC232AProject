package uni.aed.graphTDA;
//Clase Vertice

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>>{
    private T value=null;
    private int weight=0;   //peso o costo del vertice
    private List<Edge<T>> edges=new ArrayList<>();//lista de aristas del vertice

    public Vertex(T value) {
        this.value=value;
    }
    
    public Vertex(T value, int weight) {
        this.value=value;
        this.weight=weight;
    }
    
    public Vertex(Vertex<T> vertex) {
        //invoca al 1° constructor
        this(vertex.value,vertex.weight);
        //consigna todas aristas en la variable de tipo List edges
        this.edges.addAll(vertex.edges);
    }

    public T getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    //metodo para añadir una arista a un vertice
    public void addEdge(Edge<T> e){
        edges.add(e);
    }
    
    //retorna una arista que tiene como destino el 
    //vertice pasado como parametro
    public Edge<T> getEdge(Vertex<T> v){
      //recorremos la lista de aristas del vertice actual, 
      //buscando la arista que tiene como vertice destino, el vertice v
      for(Edge<T> e:edges){          
          if(e.getToVertex().equals(v));
               return e;
      }
      return null;
    }
    //Retorna true/false si existe un camino hacia el vertice v
    public boolean pathTo(Vertex<T> v){
        for(Edge<T> e:edges){          
          if(e.getToVertex().equals(v));
            return true;
        }
        return false;
    }    

    @Override
    public boolean equals(Object v1) {
        //si el objeto a evaluar no es instancia de la clase Vertex 
        if(!(v1 instanceof Vertex))
            return false;
        final Vertex<T> v=(Vertex<T>)v1;//se aplica cast a v1 para asignarlo a v
        //compara los pesos de los dos vertices
        final boolean weightEquals=this.weight==v.getWeight();
        if(!weightEquals)
            return false;
        //compara el numero de aristas de los dos vertices
        final boolean edgesSizeEquals=this.edges.size()==v.edges.size();
        if(!edgesSizeEquals)
            return false;
        //comparar el valor de los vertices
        final boolean valueEquals=this.value.equals(v.value);
        if(!valueEquals)
            return false;
        //compara el costo de cada par de aristas de los dos vertices
        final Iterator<Edge<T>> iter1=this.edges.iterator();
        final Iterator<Edge<T>> iter2=v.edges.iterator();
        while(iter1.hasNext() && iter2.hasNext()){
            final Edge<T> e1=iter1.next();//obtenemos arista del vertice actual
            final Edge<T> e2=iter2.next();//obtenemos arista del vertice v
            if(e1.getCost()!=e2.getCost())
                return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(Vertex<T> v) {
        //comprar los valores de los dos vertices
        final int valueComp=this.value.compareTo(v.value);
        if(valueComp!=0)
            return valueComp;
        //compara los pesos de los dos vertices
        if(this.weight<v.weight)
            return -1;
        if(this.weight>v.weight)
            return 1;
        //compara el numero de aristas de los dos vertices
        if(this.edges.size()<v.edges.size())
            return -1;
        if(this.edges.size()>v.edges.size())
            return 1;
        //comparar los costos o pesos de cada par de aristas de los dos vertices
        final Iterator<Edge<T>> iter1=this.edges.iterator();
        final Iterator<Edge<T>> iter2=v.edges.iterator();
        while(iter1.hasNext() && iter2.hasNext()){
            final Edge<T> e1=iter1.next();//obtenemos arista del vertice actual
            final Edge<T> e2=iter2.next();//obtenemos arista del vertice v
            if(e1.getCost()<e2.getCost())
                return -1;
            if(e1.getCost()>e2.getCost())
                return 1;            
        }
        return 0;
    }
    
    @Override
    public String toString() {
        StringBuilder builder =new StringBuilder();
        builder.append("Value=")
                .append(value)
                .append(" weight=")
                .append(weight)
                .append("\n");
        for(Edge<T> e:edges)
            builder.append("\t").append(e.toString());
        return builder.toString();
    }
    
}
