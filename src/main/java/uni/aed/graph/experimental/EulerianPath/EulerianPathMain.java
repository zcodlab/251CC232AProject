package uni.aed.graph.experimental.EulerianPath;

import java.util.List;

public class EulerianPathMain {
    public static void main(String[] args){
        //Caso1: Tiene camino euleriano, pero no circuito
        int[][] graph1={
            {0,1,0,1,0},
            {1,0,1,1,1},
            {0,1,0,0,1},
            {1,1,0,0,1},    //impar
            {0,1,1,1,0}     //impar
        };
        //Caso2: Tiene circuito euleriano(todos los vertices tiene grado par)
        int[][] graph2={
            {0,1,1,0,0},
            {1,0,1,0,0},
            {1,1,0,1,1},
            {0,0,1,0,1},    
            {0,0,1,1,0}     
        };        
        //Caso3: No tiene ni camino, ni circuito(mas de 2 vertices con grado impar)
        int[][] graph3={
            {0,1,0,0,0},//impar
            {1,0,1,1,0},//impar
            {0,1,0,0,1},//par
            {0,1,0,0,0},//impar
            {0,0,1,0,0} //impar
        };
        
        System.out.println("Analizando el grafo1:");
        testGraph(graph1);
        System.out.println("Analizando el grafo2:");
        testGraph(graph2);
        System.out.println("Analizando el grafo3:");
        testGraph(graph3);
    }
    private static void testGraph(int[][] graph){
        EulerianPath euler=new EulerianPath(graph);
        boolean isCircuit=euler.isEuleriaCircuit(graph);
        List<Integer> result=euler.findEulerianPath();
        if(result.isEmpty())
            System.out.println("No existe ni camino, ni circuito");
        else{
            if(isCircuit)
                System.out.println("Circuito Euleriano encontrado:");
            else
                System.out.println("Camino Euleriano encontrado:");
            System.out.println("Recorrido: " + result);
        }
    }
}
