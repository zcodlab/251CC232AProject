package uni.aed.graph.experimental.FloydWarshall;


public class FloydWarshallMain {
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
       
        int[][] graph = {
            {0, 4, 8, INF, INF},
            {4, 0, 1, 2, INF},
            {8, INF, 0, 4 ,2},
            {INF, 2, 4, 0, 7},
            {INF, INF, 2, 7,0}
        };

        FloydWarshall fw = new FloydWarshall();
        fw.FloydWarshall(graph);
    }
}
