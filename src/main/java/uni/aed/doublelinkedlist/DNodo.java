package uni.aed.doublelinkedlist;
public class DNodo {
    private int data;
    private DNodo next;//apuntador al nodo siguiente
    private DNodo prev;//apuntador al nodo anterior o nodo previo

    public DNodo(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(DNodo next) {
        this.next = next;
    }

    public void setPrev(DNodo prev) {
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public DNodo getNext() {
        return next;
    }

    public DNodo getPrev() {
        return prev;
    }

    @Override
    public String toString() {
        return "DNodo{" + "data=" + data + ", next=" + next + ", prev=" + prev + '}';
    }
    
    
    
    
}
