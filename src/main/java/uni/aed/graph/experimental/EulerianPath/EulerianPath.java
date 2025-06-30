package uni.aed.graph.experimental.EulerianPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EulerianPath {
    private int[][] graph;
    private int numVertices;
    private List<Integer> path;

    public EulerianPath(int[][] graph) {
        this.graph = copyGraph(graph);  //Copia para no modifica el grafo original
        this.numVertices=graph.length;
        this.path=new ArrayList<>();
    }
    private int[][] copyGraph(int[][] original){
        int[][] copy=new int[original.length][original[0].length];
        for(int i=0;i<original.length;i++)
            copy[i]=Arrays.copyOf(original[i],original[i].length);
        return copy;
    }
    //metodo que busca el camino o circuito eureliano
    public List<Integer> findEulerianPath(){
        path.clear();
        int totalEdges=countEdges(graph);
        int oddCount=0;
        int startVertex=0;//inicializamos con el vertice cero
        for(int i=0;i<numVertices;i++){
            int degree=0;
            for(int j=0;j<numVertices;j++)
                degree+=graph[i][j];
            //determinar si el grado es impar
            if(degree%2!=0){
                oddCount++; //incrementamos el #vertices de grado impar
                startVertex=i;  //establecer como vertice inicial el vertice impar determinado
            }   
        }
        //determinando si se detecto algun vertice con grado impar
        //o si se detecto numero de vertices distinto a 2 con grado impar
        if(oddCount!=0 && oddCount!=2)
            return Collections.emptyList(); //No existe camino ni circuito
        //aplicando recorrido primero en profundidad se obtiene el camino o circuito resultante
        dfs(startVertex);
        //si no se recorrieron todas las aristas, entonces retorna lista vacia
        if(path.size()!=totalEdges + 1)
            return Collections.emptyList();
        //invertimos la lista, debido al proceso recursivo, consigno los vertices de la ruta de fin a inicio
        Collections.reverse(path);
        return path;
    }
    //cuenta el numero de aristas del grafo
    private int countEdges(int[][] g){
        int total=0;
        for(int i=0;i<numVertices;i++){
            for(int j=i;j<numVertices;j++)
                total+=g[i][j];
        }
        return total;
    }
    //metodo recorrido primero en profundidad
    private void dfs(int v){
        for(int u=0;u<numVertices;u++){
            while(graph[v][u]>0){
                graph[v][u]--;//decrementamos considerando grado no dirigido
                graph[u][v]--;
                dfs(u);
            }
        }
        //añade a la lista resultante el vertice evaluado
        path.add(v);
    }
    public boolean isEuleriaCircuit(int[][] g){
        for(int i=0;i<numVertices;i++){
            int degree=0;
            for(int j=0;j<numVertices;j++)
                degree+=g[i][j];
            //determinando si el vertice tiene grado impar
            if(degree%2!=0)
                return false;            
        }
        //si se ejecuta esta linea, se considera que todos los vertices tienen grado par
        return true;
    }
    
    
}
