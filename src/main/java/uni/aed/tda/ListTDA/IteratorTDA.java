package uni.aed.tda.ListTDA;

public interface IteratorTDA<E> {
    public boolean hasNext();
    public E next() throws NoSuchElementException;    
}
