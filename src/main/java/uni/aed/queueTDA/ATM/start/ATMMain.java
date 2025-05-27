package uni.aed.queueTDA.ATM.start;
import java.util.Scanner;

public class ATMMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el número de minutos a simular (M): ");
        int M = scanner.nextInt();

        System.out.println("Ingrese la probabilidad de que llegue un cliente cada minuto (P): ");
        double P = scanner.nextDouble();

        System.out.println("Ingrese el número de cajeros automáticos (N): ");
        int N = scanner.nextInt();
        
        SimuladorATM simulador = new SimuladorATM(M, P, N);

        System.out.println("\nSeleccione la opción de manejo de clientes restantes:");
        System.out.println("1. Atender todos los clientes inmediatamente.");
        System.out.println("2. Continuar el ciclo hasta que todas las colas estén vacías.");
        int opcion = scanner.nextInt();
        
        if (opcion == 1) {
            simulador.simular();  
        } else if (opcion == 2) {
            simulador.simular(); 
        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}
