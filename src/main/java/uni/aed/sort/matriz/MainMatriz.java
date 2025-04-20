package uni.aed.sort.matriz;

import java.util.Scanner;

public class MainMatriz {
    private static final int  N_SERIE = 100;
    private static final int  RANGO_INI = 100;
    public static void main(String[] args) {
        // Instanciamos los objetos necesarios
        try (Scanner sc = new Scanner(System.in)) {
            // Instanciamos los objetos necesarios
            Serie serie = new Serie(N_SERIE,RANGO_INI);
            Matriz matriz = new Matriz();
            int opcion;
            do {
                mostrarMenu(); // Mostrar opciones
                opcion = sc.nextInt(); // Leer opción                
                switch (opcion) {
                    case 1 -> {
                        serie.generar(); // Generar serie aleatoria
                        System.out.println("Serie generada correctamente.");
                    }
                    case 2 -> {
                        serie.ordenar(); // Ordenar la serie
                        System.out.println("Serie ordenada con QuickSort.");
                    }
                    case 3 -> System.out.print(serie.toString()); // Mostrar la serie
                    case 4 -> {
                        System.out.print("Ingrese el valor de n (tamaño de la matriz nxn): ");
                        int n = sc.nextInt();
                        matriz.cargar(n, serie.getDatos()); // Cargar matriz con la serie ordenada
                        System.out.println("Matriz cargada correctamente.");
                    }
                    case 5 -> System.out.print(matriz.toString()); // Mostrar matriz
                    case 0 -> System.out.println("Programa finalizado.");
                    default -> System.out.println("Opción inválida.");
                }
            } while (opcion != 0);
            sc.close();
        }
    }

    // Menú interactivo para el usuario
    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Generar Serie");
        System.out.println("2. Ordenar Serie");
        System.out.println("3. Visualizar Serie");
        System.out.println("4. Cargar Matriz");
        System.out.println("5. Visualizar Matriz");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
