package uni.aed.treeTDA.vocabulario;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 Clase principal que implementa el menú de opciones para el procesamiento
 del vocabulario latín-inglés. 
 */
public class VocabularioMain {
    private VocabularioManager processor;
    private Scanner scanner;
    private StringBuilder lastProcessedResult;    
    
    // Constantes que indican donde se alojaran los archivos
    private static final String INPUT_FILE = "src/main/java/uni/aed/treeTDA/vocabulario/Latin.txt";
    private static final String OUTPUT_FILE = "src/main/java/uni/aed/treeTDA/vocabulario/Ingles.txt";
    
    /**
     * Constructor que inicializa el procesador y el scanner
     */
    public VocabularioMain() {
        this.processor = new VocabularioManager(INPUT_FILE);
        this.scanner = new Scanner(System.in);
        this.lastProcessedResult = new StringBuilder();        
    }
    
    /**
     * Método principal que inicia la aplicación
     */
    public static void main(String[] args) {
        VocabularioMain app = new VocabularioMain();
        app.mostrarMenu();
    }
    
    /**
     * Muestra el menú principal y maneja la selección del usuario
     */
    public void mostrarMenu() {
        int option;        
        System.out.println("    PROCESADOR DE VOCABULARIO LATIN-INGLES   ");        
        do {
            imprimirMenuOpciones();
            option = obtenerOpcionMenu();            
            switch (option) {
                case 1:
                    generarPalabrasIngles();
                    break;
                case 2:
                    visualizarArbol();
                    break;                
                case 0:
                    System.out.println("Saliendo ...");
                    break;
                default:
                    System.out.println("\n Opción no válida. Por favor, seleccione una opción del 0 al 3.");
            }            
            if (option != 0)
                esperaUsuario();
        } while (option != 0);        
        scanner.close();
    }
    
    /**
     * Imprime las opciones del menú
     */
    private void imprimirMenuOpciones() {
        System.out.println("                    MENU                      ");
        System.out.println("==============================================");
        System.out.println("1.Generar palabras en ingles (orden alfabetico)");
        System.out.println("2.Visualizar arbol BST");
        System.out.println("0.Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Obtiene la opción seleccionada por el usuario con validación
     
     */
    private int obtenerOpcionMenu() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpiar el buffer
            return -1; // Opción inválida
        } finally {
            scanner.nextLine(); // Consumir el salto de línea
        }
    }
    
    /**
     * Opción 1: Genera las palabras en inglés ordenadas alfabéticamente
     */
    private void generarPalabrasIngles() {
        System.out.println("        GENERANDO VOCABULARIO INGLES-LATIN    ");        
        // Verificar si el archivo de entrada existe
        if (!processor.inputFileExists()) {
            System.out.println(" No se encontro el archivo de entrada: " + INPUT_FILE);            
            return;
        }        
        System.out.println("Archivo de entrada: " + INPUT_FILE +", procesando vocabulario...");        
        
        try {
            // Procesar el vocabulario
            lastProcessedResult = processor.procesarVocabulario();            
            if (lastProcessedResult.length() > 0) {
                System.out.println("Resultado del procesamiento: ");
                System.out.println(lastProcessedResult.toString());                
                // Guardar resultado en archivo
                processor.saveToFile(lastProcessedResult, OUTPUT_FILE);
                System.out.println("Resultado guardado en: " + OUTPUT_FILE);
            } else {
                System.out.println("No se pudo procesar el archivo o está vacío.");
            }            
        } catch (Exception e) {
            System.out.println("Error durante el procesamiento: " + e.getMessage());
        }
    }    
    
    private void visualizarArbol() {  
        String tituloBase="VISUALIZACIÓN DEL ARBOL BST";
        processor.setTituloArbolIni( tituloBase+" - INICIAL");
        processor.setTituloArbolFin(tituloBase+" - FINAL");
        System.out.println(processor.toString());                    
    }
 
    private void esperaUsuario() {
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }
}