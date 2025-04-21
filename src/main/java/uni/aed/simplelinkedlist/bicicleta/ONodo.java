package uni.aed.simplelinkedlist.bicicleta;

public class ONodo {
    private Object data;
    private ONodo next;

    public ONodo(Object data) {
        this.data = data;
        this.next = null;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(ONodo next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public ONodo getNext() {
        return next;
    }
    
    
}
