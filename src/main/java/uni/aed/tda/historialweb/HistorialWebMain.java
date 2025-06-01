package uni.aed.tda.historialweb;

import uni.aed.tda.LinkedListTDA.LinkedListTDA;
import uni.aed.tda.ListTDA.ListTDA;
import java.util.Scanner;
import uni.aed.sort.SortObject;

// Definimos la clase principal que implementa el sistema de historial de navegación web.
public class HistorialWebMain {
    
    // Creamos la lista enlazada que almacena el historial de páginas web visitadas
    private final ListTDA<PaginaWeb> historial;
    private final Scanner scanner;
    
    // Realizamos el constructor que inicializa el historial vacío y el scanner para entrada de datos.
    public HistorialWebMain() {
        this.historial = new LinkedListTDA<>(); // Instancia la lista enlazada vacía
        this.scanner = new Scanner(System.in);
    }
    
    // Implementamos el método principal que ejecuta el programa.
    public static void main(String[] args) {
        HistorialWebMain sistema = new HistorialWebMain();
        sistema.ejecutarMenu();
    }
    
    // Escribimos la función que ejecuta el menú principal del sistema con las opciones disponibles.
    public void ejecutarMenu() {
        try (scanner) {
            int opcion;
            do {
                mostrarMenu();
                opcion = leerOpcion();                
                // Creamos el switch que ejecuta la operación correspondiente según la opción elegida
                switch (opcion) {
                    case 1 -> agregarPagina();
                    case 2 -> eliminarURL();
                    case 3 -> buscarURL();
                    case 4 -> agregarVisitaRelativa();
                    case 5 -> visualizarHistorial();
                    case 6 -> System.out.println("Gracias por usar HistorialWeb ¡Vuelva pronto!");
                    default -> System.out.println("Opción inválida. Intente nuevamente.");
                }                

            } while (opcion != 6);
        }
    }
    
    // Escribimos la función para mostrar el menú de opciones disponibles en el sistema.
    private void mostrarMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("---- SISTEMA DE HISTORIAL DE NAVEGACIÓN WEB ----");
        System.out.println("=".repeat(60));
        System.out.println("1. Agregar página al historial");
        System.out.println("2. Eliminar una URL específica del historial");
        System.out.println("3. Buscar si una URL fue visitada");
        System.out.println("4. Agregar nueva visita antes o después de una URL existente");
        System.out.println("5. Visualizar historial en orden cronológico");
        System.out.println("6. Salir");
        System.out.println("=".repeat(60));
        System.out.print("Seleccione una opción: ");
    }
    
    // Escribimos la función que lee y valida la opción ingresada por el usuario.
    private int leerOpcion() {
        try {
            int opcion = Integer.parseInt(scanner.nextLine().trim());
            return opcion;
        } catch (NumberFormatException e) {
            return -1; // Retorna -1 para opción inválida
        }
    }
    
    // Escribimos la función que implementa la funcionalidad de agregar una nueva página al historial.
    private void agregarPagina() {
        System.out.println("\n--- AGREGAR PÁGINA AL HISTORIAL ---");
        System.out.print("Ingrese la URL de la página: ");
        String url = scanner.nextLine().trim();
        
        // Validación básica de URL no vacía
        if (url.isEmpty()) {
            System.out.println("Error: La URL no puede estar vacía.");
            return;
        }        
        // Crear nueva página web con timestamp actual
        PaginaWeb nuevaPagina = new PaginaWeb(url);        
        // Agregar al final de la lista (orden cronológico)
        historial.add(nuevaPagina);        
        System.out.println("  Página agregada exitosamente al historial.");
        System.out.println(historial.toString("\n"));
    }
    
    // Escribimos la función que implementa la funcionalidad de eliminar una URL específica del historial.
    private void eliminarURL() {
        System.out.println("\n--- ELIMINAR URL DEL HISTORIAL ---");        
        // Verificar si el historial está vacío
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }        
        System.out.print("Ingrese la URL a eliminar: ");
        String url = scanner.nextLine().trim();        
        // Crear página temporal para búsqueda (solo se usa la URL para comparación)
        PaginaWeb paginaBuscar = new PaginaWeb(url);        
        // Intentar eliminar la página del historial
        boolean eliminado = historial.delete(paginaBuscar);        
        if (eliminado) {
            System.out.println(" URL eliminada exitosamente del historial :).");
        } else {
            System.out.println(" La URL no fue encontrada en el historial :(.");
        }
        System.out.println(historial.toString("\n"));
    }
    
    // Escribimos la función que implementa la funcionalidad de búsqueda de URLs en el historial.
    private void buscarURL() {
        System.out.println("\n--- BUSCAR URL EN EL HISTORIAL ---");        
        // Verificar si el historial está vacío
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío :(.");
            return;
        }        
        System.out.print("Ingrese la URL a buscar: ");
        String url = scanner.nextLine().trim();        
        // Crear página temporal para búsqueda
        PaginaWeb paginaBuscar = new PaginaWeb(url);        
        // Buscar usando el método contain de la lista
        boolean encontrada = historial.contain(paginaBuscar);        
        if (encontrada) {
            System.out.println(" La URL fue encontrada en el historial :).");            
            // Obtener el índice para mostrar detalles completos
            int indice = historial.indexOf(paginaBuscar);
            if (indice >= 0) {
                PaginaWeb paginaEncontrada = historial.get(indice);
                System.out.println("  Detalles: " + paginaEncontrada.toString());
            }
        } else {
            System.out.println(" La URL no fue encontrada en el historial :(.");
        }
        System.out.println(historial.toString("\n"));
    }
    
    // Escribimos la función que implementa la funcionalidad de agregar una nueva visita antes o después de una URL existente en el historial.
    private void agregarVisitaRelativa() {
        System.out.println("\n--- AGREGAR VISITA RELATIVA ---");        
        // Verificar si el historial está vacío
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío. No hay URLs de referencia.");
            return;
        }        
        System.out.print("Ingrese la URL de referencia: ");
        String urlReferencia = scanner.nextLine().trim();        
        // Buscar la URL de referencia en el historial
        PaginaWeb paginaReferencia = new PaginaWeb(urlReferencia);
        int indiceReferencia = historial.indexOf(paginaReferencia);        
        if (indiceReferencia == -1) {
            System.out.println(" La URL de referencia no fue encontrada en el historial :(.");
            return;
        }        
        System.out.print("Ingrese la nueva URL a agregar: ");
        String nuevaUrl = scanner.nextLine().trim();        
        if (nuevaUrl.isEmpty()) {
            System.out.println("Error: La URL no puede estar vacía.");
            return;
        }        
        System.out.print("¿Agregar ANTES (a) o DESPUÉS (d) de la URL de referencia? ");
        String posicion = scanner.nextLine().trim().toLowerCase();        
        // Crear nueva página web
        PaginaWeb nuevaPagina = new PaginaWeb(nuevaUrl);
        
        try {
            switch (posicion) {
                case "a", "antes" -> {
                    // Insertar antes de la URL de referencia
                    historial.add(indiceReferencia, nuevaPagina);
                    System.out.println(" URL agregada ANTES de la referencia.");
                }
                case "d", "despues" -> {
                    // Insertar después de la URL de referencia
                    historial.add(indiceReferencia + 1, nuevaPagina);
                    System.out.println(" URL agregada DESPUÉS de la referencia.");
                }
                default -> System.out.println(" Opción inválida. Use 'a' para antes o 'd' para después.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(" Error al insertar la página: " + e.getMessage());
        }
        System.out.println(historial.toString("\n"));
    }
    
    // Escribimos la función que implementa la funcionalidad de visualizar todo el historial en orden cronológico.
    private void visualizarHistorial() {
        SortObject sort = new SortObject(); //Para ordenarlo
        sort.setX(historial.toArray()); //Devuelve un array de Objects
        sort.callMergeSort(); //MergeSort O(nlogn)
        Object[] temp = sort.getX(); //Arreglo temporal para guardar el arreglo ordenado
        System.out.println("Registro Cronologico del Historial Web");        
            System.out.println("URL         |       Fecha"); 
        for (Object o : temp)
            System.out.println(((PaginaWeb)o).toString());        

    }
}


