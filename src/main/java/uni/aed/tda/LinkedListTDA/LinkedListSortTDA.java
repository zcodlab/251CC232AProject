package uni.aed.tda.LinkedListTDA;

import uni.aed.tda.ListTDA.IteratorTDA;
import uni.aed.tda.ListTDA.ListSortTDA;

public class LinkedListSortTDA<E extends Comparable<E>> implements ListSortTDA<E> {
    private final LinkedListTDA<E> lista = new LinkedListTDA<>();

    @Override
    public void add(E elemento) {
        if (lista.contain(elemento))
            throw new IllegalArgumentException("Elemento repetido: " + elemento);
        int pos = 0;
        while (pos < lista.size() && lista.get(pos).compareTo(elemento) < 0) {
            pos++;
            System.out.println("pos:"+pos);
        }
        lista.add(pos, elemento);
    }

    @Override
    public void clear() {
        lista.clear();
    }

    @Override
    public boolean contain(E elemento) {
        return lista.contain(elemento);
    }

    @Override
    public E get(int index) {
        return lista.get(index);
    }

    @Override
    public int indexOf(E elemento) {
        return lista.indexOf(elemento);
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public E delete(int index) {
        return lista.delete(index);
    }

    @Override
    public boolean delete(E elemento) {
        return lista.delete(elemento);
    }

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public IteratorTDA<E> iterador() {
        return lista.iterador();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
