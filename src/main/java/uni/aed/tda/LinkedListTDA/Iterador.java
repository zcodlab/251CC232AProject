package uni.aed.tda.LinkedListTDA;

import uni.aed.tda.ListTDA.IteratorTDA;
import uni.aed.tda.ListTDA.NoSuchElementException;

public class Iterador<E> implements IteratorTDA<E> {
    private Nodo<E> actual;

    public Iterador(Nodo<E> actual) {
        this.actual = actual;
    }

    @Override
    public boolean hasNext() {        
        return actual!=null;
    }

    @Override
    public E next() throws NoSuchElementException {
        if(actual==null)
            throw new NoSuchElementException("No hay mas elementos");
        E data=actual.getData();
        actual=actual.getNext();
        return data;
    }
    
}
