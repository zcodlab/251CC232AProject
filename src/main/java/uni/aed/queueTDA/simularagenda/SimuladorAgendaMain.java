package uni.aed.queueTDA.simularagenda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimuladorAgendaMain {
    private final SimuladorAgenda simulador = new SimuladorAgenda();  // Instancia del simulador de agenda
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");           // Scanner para entrada de usuario
    
    
    public static void main(String[] args) {
        SimuladorAgendaMain simuladorAgendaMain=new SimuladorAgendaMain();
        simuladorAgendaMain.menu();
    }
    
    private void menu() {
        String SEPARADOR = "\n";
        int opcion = 5;
        try {            
            do {                
                System.out.println("--- SIMULADOR DE AGENDA DE TRABAJO ---");
                System.out.print("--- MENÚ DE OPCIONES ---" + SEPARADOR +
                        "1.- Cargar Agenda de Trabajo " + SEPARADOR +                        
                        "2.- Obtener el tiempo de espera promedio" + SEPARADOR +
                        "3.- Obtener el tiempo de espera máximo por nivel de priorida" + SEPARADOR +                        
                        "4.- Eliminar actual Agenda de Trabajo" + SEPARADOR +
                        "5.- Visualizar Agenda de Trabajo" + SEPARADOR +                        
                        "6.- Salir " + SEPARADOR + "Elija una opcion: ");
                opcion = scanner.nextInt();  // Leer la opción del usuario

                // Acciones según la opción seleccionada
                switch (opcion) {
                    case 1 -> { cargarAgendaTrabajo(); visualizarAgendaTrabajo();}                    
                    case 2 -> { obtenerTiempoEsperaPromedio(); }
                    case 3 -> { obtenerTiempoEsperaMaximoPorPrioridad(); }                    
                    case 4 -> { eliminarAgendaTrabajo(); }
                    case 5 -> { visualizarAgendaTrabajo(); }                    
                    case 6 -> { System.out.println("Saliendo del programa..."); return; }  // Salir del programa
                    default -> System.out.println("Opción no válida. Por favor, elija una opción correcta(1-6).");
                }
            } while (opcion != 6);  // El bucle continuará hasta que se elija la opción 6
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar obligatoriamente un número entero como opción elegida." + e.toString());
        } catch (Exception e) {
            System.out.println("Error presentado: " + e.getMessage());
        }
    }
    // Opción a) Cargar Agenda de Trabajo
    private void cargarAgendaTrabajo() {
        System.out.println("--- CARGAR AGENDA DE TRABAJO ---");
        
        try {
            // Solicitar minutos a simular
            System.out.print("Ingrese el número de minutos a simular (M): ");
            int minutos = leerEnteroPositivo();
            
            // Solicitar número máximo de trabajos simultáneos
            System.out.print("Ingrese el número máximo de trabajos simultáneos (N): ");
            int maxTrabajos = leerEnteroPositivo();
            
            // Confirmar parámetros
            System.out.printf("\nConfirmación de parámetros:\n");
            System.out.printf("- Minutos a simular: %d\n", minutos);
            System.out.printf("- Trabajos simultáneos máximo: %d\n", maxTrabajos);
            System.out.print("¿Proceder con la simulación? (s/n): ");
            
            String confirmacion = scanner.nextLine().trim().toLowerCase();
            if (confirmacion.equals("s") || confirmacion.equals("si")) {
                System.out.println("\nEjecutando simulación...");
                
                // Ejecutar la simulación
                long tiempoInicio = System.currentTimeMillis();
                simulador.cargarAgenda(minutos, maxTrabajos);
                long tiempoFin = System.currentTimeMillis();
                
                System.out.printf("Simulación completada en %d ms\n", (tiempoFin - tiempoInicio));
                System.out.println("Use la opción 'e' para visualizar los resultados.");
            } else {
                System.out.println("Simulación cancelada.");
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado al cargar la agenda: " + e.getMessage());
        }
    }
    
    // Opción b) Obtener el tiempo de espera promedio
    private void obtenerTiempoEsperaPromedio() {
        System.out.println("--- TIEMPO DE ESPERA PROMEDIO ---");
        
        if (!simulador.isSimulacionActiva()) {
            System.out.println("No hay simulación activa. Cargue una agenda primero.");
            return;
        }
        
        double tiempoPromedio = simulador.obtenerTiempoEsperaPromedio();
        System.out.printf("Tiempo de espera promedio general: %.2f minutos\n", tiempoPromedio);
    }
    
    // Opción c) Obtener el tiempo de espera máximo por nivel de prioridad
    private void obtenerTiempoEsperaMaximoPorPrioridad() {
        System.out.println("--- TIEMPO DE ESPERA MÁXIMO POR NIVEL DE PRIORIDAD ---");
        
        if (!simulador.isSimulacionActiva()) {
            System.out.println("No hay simulación activa. Cargue una agenda primero.");
            return;
        }
        
        EstadisticasPrioridad[] estadisticas = simulador.obtenerEstadisticasPorPrioridad();
        boolean hayEstadisticas = false;
        
        for (int i = 1; i < estadisticas.length; i++) {
            if (estadisticas[i].tieneTrabajos()) {
                System.out.println(estadisticas[i].toString());
                hayEstadisticas = true;
            }
        }
        
        if (!hayEstadisticas) {
            System.out.println("No hay estadísticas disponibles para ningún nivel de prioridad.");
        }
    }
    
    // Opción d) Eliminar actual Agenda de Trabajo
    private void eliminarAgendaTrabajo() {
        System.out.println("--- ELIMINAR AGENDA DE TRABAJO ---");
        
        if (!simulador.isSimulacionActiva()) {
            System.out.println("No hay simulación activa para eliminar.");
            return;
        }
        
        System.out.print("¿Está seguro de que desea eliminar la agenda actual? (s/n): ");
        String confirmacion = scanner.next().trim().toLowerCase();
        
        if (confirmacion.equals("s") || confirmacion.equals("si"))
            simulador.eliminarAgenda();
        else
            System.out.println("Eliminación cancelada.");        
    }
    
    // Opción e) Visualizar Agenda de Trabajo
    private void visualizarAgendaTrabajo() {        
        System.out.println(simulador.toString());        
    }
    
    // Leemos un número entero positivo del usuario
    private int leerEnteroPositivo() {
        while (true) {
            try {
                int numero = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                if (numero <= 0) {
                    throw new IllegalArgumentException("El número debe ser positivo");
                }
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.nextLine(); // Limpiar buffer
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.print("Intente nuevamente: ");
        }
    }    
}
