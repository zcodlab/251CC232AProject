package uni.aed.treeTDA.softwarestore;

import uni.aed.model.Software;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import uni.aed.queueTDA.LinkedQueueTDA;
import uni.aed.queueTDA.QueueTDA;

public class SoftwareStore {
    public static final int NOT_FOUND=-1;
    private Node<Software> root;
    private String filename;    

    public SoftwareStore(String filename) {
        this.root=null;
        this.filename = filename;
        readFromFile();
    }
    private void readFromFile(){
        try(Scanner scr=new Scanner(new File(filename))){
            int position=0;
            while(scr.hasNextLine()){
                String line=scr.nextLine();
                String[] parts=line.split("\\s+");
                if(parts.length!=4)
                    continue;
                String name=parts[0];
                String version=parts[1].toString();
                int quantity=Integer.parseInt(parts[2]);
                int price=Integer.parseInt(parts[3]);
                Node<Software> newNode= new Node<>(new Software(name, version, quantity, price),position);
                root=insert(root,newNode);                
                position++;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    private Node<Software> insert(Node<Software> root,Node<Software> newNode){
        if(root==null)
            return newNode;
        int compareResult=newNode.getKey().getName().compareTo(root.getKey().getName());
        if(compareResult<0)
            root.setLeft(insert(root.getLeft(),newNode));
        else if(compareResult>0)
            root.setRight(insert(root.getRight(),newNode));
        else//se trataria del mismo producto por lo que solo corresponde incrementar la cantidad producto
            root.getKey().setQuantity(root.getKey().getQuantity() + newNode.getKey().getQuantity());            
        return root;
    }
    public void addSoftware(String name, String version, int quantity, int price) {
        Node<Software> newNode = new Node<>(new Software(name, version, quantity, price), -1);
        root = insert(root, newNode); //Inserta o suma la cantidad de software
        updateFile(); //Actualiza archivo .txt
    }
    
    public void sellSoftware(String name,String version,int quantitySold){
        Node<Software> node=findNode(root,name,version);
        if(node!=null){
            node.getKey().setQuantity(node.getKey().getQuantity() - quantitySold);               
            updateFile();
            if(node.getKey().getQuantity()<=0)
                deleteMerge(name,version);
        }
    }
    public void breadthFirst(StringBuilder str) {
        Node<Software> p = root;
        QueueTDA<Node<Software>> queue = new LinkedQueueTDA<>();
        if (p != null) {
            queue.enqueue(p);
            while (!queue.isEmpty()) {
                p = queue.dequeue();
                visit(p,str);
                if (p.getLeft() != null) {
                    queue.enqueue(p.getLeft());
                }
                if (p.getRight() != null) {
                    queue.enqueue(p.getRight());
                }
            }
        }
    }
    
    private void visit(Node<Software> p,StringBuilder str) {        
        if(p==null){
            str.append(NOT_FOUND);
            return;
        }
        if (!str.isEmpty()) 
            str.append(" ");  
        str.append(p.getKey()); 
    }
    
    private Node<Software> findNode(Node<Software> root,String name,String version){
        if(root==null || (root.getKey().getName().equals(name) &&
                root.getKey().getVersion().equals(version)))
            return root;
        
        int compareResult=(name+version).compareTo(
                root.getKey().getName()+root.getKey().getVersion());
        if(compareResult<0)
            return findNode(root.getLeft(),name,version);
        else
            return findNode(root.getRight(),name,version);
    }
    
    private void deleteMerge(String name, String version) {
        Node<Software> tmp, node, p = root, prev = null;
        int compareResult = (name + version).compareTo(p.getKey().getName() + p.getKey().getVersion());
        while (p != null && compareResult != 0) {
            prev = p;
            if (compareResult < 0) {
                p = p.getRight();
            } else {
                p = p.getLeft();
            }
        }
        node = p;
        if (p != null && compareResult == 0) {
            if (node.getRight() == null) {
                node = node.getLeft();
            } else if (node.getLeft() == null) {
                node = node.getRight();
            } else {
                tmp = node.getLeft();
                while (tmp.getRight() != null)
                    tmp = tmp.getRight();                
                tmp.setRight(node.getRight());
                node = node.getLeft();
            }
        }
        if (p == root)
            root = node;        
    }
     private void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            inorderWriteToFile(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inorderWriteToFile(Node<Software> root, BufferedWriter writer) throws IOException {
        if (root != null) {
            inorderWriteToFile(root.getLeft(), writer);
            writer.write(root.getKey().getName() + " " + root.getKey().getVersion() + " " + root.getKey().getQuantity() + " " + root.getKey().getPrice());
            writer.newLine();
            inorderWriteToFile(root.getRight(), writer);
        }
    }
    
    public String inventarioSoftware() {
        StringBuilder buffer = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(filename))) {
            buffer.append(String.format("%-30s %-15s %-10s %-10s%n", "Nombre", "Versión", "Cantidad", "Precio"));
            buffer.append("--------------------------------------------------------------------------------\n");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.trim().split("\\s+"); // divide por cualquier espacio

                if (parts.length >= 4) {
                    String name = parts[0];
                    String version = parts[1];
                    String quantity = parts[2];
                    String price = parts[3];

                    buffer.append(String.format("%-30s %-15s %-10s %-10s%n", name, version, quantity, price));
                }
            }

            buffer.append("--------------------------------------------------------------------------------\n");

            } catch (FileNotFoundException e) {
                buffer.append("No se pudo encontrar el archivo: ").append(filename).append("\n");
            }

        return buffer.toString();
    }

    public void cleanUpFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)); BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".tmp"))) {

            String line;
            int position = 0;
            List<String> lines = new LinkedList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            boolean stock = false;
            while (position < lines.size()) {
                line = lines.get(position);
                String[] parts = line.split("\\s+");
                int quantity = Integer.parseInt(parts[2]);
                if (quantity == 0) {
                    while (position < lines.size() && !stock) {
                        String lineLast = lines.get(lines.size() - 1);
                        String[] partsLast = lineLast.split("\\s+");
                        int quantityLast = Integer.parseInt(partsLast[2]);
                        if (quantityLast > 0) {
                            stock = true;
                            lines.set(position, lineLast);
                        }
                        lines.remove(lines.size() - 1);
                    }
                }
                position++;
            }
            for (String fline : lines) {
                String[] parts = fline.split("\\s+");
                String name = parts[0];
                String version = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                if (quantity > 0) {
                    writer.write(name + " " + version + " " + quantity + " " + price);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File originalFile = new File(filename);
        if (originalFile.delete()) {
            File tempFile = new File(filename + ".tmp");
            if (tempFile.renameTo(originalFile)) {
                System.out.println("Archivo limpiado y actualizado correctamente.");
            } else {
                System.out.println("Error al renombrar el archivo temporal.");
            }
        } else {
            System.out.println("Error al borrar el archivo original.");
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }
    
    
}
