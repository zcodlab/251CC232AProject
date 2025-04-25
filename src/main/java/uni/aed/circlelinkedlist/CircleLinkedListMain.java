package uni.aed.circlelinkedlist;
public class CircleLinkedListMain {
    public static void main(String[] args){
        CircleLinkedListMain lista=new CircleLinkedListMain();
        lista.testCircleLinkedList();
    }
    private void testCircleLinkedList(){
        CircleLinkedList lista=new CircleLinkedList();
        lista.addLast(10);
        lista.addLast(20);
        lista.addLast(30);
        lista.addLast(40);
        
        System.out.println("La lista contiene: "+ lista.size()+" elementos");
        System.out.println("Visualizando la Lista enlazada:");
        System.out.println(lista.toString()); 
        
        System.out.println("Eliminando el elemento 20:");
        lista.remove(20);
        
        System.out.println("La lista contiene: "+ lista.size()+" elementos");
        System.out.println("Visualizando la Lista enlazada:");
        System.out.println(lista.toString()); 
        
        System.out.println("Buscando el elemento 20:");
        if(!lista.search(20))
            System.out.println("El elemento no se ubico en la lista");
        else
            System.out.println("El elemento se ubico en la lista");
        
        System.out.println("La lista contiene: "+ lista.size()+" elementos");
        System.out.println("Visualizando la Lista enlazada:");
        System.out.println(lista.toString()); 
        
    }
}
