package uni.aed.simplelinkedlist.bicicleta;

public class OSimpleLinkedList {
    private static final int OUT_OF_LIMIT=-1;
    private static final int NOT_FOUND=-1;
    private static final int EXITO=1;   
    private ONodo head;
    private int lenght=0;
    
    public void addFirst(Object data){
        ONodo newNodo=new ONodo(data);
        newNodo.setNext(head);
        head=newNodo;
        lenght++;        
    }
    public void addLast(Object data){
        ONodo newNodo=new ONodo(data);
        if(head==null){
            head=newNodo;
            lenght++;
            return;
        }
        ONodo current=head;
        while(current.getNext()!=null)
            current=current.getNext();
        current.setNext(newNodo);
        lenght++;
    }
    
    public int search(Object data){
        ONodo current=head;
        boolean isFound=false;
        int index=0;
        while(current!=null && isFound==false){
            if(((Comparable)current.getData()).compareTo(data)==0)
                isFound=true;
            else{
                current=current.getNext();
                index++;
            }
        }
        if(isFound==true)
            return index;
        else
            return NOT_FOUND;        
    }
    
    public void remove(Object data){
        if(head==null)
            return;
        //si el elemento a eliminar es el primer nodo
        if(((Comparable)head.getData()).compareTo(data)==0){
            head=head.getNext();
            lenght--;
            return;        
        }
        //si el elemento a eliminar no es el primer nodo
        ONodo current=head;
        while(current.getNext()!=null
                && ((Comparable)current.getNext().getData()).compareTo(data)!=0)
            current=current.getNext();
        
        if(current.getNext()!=null){
            current.setNext(current.getNext().getNext());
            lenght--;
        }
            
    }
    
    public void clear(){
        head=null;
        lenght=0;
    }
    
    public boolean isEmpty(){
        return (lenght==0);
    }
    
    public int size(){
        return lenght;
    }
    
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        ONodo current=head;
        while(current!=null){
            if(!str.isEmpty())
                str.append("->");
            str.append(current.getData().toString());
            current=current.getNext();
        }
        return str.toString();
    }
}
