package uni.aed.simplelinkedlist;

public class Nodo {
    private int data;
    private Nodo next;
    
    public Nodo(int data) {
        this.data = data;
        this.next = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Nodo getNext() {
        return next;
    }
    
}
