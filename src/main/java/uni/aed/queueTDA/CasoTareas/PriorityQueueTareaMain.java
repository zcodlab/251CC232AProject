package uni.aed.queueTDA.CasoTareas;
import java.util.PriorityQueue;
public class PriorityQueueTareaMain {
    public static void main(String[] args) { 
        //creamos la cola prioritaria
        PriorityQueue<Tarea> cola= new PriorityQueue<>();
        //añadimos tareas a la cola prioritaria
        cola.add(new Tarea("Pagar facturas",2));
        cola.add(new Tarea("Estudiar para la 3PC",1));
        cola.add(new Tarea("Lavar los platos",3));
        //procesar las tareas en orden de prioridad
        System.out.println("procesando las tareas por prioridad");
        while(!cola.isEmpty()){
            Tarea tarea=cola.poll();//equivalente al dequeue y a remove
            System.out.println(tarea);
        }
    }
}
