package uni.aed.queueTDA.simularagenda;

import uni.aed.queueTDA.PriorityQueueTDA;
import uni.aed.queueTDA.ArrayQueueTDA;
import java.util.Random;

public class SimuladorAgenda {
    private static final int TAMANIO_INICIAL_COLA = 10;
    private final PriorityQueueTDA<Trabajo> colaEspera;          // Cola de trabajos esperando
    private final ArrayQueueTDA<Trabajo> trabajosEjecutando;     // Trabajos actualmente ejecutándose
    private final EstadisticasPrioridad[] estadisticasPorPrioridad; // Estadísticas por nivel de prioridad
    private final Random generador;                              // Generador de números aleatorios
    private int tiempoSimulacion;                         // Minutos totales a simular
    private int tiempoSimulacionExtra=0;
    private int maxTrabajosSimultaneos;                   // Máximo trabajos ejecutándose simultáneamente
    private int contadorTrabajos;                         // Contador para IDs únicos de trabajos
    private boolean simulacionActiva;                     // Estado de la simulación
    
    // Definimos las constantes para la simulación
    private static final int MIN_PRIORIDAD = 1;
    private static final int MAX_PRIORIDAD = 5;
    private static final int MIN_TIEMPO_EJECUCION = 1;
    private static final int MAX_TIEMPO_EJECUCION = 10;
    private static final String SEPARADOR = "\n";
    private static final String TITULO_REPORTE = "--- VISUALIZACION DE LA AGENDA DE TRABAJO ---";
    StringBuilder reporte;
    
    // Creamos el constructor del simulador
    public SimuladorAgenda() {
        this.colaEspera = new PriorityQueueTDA<>(TAMANIO_INICIAL_COLA);
        this.trabajosEjecutando = new ArrayQueueTDA<>(TAMANIO_INICIAL_COLA);
        this.generador = new Random();
        this.contadorTrabajos = 1;
        this.simulacionActiva = false;
        reporte = new StringBuilder();
        
        // Inicializar estadísticas para cada nivel de prioridad (1-5)
        this.estadisticasPorPrioridad = new EstadisticasPrioridad[MAX_PRIORIDAD + 1];
        for (int i = MIN_PRIORIDAD; i <= MAX_PRIORIDAD; i++) {
            estadisticasPorPrioridad[i] = new EstadisticasPrioridad(i);
        }
        reporte.append(TITULO_REPORTE+SEPARADOR);
    }
    
    // Cargamos y ejecutamos una nueva simulación de agenda
    public void cargarAgenda(int minutos, int maxTrabajos) {
        if (minutos <= 0 || maxTrabajos <= 0) {
            throw new IllegalArgumentException("Los parámetros deben ser positivos");
        }
        
        // Reiniciar estado de la simulación
        reiniciarSimulacion();
        
        this.tiempoSimulacion = minutos;
        this.maxTrabajosSimultaneos = maxTrabajos;
        this.simulacionActiva = true;
        
        // Ejecutar la simulación minuto a minuto
        for (int minutoActual = 1; minutoActual <= tiempoSimulacion; minutoActual++) {
            procesarMinuto(minutoActual);    
            setReporte();     
        }
        
        // Procesar trabajos restantes en la cola al final de la simulación
        procesarTrabajosRestantes();   
        reporte.append(SEPARADOR+"Simulación completada: " + minutos + " minutos, " + maxTrabajos + " trabajos simultáneos máximo"+SEPARADOR);        
    }
    
    // Procesamos los eventos de un minuto específico
    private void procesarMinuto(int minutoActual) {
        // 1. Llega un nuevo trabajo cada minuto
        generarNuevoTrabajo(minutoActual);
        
        // 2. Ejecutar trabajos actualmente en proceso
        ejecutarTrabajosActivos(minutoActual);
        
        // 3. Asignar nuevos trabajos si hay capacidad disponible
        asignarNuevosTrabajos();
    }
    
    // Generamos un nuevo trabajo aleatorio que llega en el minuto actual
    private void generarNuevoTrabajo(int minutoLlegada) {
        // Generar prioridad aleatoria (1-5)
        int prioridad = generador.nextInt(MAX_PRIORIDAD - MIN_PRIORIDAD + 1) + MIN_PRIORIDAD;
        
        // Generar tiempo de ejecución aleatorio (1-10 minutos)
        int tiempoEjecucion = generador.nextInt(MAX_TIEMPO_EJECUCION - MIN_TIEMPO_EJECUCION + 1) + MIN_TIEMPO_EJECUCION;
        
        // Crear y agregar el nuevo trabajo a la cola de espera
        Trabajo nuevoTrabajo = new Trabajo(contadorTrabajos++, prioridad, 
                                          tiempoEjecucion, minutoLlegada);
        colaEspera.enqueue(nuevoTrabajo);                
    }
    
    // Ejectuamos todos los trabajos actualmente en proceso por un minuto
    private void ejecutarTrabajosActivos(int minutoActual) {
        ArrayQueueTDA<Trabajo> trabajosTemporales = new ArrayQueueTDA<>(TAMANIO_INICIAL_COLA);
        
        // Procesar cada trabajo en ejecución
        while (!trabajosEjecutando.isEmpty()) {
            Trabajo trabajo = trabajosEjecutando.dequeue();
            boolean completado = trabajo.ejecutarUnMinuto();
            
            if (completado) {
                // Trabajo completado: registrar estadísticas
                int tiempoEspera = trabajo.calcularTiempoEspera(minutoActual);
                estadisticasPorPrioridad[trabajo.getPrioridad()].registrarTiempoEspera(tiempoEspera);
            } else {
                // Trabajo no completado: mantener en ejecución
                trabajosTemporales.enqueue(trabajo);
            }
        }
        
        // Restaurar trabajos no completados
        while (!trabajosTemporales.isEmpty()) {
            trabajosEjecutando.enqueue(trabajosTemporales.dequeue());
        }
    }
    
    // Asignamos nuevos trabajos de la cola de espera si hay capacidad disponible
    private void asignarNuevosTrabajos() {
        // Mientras haya capacidad y trabajos en espera
        while (trabajosEjecutando.size() < maxTrabajosSimultaneos && !colaEspera.isEmpty()) {
            Trabajo trabajo = colaEspera.dequeue();
            trabajosEjecutando.enqueue(trabajo);
        }
    }
    
    // Procesamos todos los trabajos restantes en la cola al final de la simulación
    private void procesarTrabajosRestantes() {
        //int minutoExtra = tiempoSimulacion + 1;
        tiempoSimulacionExtra= tiempoSimulacion + 1;
        
        // Continuar procesando hasta que no queden trabajos
        while (!colaEspera.isEmpty() || !trabajosEjecutando.isEmpty()) {
            // Ejecutar trabajos activos
            ejecutarTrabajosActivos(tiempoSimulacionExtra);
            
            // Asignar nuevos trabajos si hay capacidad
            asignarNuevosTrabajos();
            setTiempoSimulacionExtra(tiempoSimulacionExtra);
            setReporte(); 
            tiempoSimulacionExtra++;            
        }
    }

    public void setTiempoSimulacionExtra(int tiempoSimulacionExtra) {
        this.tiempoSimulacionExtra = tiempoSimulacionExtra;
    }

    public int getTiempoSimulacionExtra() {
        return tiempoSimulacionExtra;
    }
    
    
    // Obtenemos el tiempo de espera promedio de todos los trabajos procesados
    public double obtenerTiempoEsperaPromedio() {
        if (!simulacionActiva) {
            return 0.0;
        }
        
        int totalTrabajos = 0;
        int tiempoTotal = 0;
        
        for (int i = MIN_PRIORIDAD; i <= MAX_PRIORIDAD; i++) {
            EstadisticasPrioridad stats = estadisticasPorPrioridad[i];
            totalTrabajos += stats.getTotalTrabajos();
            tiempoTotal += stats.getTiempoEsperaTotal();
        }
        
        return totalTrabajos > 0 ? (double) tiempoTotal / totalTrabajos : 0.0;
    }
    
    // Obtiene el tiempo de espera máximo por nivel de prioridad
    public EstadisticasPrioridad[] obtenerEstadisticasPorPrioridad() {
        return estadisticasPorPrioridad.clone();
    }
    
    // Eliminamos la agenda de trabajo actual y reinicia el simulador
    public void eliminarAgenda() {
        reiniciarSimulacion();
        System.out.println("Agenda de trabajo eliminada y simulador reiniciado");
    }
    
    // Reiniciamos el estado completo del simulador
    private void reiniciarSimulacion() {
        // Limpiar colas
        colaEspera.clear();
        trabajosEjecutando.clear();
        
        // Reiniciar estadísticas
        for (int i = MIN_PRIORIDAD; i <= MAX_PRIORIDAD; i++) {
            estadisticasPorPrioridad[i].reiniciar();
        }
        
        // Reiniciar contadores
        contadorTrabajos = 1;
        simulacionActiva = false;
        tiempoSimulacion = 0;
        maxTrabajosSimultaneos = 0;
        
        tiempoSimulacionExtra = 0;
        reporte.setLength(0);        
    }
    
    // Visualizamos el estado actual de la agenda de trabajo
    public String visualizarAgenda() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- ESTADO ACTUAL DE LA AGENDA DE TRABAJO ---\n");
        
        if (!simulacionActiva) {
            sb.append("No hay simulación activa. Cargue una agenda primero.\n");
            return sb.toString();
        }
        
        // Información general
        sb.append(String.format("Simulación: %d minutos, máximo %d trabajos simultáneos\n", 
                               tiempoSimulacion, maxTrabajosSimultaneos));
        sb.append(String.format("Tiempo de espera promedio general: %.2f minutos\n\n", 
                               obtenerTiempoEsperaPromedio()));
        
        // Estadísticas por prioridad
        sb.append("ESTADÍSTICAS POR NIVEL DE PRIORIDAD:\n");
        for (int i = MIN_PRIORIDAD; i <= MAX_PRIORIDAD; i++) {
            sb.append(estadisticasPorPrioridad[i].toString()).append("\n");
        }
        
        // Estado de las colas
        sb.append(String.format("\nTRABAJOS EN ESPERA: %d\n", colaEspera.size()));
        sb.append(String.format("TRABAJOS EJECUTÁNDOSE: %d\n", trabajosEjecutando.size()));
        
        return sb.toString();
    }    

    public int getTiempoSimulacion() {
        return tiempoSimulacion;
    }

    public void getEstadisticasPorPrioridad() {
            EstadisticasPrioridad[] estadisticas = obtenerEstadisticasPorPrioridad();                
            reporte.append("\nTraza Estadistica Trabajos Concluidos o en Ejecucion\n(No incluye los Trabajos en Espera):\n");
            for (int i = 1; i < estadisticas.length; i++)
                    reporte.append(estadisticas[i].toString()+ SEPARADOR);                            
    }
    
    
    private void setReporte(){
        reporte.append("\nTRABAJOS COLA DE ESPERA:\n"+colaEspera.toString(SEPARADOR));
        reporte.append("\nTRABAJOS EN EJECUCION:\n"+trabajosEjecutando.toString(SEPARADOR));
        if (getTiempoSimulacionExtra()> getTiempoSimulacion()){
            reporte.append("\nTiempo de Simuluacion Extra:\n"+getTiempoSimulacionExtra());
            getEstadisticasPorPrioridad();
        }
    }

    @Override
    public String toString() {
        return reporte.toString();
    }
    
    // Verificamos si hay una simulación activa
    public boolean isSimulacionActiva() {
        return simulacionActiva;
    }
}


