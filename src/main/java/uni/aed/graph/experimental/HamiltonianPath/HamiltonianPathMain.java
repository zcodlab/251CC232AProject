package uni.aed.graph.experimental.HamiltonianPath;

import java.util.List;

public class HamiltonianPathMain {
    public static void main(String[] args) {
        int[][] g1 = {  // Tiene circuito Hamiltoniano
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 0}
        };

        int[][] g2 = {  // Tiene camino Hamiltoniano, pero no circuito
            {0, 1, 0, 0},
            {1, 0, 1, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0}
        };

        int[][] g3 = {  // No tiene camino ni circuito
            {0, 1, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 0, 1},
            {0, 0, 1, 0}
        };

        testGraph(g1, "Grafo 1");
        testGraph(g2, "Grafo 2");
        testGraph(g3, "Grafo 3");
    }

    private static void testGraph(int[][] matrix, String name) {
        HamiltonianPath hg = new HamiltonianPath(matrix);
        System.out.println("Analizando: " + name);
        if (hg.hasHamiltonianPathOrCircuit()) {
            List<Integer> path = hg.getHamiltonianPath();
            if (hg.isHamiltonianCircuit()) {
                System.out.println("Circuito Hamiltoniano encontrado");
            } else {
                System.out.println("Camino Hamiltoniano encontrado (sin retornar al inicio)");
            }
            System.out.println("Recorrido: " + path);
        } else {
            System.out.println("No se encontró camino ni circuito Hamiltoniano");
        }
        System.out.println();
    }
}
