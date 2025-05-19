package uni.aed.tda.listTDA;

public interface IteratorTDA<E> {
    public boolean hasNext();
    public E next() throws NoSuchElementException;    
}
