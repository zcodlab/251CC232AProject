package uni.aed.tda.listTDA;

public interface ListTDA<E>{
    public void add(E elemento);
    public void add(int index,E elemento) throws IndexOutOfBoundsException;
    public void clear();
    public boolean contain(E elemento);
    public E get(int index) throws IndexOutOfBoundsException;
    public int indexOf(E elemento);
    public boolean isEmpty();
    public E delete(int index) throws IndexOutOfBoundsException;
    public boolean delete(E elemento);
    public E modify(int index,E elemento) throws IndexOutOfBoundsException;
    public int size();
    public Object[] toArray();
    public String toString(String patron);    
    public IteratorTDA<E> iterador();
    public void delete(int indexIni,int indexFin) throws IndexOutOfBoundsException;    
    /*Solucion PC2:1*/    
    public ListTDA<E> union (ListTDA<E> l1, ListTDA<E> l2);
    public ListTDA<E> interseccion (ListTDA<E> l1, ListTDA<E> l2);
    public ListTDA<E> diferencia (ListTDA<E> l1, ListTDA<E> l2);
}
