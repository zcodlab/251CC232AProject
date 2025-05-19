package uni.aed.stackTDA;

import uni.aed.tda.linkedlistTDA.Nodo;

public class LinkedStackTDA<E> implements StackTDA<E> {
    private Nodo<E> topPila;
    private int count;

    public LinkedStackTDA() {
        clear();
    }

    @Override
    public void push(E elemento) {
        Nodo newTope=new Nodo(elemento);
        newTope.setNext(topPila);
        topPila=newTope;
        count++;
        
    }

    @Override
    public E pop() throws StackEmptyExceptionTDA {
        if(isEmpty())
            throw new StackEmptyExceptionTDA();
        E temp=topPila.getData();
        topPila=topPila.getNext();
        count--;
        return temp;        
    }

    @Override
    public E peek() throws StackEmptyExceptionTDA {
        if(isEmpty())
            throw new StackEmptyExceptionTDA();
        return topPila.getData();
    }

    @Override
    public void clear() {
        topPila=null;
        count=0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        Nodo<E> current=topPila;
        while(current!=null){
            if(!str.isEmpty())
                str.append("<-");
            str.append(current.getData().toString());
            current=current.getNext();
        }
        return str.toString();
    }
    
}
