package uni.aed.graphTDA;
//con fines de prueba  

import java.util.ArrayList;
import java.util.List;

public class DataGraph {
    //grafo no dirigido
    protected static class UndirectedGraph{
        private final List<Vertex<Integer>> vertices=new ArrayList<>();
        protected final Vertex<Integer> v1=new Vertex<>(1);
        private final Vertex<Integer> v2=new Vertex<>(2);
        private final Vertex<Integer> v3=new Vertex<>(3);
        private final Vertex<Integer> v4=new Vertex<>(4);
        protected final Vertex<Integer> v5=new Vertex<>(5);
        private final Vertex<Integer> v6=new Vertex<>(6);
        private final Vertex<Integer> v7=new Vertex<>(7);
        private final Vertex<Integer> v8=new Vertex<>(8);
        {
            vertices.add(v1);
            vertices.add(v2);
            vertices.add(v3);
            vertices.add(v4);
            vertices.add(v5);
            vertices.add(v6);
            vertices.add(v7);
            vertices.add(v8);
        }
        private final List<Edge<Integer>> edges=new ArrayList<>();
        private final Edge<Integer> e1_2=new Edge<>(7,v1,v2);
        private final Edge<Integer> e1_3=new Edge<>(9,v1,v3);
        private final Edge<Integer> e1_6=new Edge<>(14,v1,v6);
        private final Edge<Integer> e2_3=new Edge<>(10,v2,v3);
        private final Edge<Integer> e2_4=new Edge<>(15,v2,v4);
        private final Edge<Integer> e3_4=new Edge<>(11,v3,v4);
        private final Edge<Integer> e3_6=new Edge<>(2,v3,v6);
        private final Edge<Integer> e5_6=new Edge<>(9,v5,v6);
        private final Edge<Integer> e4_5=new Edge<>(6,v4,v5);
        private final Edge<Integer> e1_7=new Edge<>(1,v1,v7);
        private final Edge<Integer> e1_8=new Edge<>(1,v1,v8);
        {
            edges.add(e1_2);
            edges.add(e1_3);
            edges.add(e1_6);
            edges.add(e2_3);
            edges.add(e2_4);
            edges.add(e3_4);
            edges.add(e3_6);
            edges.add(e5_6);
            edges.add(e4_5);
            edges.add(e1_7);
            edges.add(e1_8);                        
        }
        protected final Graph<Integer> graph=new Graph<>(vertices,edges);
    }
    protected static class DirectedGraph{
        private final List<Vertex<Integer>> vertices=new ArrayList<>();
        private final Vertex<Integer> v1=new Vertex<>(1);
        private final Vertex<Integer> v2=new Vertex<>(2);
        private final Vertex<Integer> v3=new Vertex<>(3);
        private final Vertex<Integer> v4=new Vertex<>(4);
        private final Vertex<Integer> v5=new Vertex<>(5);
        private final Vertex<Integer> v6=new Vertex<>(6);
        private final Vertex<Integer> v7=new Vertex<>(7);
        private final Vertex<Integer> v8=new Vertex<>(8);
         {
            vertices.add(v1);
            vertices.add(v2);
            vertices.add(v3);
            vertices.add(v4);
            vertices.add(v5);
            vertices.add(v6);
            vertices.add(v7);
            vertices.add(v8);
        }
        private final List<Edge<Integer>> edges=new ArrayList<>();
        private final Edge<Integer> e1_2=new Edge<>(7,v1,v2);
        private final Edge<Integer> e1_3=new Edge<>(9,v1,v3);
        private final Edge<Integer> e1_6=new Edge<>(14,v1,v6);
        private final Edge<Integer> e2_3=new Edge<>(10,v2,v3);
        private final Edge<Integer> e2_4=new Edge<>(15,v2,v4);
        private final Edge<Integer> e3_4=new Edge<>(11,v3,v4);
        private final Edge<Integer> e3_6=new Edge<>(2,v3,v6);
        private final Edge<Integer> e6_5=new Edge<>(9,v6,v5);
        private final Edge<Integer> e6_8=new Edge<>(14,v6,v8);
        private final Edge<Integer> e4_5=new Edge<>(6,v4,v5);
        private final Edge<Integer> e4_7=new Edge<>(16,v4,v7);
        private final Edge<Integer> e1_8=new Edge<>(30,v1,v8);
        {
            edges.add(e1_2);
            edges.add(e1_3);
            edges.add(e1_6);
            edges.add(e2_3);
            edges.add(e2_4);
            edges.add(e3_4);
            edges.add(e3_6);
            edges.add(e6_5);
            edges.add(e6_8);
            edges.add(e4_5);
            edges.add(e4_7);                        
            edges.add(e1_8);                        
        }
        protected final Graph<Integer> graph=new Graph<>(Graph.TYPE.DIRECTED,vertices,edges);
    }
}
