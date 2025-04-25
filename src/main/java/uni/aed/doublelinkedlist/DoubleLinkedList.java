package uni.aed.doublelinkedlist;
public class DoubleLinkedList {
    private DNodo head;//cabecera de lista
    private DNodo ultimo;//tambien cola, final
    private int lenght=0;
    
    //metodo para añadir elementos a la lista en la parte frontal
    public void addFirst(int data){
        DNodo newNodo=new DNodo(data);
        if(head==null){
            head=newNodo;
            ultimo=newNodo;
        }else{
            newNodo.setNext(head);
            head.setPrev(newNodo);
            head=newNodo;
        }
        lenght++;
    }
    public void addLast(int data){
        DNodo newNodo=new DNodo(data);
        if(ultimo==null){
            head=newNodo;
            ultimo=newNodo;
        }else{
            newNodo.setPrev(ultimo);
            ultimo.setNext(newNodo);
            ultimo=newNodo;
        }
        lenght++;        
    }
    public void remove(int data){
        DNodo current=head;
        //buscando el elemento a eliminar
        while(current!=null && current.getData()!=data)
            current=current.getNext();
        //verificamos si salio del bucle por que encontro la data
        if(current!=null){
            //verificamos si el nodo a eliminar esta en la parte frontal
            if(current==head){
                head=head.getNext();
                if(head!=null)
                    head.setPrev(null);
                else
                    ultimo=null;
            }else if(current==ultimo){//el nodo a eliminar esta la cola o final
                ultimo=current.getPrev();                
            }else{//el nodo a eliminar esta en el cuerpo de la lista
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
            }
            lenght--;
        }
    }
    public void clear(){
        head=null;
        ultimo=null;
        lenght=0;
    }
    
    public boolean isEmpty(){
        return (lenght==0);
    }
    
    public int size(){
        return lenght;
    }
    //para resolver el Cap16E24
    public DNodo getNodo(int pos){
        DNodo current=head;
        for(int i=0;i<pos;i++)
            current=current.getNext();
        return current;
    }
    
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        DNodo current=head;
        while(current!=null){
            if(!str.isEmpty())
                str.append("<->");
            str.append(current.getData());
            current=current.getNext();
        }
        return str.toString();
    }
    
}
