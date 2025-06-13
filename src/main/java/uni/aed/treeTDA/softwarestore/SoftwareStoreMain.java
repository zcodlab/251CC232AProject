package uni.aed.treeTDA.softwarestore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SoftwareStoreMain {
    SoftwareStore softwareStore = new SoftwareStore("src/main/java/uni/aed/treeTDA/softwarestore/software.txt");                                                                
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    StringBuilder str=new StringBuilder();
    
    public static void main(String[] args) {
          SoftwareStoreMain sw=new SoftwareStoreMain();
          sw.menu();
    }
    
    private void menu() {        
        int choice;
        try{
            do {
                System.out.println("TIENDA DE SOFTWARE");
                System.out.println("1. Vender Software");
                System.out.println("2. Agregar Software");
                System.out.println("3. Ver Inventario");
                System.out.println("4. Salir");
                System.out.println("Ingrese la opcion: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter software name: ");
                        String name = scanner.next();

                        System.out.println("Enter software version: ");
                        String version = scanner.next();

                        System.out.println("Enter quantity sold: ");
                        int quantitySold = scanner.nextInt();

                        softwareStore.sellSoftware(name, version, quantitySold);
                        break;
                    case 2:                    
                        System.out.println("Enter software name: ");
                        name = scanner.next();

                        System.out.println("Enter software version: ");
                        version = scanner.next();

                        System.out.println("Enter quantity to sold: ");
                        quantitySold = scanner.nextInt();

                        System.out.println("Enter price: ");
                        int price = scanner.nextInt();

                        softwareStore.addSoftware(name, version, quantitySold, price);
                        break;
                    case 3:
                        System.out.println(softwareStore.inventarioSoftware());
                        System.out.println("Visualizando el inventario en formato arbol BST");
                        System.out.println(softwareStore.toString());
                        
                        System.out.println("Recorrido breadthFirst");
                        softwareStore.breadthFirst(str);
                        System.out.println(str.toString());
                        break;
                    case 4:
                        System.out.println("Saliendo del Programa.");
                        break;
                    default:
                        System.out.println("Opcion Invalida. Elija una opcion valida[1-3].");
                        break;
                }
            } while (choice != 4);
            scanner.close();
            softwareStore.cleanUpFile();
        }catch(InputMismatchException ex) {
            System.out.println("Debe ingresar obligatoriamente un número entero como opcion elegida.");
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }  
    }
}
