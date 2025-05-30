package uni.aed.queueTDA.workschedule;
import java.util.PriorityQueue;
import java.util.Random;

public class App {
    public static void main(String[] args) {                
        int M = 10; 
        int N = 5;
        
        int tiempoEsperaMaximo = 0;
        int[] tiempoEsperaPorPrioridad = new int[N];
        int[] trabajosPorPrioridad = new int[N];
        Trabajo[] trabajosEjecucion = new Trabajo[N];
        
        PriorityQueue<Trabajo> colaPrioridad = new PriorityQueue<>(new ComparadorPrioridad());           
        
        for (int minuto = 0; minuto < M; minuto++) {            
            Trabajo nuevoTrabajo = new Trabajo(generarPrioridad(),
            generarTiempoEjecucion(), minuto);
            colaPrioridad.offer(nuevoTrabajo);            
            boolean flagAdd = false;
            int index = 0;
            for (Trabajo t : trabajosEjecucion) {
                if(t == null){
                    flagAdd = true;
                    break;
                }
                index++;
            }
            if(flagAdd){
                Trabajo trabajoAsignado = colaPrioridad.poll();
                trabajosEjecucion[index] = trabajoAsignado;
                
                int tiempoEspera = minuto - trabajoAsignado.getTiempoLlegada();
                tiempoEsperaMaximo = Math.max(tiempoEsperaMaximo, tiempoEspera);
                
                tiempoEsperaPorPrioridad[trabajoAsignado.getPrioridad()-1] += tiempoEspera;
                trabajosPorPrioridad[trabajoAsignado.getPrioridad()-1]++;
            }
            
            for (int i = 0; i < trabajosEjecucion.length; i++) {
                if(trabajosEjecucion[i] == null) continue;
                int tiempoEjecucion = trabajosEjecucion[i].getTiempoEjecucion() - 1;
                trabajosEjecucion[i].setTiempoEjecucion(tiempoEjecucion);

                if(tiempoEjecucion <= 0){
                    trabajosEjecucion[i] = null;
                }
            }
        }
       
        double[] tiempoEsperaPromedioPorPrioridad = new double[N];

        for (int i = 0; i < N; i++) {
            tiempoEsperaPromedioPorPrioridad[i] = (double) tiempoEsperaPorPrioridad[i] /
            trabajosPorPrioridad[i];
        }
        
        System.out.println("Resultados de la simulación:");
        System.out.println("Tiempo de espera promedio por prioridad:");

        for (int i = 0; i < N; i++) {
            System.out.println("Prioridad " + (i+1) + ": " +
            tiempoEsperaPromedioPorPrioridad[i]);
        }

        System.out.println("Tiempo de espera máximo: " + tiempoEsperaMaximo);
    }
    
    private static int generarPrioridad() {
        return new Random().nextInt(5) + 1;
    }
    
    private static int generarTiempoEjecucion() {
        return new Random().nextInt(10) + 1;
    }
}
