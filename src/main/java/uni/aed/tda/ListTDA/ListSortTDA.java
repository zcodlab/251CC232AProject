package uni.aed.tda.ListTDA;
/*Solucion PC2:2*/
public interface ListSortTDA<E extends Comparable<E>> {
    void add(E elemento);                       // inserta en la posición correcta
    void clear();
    boolean contain(E elemento);
    E get(int index) throws IndexOutOfBoundsException;
    int indexOf(E elemento);
    boolean isEmpty();
    E delete(int index) throws IndexOutOfBoundsException;
    boolean delete(E elemento);
    int size();
    IteratorTDA<E> iterador();
}
