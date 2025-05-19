package uni.aed.tda.ListTDA;

import java.util.InputMismatchException;
import java.util.Scanner;
import uni.aed.tda.ArrayListTDA.ArrayListSortTDA;
import uni.aed.tda.LinkedListTDA.LinkedListSortTDA;
/*Solucion PC2:2*/
public class ListSortTDAMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        ListSortTDA<String> lista = null;
        int opcion;
        try{
            do {
                System.out.println("\n Menu de ordenacion ---");
                System.out.println("1. ArraySort");
                System.out.println("2. LinkedSort");
                System.out.println("3. Agregar");
                System.out.println("4. Verificar existencia");
                System.out.println("5. Obtener ubicación");
                System.out.println("6. Eliminar");
                System.out.println("7. Visualizar");
                System.out.println("8. Salir");
                System.out.print("Opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        lista = new ArrayListSortTDA<>();
                        System.out.println("Usando ArraySort");
                        break;
                    case 2:
                        lista = new LinkedListSortTDA<>();
                        System.out.println("→ Usando LinkedListSort1");
                        break;
                    case 3:
                        System.out.print("Elemento a agregar: ");
                        try {
                            lista.add(sc.nextLine());
                            System.out.println("Agregado.");
                        } catch (IllegalArgumentException ex) {
                            System.out.println("Error: " + ex.getMessage());
                        }
                        break;
                    case 4:
                        System.out.print("Existe elemento? ");
                        System.out.println(lista.contain(sc.nextLine()));
                        break;
                    case 5:
                        System.out.print("Elemento para ubicar: ");
                        System.out.println("Indice: " + lista.indexOf(sc.nextLine()));
                        break;
                    case 6:
                        System.out.print("Indice o valor a eliminar: ");
                        String target = sc.nextLine();
                        try {
                            int idx = Integer.parseInt(target);
                            System.out.println("Eliminado: " + lista.delete(idx));
                        } catch (NumberFormatException nfe) {
                            System.out.println("Eliminado: " + (lista.delete(target) ? "sí" : "no"));
                        }
                        break;
                    case 7:
                        System.out.println("Contenido: " + lista);
                        break;
                    case 8:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            } while (opcion != 8);
        }catch(InputMismatchException ex) {
            System.out.println("Debe ingresar obligatoriamente un número entero como opcion elegida.");
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }finally{         
            sc.close();
        }
    }
    
}
