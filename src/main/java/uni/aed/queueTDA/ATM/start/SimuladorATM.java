
package uni.aed.queueTDA.ATM.start;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SimuladorATM {
    private int M;  
    private double P;
    private int N;
    private List<ATM> cajeros;  

    public SimuladorATM(int M, double P, int N) {
        this.M = M;
        this.P = P;
        this.N = N;
        this.cajeros = new LinkedList<>(); 
        for (int i = 0; i < N; i++) {
            cajeros.add(new ATM());  
        }
    }

    public void simular() {
        Random rand = new Random();
        int totalTiempoEspera = 0;
        int totalClientes = 0;

        for (int min = 0; min < M; min++) {            
            if (rand.nextDouble() < P) {
                int tiempoTransaccion = rand.nextInt(5) + 1; 
                Cliente nuevoCliente = new Cliente(tiempoTransaccion);
                totalClientes++;
                
                asignarCliente(nuevoCliente);
            }
            
            for (ATM cajero : cajeros) {
                cajero.procesarCliente();
            }
            
            for (ATM cajero : cajeros) {
                if (cajero.estaDisponible()) {
                    cajero.atenderSiguienteCliente();
                }
            }
        }
        
        for (ATM cajero : cajeros) {
            for (Cliente cliente : cajero.getColaClientes()) {
                totalTiempoEspera += cliente.getTiempoEspera();
            }
            
            if (cajero.estaEnUso()) {
                totalTiempoEspera += cajero.clienteActual.getTiempoEspera();
            }
        }
        
        double tiempoEsperaPromedio = (totalClientes > 0) ? (double) totalTiempoEspera / totalClientes : 0;

        // Imprimir los valores de entrada y el tiempo de espera promedio
        System.out.println("\nSimulación terminada con los siguientes parámetros:");
        System.out.println("Minutos a simular (M): " + M);
        System.out.println("Probabilidad de que llegue un cliente (P): " + P);
        System.out.println("Número de cajeros automáticos (N): " + N);
        System.out.println("Tiempo de espera promedio: " + tiempoEsperaPromedio);
    }
    
    private void asignarCliente(Cliente cliente) {
        ATM mejorCajero = null;
        int colaMinima = Integer.MAX_VALUE;
        
        for (ATM cajero : cajeros) {
            if (cajero.getColaClientes().size() < colaMinima) {
                mejorCajero = cajero;
                colaMinima = cajero.getColaClientes().size();
            }
        }

        mejorCajero.asignarCliente(cliente);
    }
}
