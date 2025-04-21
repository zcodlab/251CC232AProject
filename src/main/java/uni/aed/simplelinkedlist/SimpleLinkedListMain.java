package uni.aed.simplelinkedlist;

public class SimpleLinkedListMain {
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
    }
    
}
