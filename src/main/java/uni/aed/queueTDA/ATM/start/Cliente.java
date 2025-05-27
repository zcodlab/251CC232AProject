package uni.aed.queueTDA.ATM.start;

public class Cliente {
    private int tiempoTransaccion;
    private int tiempoEspera;    

    public Cliente(int tiempoTransaccion) {
        this.tiempoTransaccion = tiempoTransaccion;
        this.tiempoEspera = 0;
    }

    public int getTiempoTransaccion() {
        return tiempoTransaccion;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void incrementarTiempoEspera() {
        this.tiempoEspera++;
    }

    public void reducirTiempoTransaccion() {
        if (this.tiempoTransaccion > 0) {
            this.tiempoTransaccion--;
        }
    }

    public boolean estaAtendido() {
        return this.tiempoTransaccion == 0;
    }
}
