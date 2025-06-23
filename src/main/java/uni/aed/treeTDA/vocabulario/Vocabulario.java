package uni.aed.treeTDA.vocabulario;
import uni.aed.tda.LinkedListTDA.LinkedListTDA;
import uni.aed.tda.ListTDA.ListTDA;
/**
 * Clase que representa una entrada de vocabulario con una palabra en inglés
 * y sus equivalente en latín almacenados en una lista enlazada. Se implementa un
 * comparable para garantizar el orden alfabetico. 
 */
public class Vocabulario implements Comparable<Vocabulario> {    
    private String palabra;  // Palabra en inglés (clave del nodo)
    private ListTDA<String> equivalente;  // Lista de equivalente en latín
    
    /**
     * Constructor que inicializa una entrada de vocabulario
     */
    public Vocabulario(String palabra) {
        this.palabra = palabra.trim();
        this.equivalente = new LinkedListTDA<>();
    }
    
    /**
     * Agrega un equivalente en latín a la lista de equivalente
     */
    public void addEquivalent(String p) {
        // Verificar si el equivalente ya existe para evitar duplicados
        if (!contains(p.trim())) {
            this.equivalente.add(p.trim());
        }
    }
    
    /**
     * Verifica si ya existe un equivalente en latín específico
     */
    private boolean contains(String p) {
        for (int i = 0; i < equivalente.size(); i++) {
            if (equivalente.get(i).equals(p)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Convierte los equivalente en latín a una cadena separada por comas
     */
    public String getEquivalenteAsString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < equivalente.size(); i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(equivalente.get(i));
        }
        return result.toString();
    }
    
    /**
     * Implementación del método compareTo para ordenamiento alfabético
     */
    @Override
    public int compareTo(Vocabulario other) {
        return this.palabra.compareTo(other.palabra);
    }
    
    /**
     * Representación en cadena de la entrada de vocabulario
     */
    @Override
    public String toString() {
        return palabra + " : " + getEquivalenteAsString();
    }
}