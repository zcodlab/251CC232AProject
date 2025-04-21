package uni.aed.simplelinkedlist;

public class SimpleLinkedListMain {
    private static final int OUT_OF_LIMIT=-1;
    private static final int NOT_FOUND=-1;
    public static void main(String[] args){
        SimpleLinkedListMain listaMain=new SimpleLinkedListMain();
        listaMain.testSimpleLinkedList();
    }
    private void testSimpleLinkedList(){
        SimpleLinkedList lista=new SimpleLinkedList();
        lista.addLast(10);
        lista.addLast(20);
        lista.addLast(30);
        lista.addFirst(40);                
        System.out.println("Visualizando la Lista enlazada:");
        System.out.println(lista.toString());        
        System.out.println("La lista contiene: "+ lista.size()+" elementos");
        System.out.println("Añadiendo un elemento a la posicion 2:");
        int result=lista.addToPosition(2,50);
        if(result==OUT_OF_LIMIT)
            System.out.println("La posicion indicada es incorrecta");
        System.out.println("La lista contiene: "+ lista.size()+" elementos");
        System.out.println("Visualizando la Lista enlazada:");
        System.out.println(lista.toString());        
        System.out.println("Eliminando el elemento 20");    
        lista.remove(20);
        System.out.println("Buscando el elemento 20");    
        result=lista.search(20);
        if(result==NOT_FOUND)
            System.out.println("El elemento no se ubico en la lista");    
        else
            System.out.println("El elemento se ubico en la posicion "+ result);    
        
        System.out.println("Buscando el elemento 50");    
        result=lista.search(50);
        if(result==NOT_FOUND)
            System.out.println("El elemento no se ubico en la lista");    
        else
            System.out.println("El elemento se ubico en la posicion "+ result);    
        
        
        
    }
    
}
