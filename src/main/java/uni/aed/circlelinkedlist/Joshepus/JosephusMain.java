package uni.aed.circlelinkedlist.Joshepus;

import java.util.Scanner;
import uni.aed.circlelinkedlist.*;

/**
 *
 * Caso: Problema Josephus. (pag. 943 del Libro del autor C. Thomas Wu)
 */
public class JosephusMain {

    CircleLinkedList lista = new CircleLinkedList();
    int M=41;

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scan = new Scanner(System.in);
        JosephusMain josephus = new JosephusMain();
        while (!salir) {
            System.out.println("Inserte una opción del menú: ");
            System.out.println("a) Definir M ");
            System.out.println("b) Registrar estudiantes");
            System.out.println("c) Ordenar Estudiantes");
            System.out.println("d) remover cada N-esimo estudiantes");
            System.out.println("e) visualizar lista ");
            System.out.println("f) salir ");

            String opcion = scan.next();
            switch (opcion) {
                case "a" -> {
                    System.out.print("inserte el M: ");
                    int m = scan.nextInt();
                    josephus.definirM(m);
                }
                case "b" ->
                    josephus.registrar();
                case "c" ->
                    josephus.ordenar();
                case "d" -> {
                    System.out.print("inserte el N: ");
                    int n = scan.nextInt();
                    josephus.remover(n);
                    
                }
                case "e" ->
                    josephus.visualizar();
                case "f" ->
                    salir = true;
            }
        }
    }

    private void definirM(int m) {
        M = m;
    }

    private void registrar() {
        for (int i = 0; i < M; i++) {
            int estudiante=random(1, M);
            if(!lista.search(estudiante))
                lista.addLast(estudiante);
            else
                i--;
        }
    }

    private void ordenar() {
        System.out.println("Logica aun no implementada");        
    }

    private void remover(int n) {
        System.out.println("Removiendo cada N elementos de la lista");
        System.out.println("El sobreviviente es: " + lista.remover(n));        
    }

    private void visualizar() {
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());
    }
    private int random(int low, int high) {
        return (int) Math.floor(Math.random() * (high - low + 1)) + low;
    }
}
