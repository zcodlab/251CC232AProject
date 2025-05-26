package uni.aed.queueTDA;

import uni.aed.tda.LinkedListTDA.Nodo;

public class LinkedQueueTDA<E> implements QueueTDA<E> {
    private Nodo<E> front;
    private Nodo<E> back;
    private int count;

    public LinkedQueueTDA() {
        clear();
    }

    @Override
    public void enqueue(E data) {//equivalente a un addLast en listas enlazadas
        Nodo newNodo=new Nodo(data);
        if(isEmpty())
            front=back=newNodo;
        back.setNext(newNodo);
        back=newNodo;
        count++;
    }

    @Override
    public E dequeue() throws QueueEmptyExceptionTDA {        
        if(isEmpty())
            throw new QueueEmptyExceptionTDA();
        E item=front.getData();
        front=front.getNext();
        count--;
        return item;        
    }

    @Override
    public E peek() throws QueueEmptyExceptionTDA {
        if(isEmpty())
            throw new QueueEmptyExceptionTDA();
        return front.getData();
    }

    @Override
    public void clear() {
        front=back=null;
        count=0;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        Nodo current=front;
        while(current!=null){
            if(!str.isEmpty())
                str.append("<-");
            str.append(current.getData().toString());
            current=current.getNext();
        }
        return str.toString();
    }
    
}
