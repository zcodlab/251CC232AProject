package uni.aed.graph.experimental.HamiltonianPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HamiltonianPath {
    private int[][] graph;
    private int numVertices;
    private List<Integer> path;
    private boolean circuitFound;

    public HamiltonianPath(int[][] graph) {
        this.graph = graph;
        this.numVertices=graph.length;
    }
    
    public boolean hasHamiltonianPathOrCircuit(){
        //verificamos si existe circuito
        for(int start=0;start<numVertices;start++){
            List<Integer> path=new ArrayList<>();
            boolean[] visited=new boolean[numVertices];
            path.add(start);
            visited[start]=true;
            circuitFound=false;
            if(backtrack(start,path,visited,start,true)){
                this.path=path;
                return true;
            }
        }
        return false;
    }
    private boolean backtrack(int current, List<Integer> path,
            boolean[] visited, int start, boolean requireCircuit){
        if(path.size()==numVertices){
            if(requireCircuit && graph[current][start]==1){
                path.add(start);
                circuitFound=true;
                return true;
            }else if(!requireCircuit)
                return true;
            return false;
        }
        for(int next=0;next<numVertices;next++){
            if(graph[current][next]==1 && !visited[next]){
                visited[next]=true;
                path.add(next);
                if (backtrack(next,path,visited,start,requireCircuit))
                    return true;
                visited[next]=false;
                path.remove(path.size() - 1);                        
            }
        }
        return false;
    }
    
    public boolean isHamiltonianCircuit(){
        return circuitFound;
    }
    
    public List<Integer> getHamiltonianPath(){
        return this.path!=null ? this.path : Collections.emptyList();
    }
            
    
}
