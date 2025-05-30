package uni.aed.queueTDA.workschedule;
class Trabajo{
	private int prioridad;
	private int tiempoEjecucion;
	private int tiempoLlegada;
	
	public Trabajo(int prioridad, int tiempoEjecucion, int tiempoLlegada) {
		this.prioridad = prioridad;
		this.tiempoEjecucion = tiempoEjecucion;
		this.tiempoLlegada = tiempoLlegada;
	}    
	
	public int getPrioridad() {
		return prioridad;
	}
	
	public int getTiempoEjecucion() {
		return tiempoEjecucion;
	}
	
	public void setTiempoEjecucion(int tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}
	
	public int getTiempoLlegada() {
		return tiempoLlegada;
	}
	
	public void setTiempoLlegada(int tiempoLlegada) {
		this.tiempoLlegada = tiempoLlegada;
	}
        
        @Override
        public String toString() {
            return "Trabajo{" + "prioridad=" + prioridad + ", tiempoEjecucion=" + tiempoEjecucion + ", tiempoLlegada=" + tiempoLlegada + '}';
        }
}
	