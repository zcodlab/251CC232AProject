package uni.aed.tda.LinkedListTDA;

import uni.aed.tda.ListTDA.IteratorTDA;
import uni.aed.tda.ListTDA.ListTDA;

public class LinkedListTDA<E> implements ListTDA<E> {
    public static final int NO_ENCONTRADO=-1;
    private Nodo<E> head;
    private Nodo<E> cola;
    private int count;

    public LinkedListTDA() {
        clear();
    }

    @Override
    public void add(E data) {
        Nodo<E> newNodo=new Nodo<>(data);
        if(count==0)
            head=cola=newNodo;
        else{
            cola.setNext(newNodo);
            cola=newNodo;
        }
        count++;
    }

    @Override
    public void add(int index, E data) throws IndexOutOfBoundsException {        
        Nodo<E> apt=head;
        Nodo<E> nodo= new Nodo(data);
        if(index==0){
            nodo.setNext(head);
            head=nodo;
        }else{
            for(int i=1;i<index;i++)
                apt=apt.getNext();
            nodo.setNext(apt.getNext());
            apt.setNext(nodo);
        }
        if(index==count)
            cola=nodo;
        count++;
    }
    
    protected void revisaPosInsercion(int index) throws IndexOutOfBoundsException {
        if(index<0)
            throw new IndexOutOfBoundsException("Indice ingresado es invalido");
        else if(index>size())
            throw new IndexOutOfBoundsException("Indice es mayor al tamaño de la lista");            
    }
    private void revisaPosAcceso(int index) throws IndexOutOfBoundsException {
        if(size()==0)
            throw new IndexOutOfBoundsException("Indice "+ index+" es invalido. Lista vacia");
        else if(index<0)
            throw new IndexOutOfBoundsException("Indice negativo de "+ index+" es invalido.");
        else if(index>size())
            throw new IndexOutOfBoundsException("Indice "+ index+ " es mayor que limite superior valido "+ size());        
    }
            

    @Override
    public void clear() {
        head=null;
        cola=null;
        count=0;
    }

    @Override
    public boolean contain(E data) {
        boolean resultado=true;
        int index=indexOf(data);
        if(index==NO_ENCONTRADO)
            resultado=false;
        return resultado;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        E data=null;
        Nodo<E> apt=head;
        for(int i=0;i<index;i++)
            apt=apt.getNext();
        data=apt.getData();
        return data;
    }

    @Override
    public int indexOf(E data) {
        int index=0;
        Nodo<E> apt=head;
        while(index<count && !apt.getData().equals(data)){
            index++;
            apt=apt.getNext();
        }
        if(index==count)
            index=NO_ENCONTRADO;
        return index;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public E delete(int index) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        Nodo<E> nodoDelete;
        Nodo<E> apt=head;        
        if(index==0){
            nodoDelete=apt;
            head=head.getNext();
            if(head==null)
                cola=null;            
        }
        else{
            for(int i=1;i<index;i++)
                apt=apt.getNext();
            nodoDelete=apt.getNext();
            apt.setNext(nodoDelete.getNext());
            if(apt.getNext()==null)
                cola=apt;
        }
        count--;        
        return nodoDelete.getData();
    }

    @Override
    public boolean delete(E data) {
        boolean resultado=false;
        Nodo<E> apt=head;
        Nodo<E> huella=null;
        while(apt!=null && !apt.getData().equals(data)){
            huella=apt;
            apt=apt.getNext();
        }
        if(apt!=null){
            if(huella==null){
                head=head.getNext();
                if(head==null)
                    cola=null;
            }else{
                huella.setNext(apt.getNext());
                if(huella.getNext()==null)
                    cola=huella;
            }
        count--;
        resultado=true;        
        }
        return resultado;
    }

    @Override
    public E modify(int index, E data) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        Nodo<E> apt=head;
        for(int i=0;i<index;i++)
            apt=apt.getNext();
        E anterior=apt.getData();
        apt.setData(data);
        return anterior;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Object[] toArray() {
        //IteratorTDA it=new Iterador(head);
        IteratorTDA<E> it=iterador();
        Object[] newArray= new Object[size()];
        
        int i=0;
        while(it.hasNext())
            newArray[i++]= (Object)it.next();
        
        return newArray;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        //IteratorTDA<E> it=new Iterador<>(head);
        IteratorTDA<E> it=iterador();
        while(it.hasNext()){
            if(!str.isEmpty())
                str.append("->");
            str.append(it.next().toString());                        
        }
        return str.toString();
    }
    
    @Override
    public String toString(String patron) {
        StringBuilder str=new StringBuilder();
        //IteratorTDA<E> it=new Iterador<>(head);
        IteratorTDA<E> it=iterador();
        while(it.hasNext()){
            if(!str.isEmpty())
                str.append(patron);
            str.append(it.next().toString());                        
        }
        return str.toString();
    }
    
    @Override
    public IteratorTDA<E> iterador(){
        return new Iterador(head);
    }
    private void revisaPosAcceso(int indexIni, int indexFin) throws IndexOutOfBoundsException {
        if(size()==0)
            throw new IndexOutOfBoundsException("Lista vacia");
        else if(indexFin<indexIni)
            throw new IndexOutOfBoundsException("El primer indice debe ser menor que el segundo ("+ indexIni+","+indexFin+").");
        else if(indexIni<0 || indexFin<0)
            throw new IndexOutOfBoundsException("Indice negativo ("+ indexIni+","+indexFin+") es invalido.");
        else if(indexIni>size() || indexFin>size())
            throw new IndexOutOfBoundsException("Indice ("+ indexIni+","+indexFin+") es mayor que limite superior valido "+ size());        
    }

    @Override
    public void delete(int indexIni, int indexFin) throws IndexOutOfBoundsException {
        revisaPosAcceso(indexIni,indexFin);                
        Nodo<E> nodoIni=head;          
        for(int i=0;i<indexIni-1;i++){
            if (nodoIni.getNext() == null) break;
            nodoIni=nodoIni.getNext();
        }
        
        Nodo<E> nodoFin=nodoIni;  
        for(int i=indexIni;i<=indexFin;i++){
            if (nodoFin.getNext() == null) break;
            nodoFin=nodoFin.getNext();
            count--;        
        }
        // Saltarse los nodos del rango
        nodoIni.setNext(nodoFin.getNext()); 
        if(nodoFin.getNext()==null)
            cola=nodoFin;
    }    

    @Override
    public ListTDA<E> union(ListTDA<E> l1, ListTDA<E> l2) {
        IteratorTDA<E> it1 = l1.iterador();
        IteratorTDA<E> it2 = l2.iterador();
        ListTDA<E> result = new LinkedListTDA<>();
        while(it1.hasNext()){
            E temp = it1.next();
            if(!isIn(result,temp)){
                result.add(temp);
            }
        }
        while (it2.hasNext()){
            E temp = it2.next();
            if(!isIn(result,temp)){
                result.add(temp);
            }
        }

        return result;
    }

    @Override
    public ListTDA<E> interseccion(ListTDA<E> l1, ListTDA<E> l2) {
        IteratorTDA<E> it1 = l1.iterador();
        ListTDA<E> result = new LinkedListTDA<>();

        while(it1.hasNext()){
            E temp = it1.next();
            if(isIn(l2,temp) && !isIn(result,temp)){
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public ListTDA<E> diferencia(ListTDA<E> l1, ListTDA<E> l2) {
        IteratorTDA<E> it1 = l1.iterador();
        ListTDA<E> result = new LinkedListTDA<>();

        while(it1.hasNext()){
            E temp = it1.next();
            if(!isIn(l2,temp) && !isIn(result,temp)){
                result.add(temp);
            }
        }
        return result;
    }

    private boolean isIn(ListTDA<E> l, E value){
        IteratorTDA<E> it = l.iterador();
        while (it.hasNext()){
            if(it.next().equals(value)){
                return true;
            }
        }
        return false;
    }
   
}
