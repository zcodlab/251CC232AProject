package uni.aed.treeTDA.vocabulario;
import uni.aed.treeTDA.BstTDA;
import java.io.*;
import java.util.Scanner;
import uni.aed.tda.LinkedListTDA.LinkedListTDA;
import uni.aed.tda.ListTDA.IteratorTDA;
import uni.aed.tda.ListTDA.ListTDA;

/**
 * Clase responsable del procesamiento del archivo de vocabulario latín-inglés.
 * Se encarga de leer el archivo, procesar cada unidad y generar el vocabulario
 * inglés-latín ordenado alfabéticamente usando árboles binarios de búsqueda.
 */
public class VocabularioManager {
    private String inputFileName;
    private BstTDA<Vocabulario> bst = null;
    private ListTDA<Reporte> reporte=new LinkedListTDA<>();
    private String tituloArbolIni="";
    private String tituloArbolFin="";
    private static final String SEPARADOR = "\n";
    /**
     * Constructor que inicializa el procesador con el nombre del archivo
     */
    public VocabularioManager(String inputFileName) {
        this.inputFileName = inputFileName;
    }
    /**
     * Procesa todo el archivo de vocabulario y genera la salida ordenada
     */
    public StringBuilder procesarVocabulario() {
        StringBuilder result = new StringBuilder();        
        try (Scanner scanner = new Scanner(new File(inputFileName))) {
            String currentUnit = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();                
                // Verificar si es una línea de unidad (comienza con %)
                if (line.startsWith("%")) {
                    // Si hay una unidad anterior, procesarla y agregar al resultado
                    if (currentUnit != null && bst != null) {
                        result.append(generarSalida(currentUnit, bst));
                        reporte.add(new Reporte(currentUnit,bst));
                        // Limpiar el árbol de la memoria como especifica el problema
                        bst = null;                        
                    }
                    // Inicializar nueva unidad
                    currentUnit = line;
                    bst = new BstTDA<>();
                } else if (!line.isEmpty() && bst != null) {
                    // Procesar línea de vocabulario
                    procesarVocabularioLinea(line, bst);                    
                }
            }            
            // Procesar la última unidad
            if (currentUnit != null && bst != null) {
                result.append(generarSalida(currentUnit, bst));
                reporte.add(new Reporte(currentUnit,bst));
            }
            
        } catch (FileNotFoundException e) {
            result.append("Error: No se pudo encontrar el archivo ").append(inputFileName);
        } catch (Exception e) {
            result.append("Error al procesar el archivo: ").append(e.getMessage());
        }        
        return result;
    }
    
    /**
     * Procesa una línea individual de vocabulario (formato: palabra_latina : equivalentes_inglés)
    
     */
     private void procesarVocabularioLinea(String line, BstTDA<Vocabulario> bst) {
        // Dividir la línea en palabra latina y equivalentes en inglés
        String[] parts = line.split(":");
        if (parts.length != 2)
            return; // Línea con formato incorrecto        
        String originWord = parts[0].trim();
        String wordEquivalents = parts[1].trim();        
        // Dividir los equivalentes en inglés por comas
        String[] listaWords = wordEquivalents.split(",");        
        // Procesar cada palabra en inglés
        for (String word : listaWords) {
            // Buscar si ya existe una entrada para esta palabra en inglés
            Vocabulario searchEntry = new Vocabulario(word.trim());
            Vocabulario existingEntry = encontrarEntrada(bst, searchEntry);            
            if (existingEntry != null) {
                // Si existe, agregar el equivalente en latín
                existingEntry.addEquivalent(originWord);
            } else {
                // Si no existe, crear nueva entrada y agregarla al árbol
                Vocabulario newEntry = new Vocabulario(word);
                newEntry.addEquivalent(originWord);
                bst.add(newEntry);
            }
        }
    }
    
    /**
     * Busca una entrada existente en el árbol BST
     */
    private Vocabulario encontrarEntrada(BstTDA<Vocabulario> bst, Vocabulario searchEntry) {
        // Reutilizamos el método search del BST que retorna el nodo
        var node = bst.search(searchEntry);
        return (node != null) ? node.getKey() : null;
    }
    
    /**
     * Genera la salida formateada para una unidad específica
     */
    private String generarSalida(String unitName, BstTDA<Vocabulario> bst) {
        StringBuilder unitOutput = new StringBuilder();
        unitOutput.append(unitName).append(SEPARADOR);        
        // Realizar un recorrido inorder para obtener las palabras en orden alfabético
        StringBuilder inorderResult = new StringBuilder();
        bst.inorder(inorderResult);          
        // El método inorder del BST usa el método visit que llama toString() de VocabularyEntry
        // Procesar el resultado del inorder para formatear correctamente
        String inorderString = inorderResult.toString();
        if (!inorderString.isEmpty() && !inorderString.equals("-1")) {
            // Dividir por comas (separador usado en el método visit del BST)
            String[] entries = inorderString.split(",");
            for (String entry : entries) {
                if (!entry.trim().isEmpty() && !entry.equals("-1")) {
                    unitOutput.append(entry.trim()).append(SEPARADOR);
                }
            }
        }        
        unitOutput.append(SEPARADOR); // Línea en blanco entre unidades
        return unitOutput.toString();
    }
    
    /**
     * Guarda el resultado procesado en un archivo de salida
     */
    public void saveToFile(StringBuilder content, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write(content.toString());            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Verifica si el archivo de entrada existe
     */
    public boolean inputFileExists() {
        File file = new File(inputFileName);
        return file.exists() && file.isFile();
    }

    public void setTituloArbolIni(String tituloArbolIni) {
        this.tituloArbolIni = tituloArbolIni;
    }

    public void setTituloArbolFin(String tituloArbolFin) {
        this.tituloArbolFin = tituloArbolFin;
    }    
    

    @Override
    public String toString() {        
        Reporte r;
        StringBuilder strReturn = new StringBuilder();        
        strReturn.append(SEPARADOR+tituloArbolIni+SEPARADOR);        
        strReturn.append(reporte.toString(SEPARADOR));                
        
        strReturn.append(SEPARADOR+tituloArbolFin+SEPARADOR);        
        IteratorTDA<Reporte> it=reporte.iterador();        
        while(it.hasNext()){            
            r=(Reporte)it.next();                        
            strReturn.append(r.getUnidad()+SEPARADOR+r.getBst().inorder().toString());
        }
        return strReturn.toString();
    }
    
}