package uni.aed.queueTDA.CasoTareas;

public class Tarea implements Comparable<Tarea>{
    private String descripcion;
    private int prioridad;

    public Tarea(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }   
    
    //cuanto menor el valor de prioridad, mas prioridad tiene(orden ascendente)
    @Override
    public int compareTo(Tarea o) {
        return Integer.compare(this.prioridad, o.prioridad);
    }

    @Override
    public String toString() {
        return "Tarea{" + "descripcion=" + descripcion + ", prioridad=" + prioridad + '}';
    }
    
}
