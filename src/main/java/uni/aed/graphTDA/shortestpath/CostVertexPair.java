package uni.aed.graphTDA.shortestpath;

import java.util.Objects;
import uni.aed.graphTDA.Vertex;

public class CostVertexPair<T extends Comparable<T>> implements Comparable<CostVertexPair<T>>{
    private int cost=Integer.MAX_VALUE;
    private Vertex<T> vertex=null;
    //constructor
    public CostVertexPair(int cost, Vertex<T> vertex) {
        if(vertex==null)
            throw (new NullPointerException("El vertice no puede ser Null"));
        this.cost=cost;
        this.vertex=vertex;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }
   
    @Override
    public boolean equals(Object e1) {
        if(!(e1 instanceof CostVertexPair))
            return false;
        final CostVertexPair<?> pair=(CostVertexPair<?>)e1;
        if(this.cost!=pair.cost)
            return false;
        if(!this.vertex.equals(pair.vertex))
            return false;
        return true;
    }

    @Override
    public int compareTo(CostVertexPair<T> p) {
        if(p==null)
            throw (new NullPointerException("CostVertexPair no puede ser Null"));
        if(this.cost<p.cost)
            return -1;
        if(this.cost>p.cost)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder builder=new StringBuilder();
        builder.append(vertex.getValue()).append(" (")
                .append(vertex.getWeight()).append(") ")
                .append(" cost=")
                .append(cost).append("\n");
        return builder.toString();
    }
    
    
}
