package uni.aed.tda.ArrayListTDA;

import uni.aed.tda.ListTDA.IteratorTDA;
import uni.aed.tda.ListTDA.ListTDA;
import uni.aed.tda.ListTDA.NoSuchElementException;

public class Iterador<E> implements IteratorTDA<E>{
    private final ListTDA<E> arrayList;
    private int currentIndex=0;

    public Iterador(ListTDA<E> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        return currentIndex<arrayList.size();
    }

    @Override
    public E next() throws NoSuchElementException {
        if(!hasNext())
            throw new NoSuchElementException("No hay mas elementos en la coleccion");
        return arrayList.get(currentIndex++);
    }
    
}
