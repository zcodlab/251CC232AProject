package uni.aed.queueTDA.simularagenda;

public class EstadisticasPrioridad {
    private final int prioridad;              // Nivel de prioridad (1-5)
    private int totalTrabajos;          // Total de trabajos procesados
    private int tiempoEsperaTotal;      // Suma total de tiempos de espera
    private int tiempoEsperaMaximo;     // Tiempo de espera máximo registrado
    
    // Creamos el constructor para estadisticas de una prioridad específica
    public EstadisticasPrioridad(int prioridad) {
        if (prioridad < 1 || prioridad > 5) {
            throw new IllegalArgumentException("Prioridad debe estar entre 1 y 5");
        }
        this.prioridad = prioridad;
        this.totalTrabajos = 0;
        this.tiempoEsperaTotal = 0;
        this.tiempoEsperaMaximo = 0;
    }
    
    // Registramos el tiempo de espera de un trabajo completado
    public void registrarTiempoEspera(int tiempoEspera) {
        if (tiempoEspera < 0) {
            throw new IllegalArgumentException("Tiempo de espera no puede ser negativo");
        }
        totalTrabajos++;
        tiempoEsperaTotal += tiempoEspera;
        
        // Actualizar tiempo máximo si es necesario
        if (tiempoEspera > tiempoEsperaMaximo) {
            tiempoEsperaMaximo = tiempoEspera;
        }
    }
    
    // Calculamos el tiempo de espera promedio
    public double calcularTiempoEsperaPromedio() {
        if (totalTrabajos == 0) {
            return 0.0;
        }
        return (double) tiempoEsperaTotal / totalTrabajos;
    }
    
    // Definimos los Getters
    public int getPrioridad() { return prioridad; }
    public int getTotalTrabajos() { return totalTrabajos; }
    public int getTiempoEsperaTotal() { return tiempoEsperaTotal; }
    public int getTiempoEsperaMaximo() { return tiempoEsperaMaximo; }
    
    // Verificamos si hay trabajos registrados para esta prioridad
    public boolean tieneTrabajos() {
        return totalTrabajos > 0;
    }
    
    // Reiniciamos todas las estadísticas
    public void reiniciar() {
        totalTrabajos = 0;
        tiempoEsperaTotal = 0;
        tiempoEsperaMaximo = 0;
    }
    
    @Override
    public String toString() {
        if (!tieneTrabajos()) {
            return String.format("Prioridad %d: Sin trabajos procesados", prioridad);
        }
        
        return String.format("Prioridad %d: %d trabajos, Promedio: %.2f min, Máximo: %d min",
                prioridad, totalTrabajos, calcularTiempoEsperaPromedio(), tiempoEsperaMaximo);
    }
}


