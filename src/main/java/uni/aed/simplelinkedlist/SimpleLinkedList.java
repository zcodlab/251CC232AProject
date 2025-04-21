package uni.aed.simplelinkedlist;
public class SimpleLinkedList {
    private static final int OUT_OF_LIMIT=-1;
    private static final int NOT_FOUND=-1;
    private static final int EXITO=1;    
    private Nodo head;
    private int lenght=0;
    
    public void addFirst(int data){
        Nodo newNodo=new Nodo(data);
        newNodo.setNext(head);
        head=newNodo;
        lenght++;        
    }
    public int addToPosition(int position,int data){
        Nodo newNodo=new Nodo(data);
        Nodo current;
        int index=0;
        if(position<0 || position>lenght)
            return OUT_OF_LIMIT;
        if(position==0)
            addFirst(newNodo.getData());
        else{
            current=head;
            while(index<position-1){
                current=current.getNext();
                index++;
            }
            newNodo.setNext(current.getNext());
            current.setNext(newNodo);
            lenght++;
        }
        return EXITO;
    }
    public void addLast(int data){
        Nodo newNodo=new Nodo(data);
        if(head==null){
            head=newNodo;
            lenght++;
            return;
        }
        Nodo current=head;
        while(current.getNext()!=null)
            current=current.getNext();
        current.setNext(newNodo);
        lenght++;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        Nodo current=head;
        while(current!=null){
            if(!str.isEmpty())
                str.append("->");
            str.append(current.getData());
            current=current.getNext();
        }
        return str.toString();
    }
    
    
    
}
