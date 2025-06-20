package uni.aed.graphTDA.shortestpath;

import java.util.Iterator;
import java.util.List;
import uni.aed.graphTDA.Edge;

public class CostPathPair<T extends Comparable<T>> {
    private int cost=0;
    private List<Edge<T>> path=null;
    //constructor
    public CostPathPair(int cost,List<Edge<T>> path) {
        if(path==null)
            throw (new NullPointerException("El path no puede ser Null"));
        this.cost=cost;
        this.path=path;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public List<Edge<T>> getPath() {
        return path;
    }   
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CostPathPair))
            return false;
        final CostPathPair<?> pair=(CostPathPair<?>)obj;
        if(this.cost!=pair.cost)
            return false;
        final Iterator<?> iter1=this.getPath().iterator();
        final Iterator<?> iter2=pair.getPath().iterator();
        while(iter1.hasNext() && iter2.hasNext()){
            Edge<T> e1=(Edge<T>)iter1.next();
            Edge<T> e2=(Edge<T>)iter2.next();
            if(!e1.equals(e2))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder=new StringBuilder();
        builder.append("Costo= ").append(cost).append("\n");
        for(Edge<T> e:path)
            builder.append("\t").append(e);
        return builder.toString();
    }
    
    
    
    
}
