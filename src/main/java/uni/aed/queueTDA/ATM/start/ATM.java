package uni.aed.queueTDA.ATM.start;

import java.util.LinkedList;
import java.util.Queue;

public class ATM {
    private boolean disponible;      
    private Queue<Cliente> colaClientes;
    protected Cliente clienteActual; 

    public ATM() {
        this.disponible = true;
        this.colaClientes = new LinkedList<>();
        this.clienteActual = null;
    }
    
    public boolean estaEnUso() {
        return clienteActual != null;
    }
    
    public void asignarCliente(Cliente cliente) {
        if (disponible) {
            clienteActual = cliente;
            disponible = false;
        } else {
            colaClientes.add(cliente);  
            cliente.incrementarTiempoEspera();  
        }
    }
    
    public void procesarCliente() {
        if (clienteActual != null) {
            clienteActual.reducirTiempoTransaccion();
            if (clienteActual.estaAtendido()) {
                disponible = true;
                clienteActual = null;
            }
        }
    }
    
    public void atenderSiguienteCliente() {
        if (disponible && !colaClientes.isEmpty()) {
            clienteActual = colaClientes.poll();
            disponible = false;
        }
    }
    
    public Queue<Cliente> getColaClientes() {
        return colaClientes;
    }

    public boolean estaDisponible() {
        return disponible;
    }
}

