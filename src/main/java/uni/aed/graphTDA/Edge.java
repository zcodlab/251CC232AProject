package uni.aed.graphTDA;
//Clase Arista

import java.util.Objects;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>>{
    private Vertex<T> from=null;//vertice origen(from=Desde) que une la arista con un vertice destino
    private Vertex<T> to=null;//vertice destino(to=hacia)
    private int cost=0;
    //1° constructor
    public Edge(int cost,Vertex<T> from, Vertex<T> to) {
        if(from==null || to==null)
            throw new NullPointerException("Vertices origen y destino son nulos");
        this.cost=cost;
        this.from=from;
        this.to=to;
    }
    //2° constructor
    public Edge(Edge<T> e){
        //invoca al 1° constructor
        this(e.cost,e.from,e.to);
    }

    public Vertex<T> getFromVertex() {
        return from;
    }

    public Vertex<T> getToVertex() {
        return to;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }    

    @Override
    public boolean equals(Object e1) {
        //si el objeto a evaluar no es instancia de la clase Edge 
        if(!(e1 instanceof Edge))
            return false;
        final Edge<T> e=(Edge<T>)e1;
        //compara costos
        final boolean costs=this.cost==e.cost;
        //si los costos difieren
        if(!costs)
            return false;
        //compara los vertices origen
        final boolean from=this.from==e.from;
        if(!from)
            return false;
        //compara los vertices destino
        final boolean to=this.to==e.to;
        if(!to)
            return false;
        return true;
    }
    //comporar dos aristas
    @Override
    public int compareTo(Edge<T> e) {
        if(this.cost<e.cost)
            return -1;
        if(this.cost>e.cost)
            return 1;
        //comparando los vertices origen
        final int from=this.from.compareTo(e.from);
        if(from!=0)
            return from;
        //comparando los vertices destino
        final int to=this.to.compareTo(e.to);
        if(to!=0)
            return to;
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append("[")
                .append(from.getValue())
                .append("(")
                .append(from.getWeight())
                .append(")")
                .append("]")
                .append("->")
                .append("[")
                .append(to.getValue())
                .append("(")
                .append(to.getWeight())
                .append(")")
                .append("]")
                .append("=")
                .append(cost)
                .append("\n");
        return builder.toString();
    }
}
