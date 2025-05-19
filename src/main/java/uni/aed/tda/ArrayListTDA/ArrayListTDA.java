package uni.aed.tda.ArrayListTDA;

import uni.aed.tda.ListTDA.IteratorTDA;
import uni.aed.tda.ListTDA.ListTDA;

public class ArrayListTDA<E> implements ListTDA<E> {
    public static final int TAMANIO_DEFINIDO=25;
    public static final int NO_ENCONTRADO=-1;
    private E[] data;
    private int count;
    public ArrayListTDA() {
        this(TAMANIO_DEFINIDO);
    }
    public ArrayListTDA(int size) {
        if(size<=0)
            throw new IllegalArgumentException("Tamaño de la Lista debe ser mayor a ceo");
        data=(E[])new Object[size];
        count=0;            
    }
    @Override
    public void add(E elemento){
        if(count==data.length)
            expande();
        data[count]=elemento;
        count++;
    }
    @Override
    public void add(int index, E elemento) throws IndexOutOfBoundsException{
        revisaPosInsercion(index);
        if (count==data.length)
            expande();
        //hacer un espacio a la derecha
        for(int i=count;i>index;i--)
            data[i]=data[i-1];
        data[index]=elemento;
        count++;
    }
    @Override
    public void clear(){
        for(int i=0;i<count;i++)
            data[i]=null;
        count=0;
    }
    @Override
    public boolean contain(E elemento){
        boolean resultado=true;
        int index=indexOf(elemento);
        if(index==NO_ENCONTRADO)
            resultado=false;
        return resultado;        
    }
    @Override
    public E get(int index)throws IndexOutOfBoundsException{
        revisaPosAcceso(index);
        return data[index];
    }
    @Override
    public int indexOf(E elemento){
        int index=0;
        while(index<count && !data[index].equals(elemento)){
            index++;
        }
        if (index==count)
            index=NO_ENCONTRADO;
        return index;
    }
    @Override
    public boolean isEmpty(){
        return(count==0);
    }
    @Override
    public E delete(int index)throws IndexOutOfBoundsException{
        revisaPosAcceso(index);
        E elemento=data[index];
        for(int i=index;i<count;i++)
            data[i]=data[i+1];
        data[count]=null;
        count--;
        return elemento;
    }
    @Override
    public boolean delete(E elemento){
        int index=indexOf(elemento);
        if(index==NO_ENCONTRADO)
            return false;
        else{
            delete(index);
            return true;
        }
    }
    @Override
    public E modify(int index, E elemento)throws IndexOutOfBoundsException{
        revisaPosAcceso(index);
        E previo=data[index];
        data[index]=elemento;
        return previo;        
    }
    @Override
    public int size(){
        return count;
    }    
    private void revisaPosAcceso(int index){
        if(size()==0)
            throw new IndexOutOfBoundsException("Indice "+index+ " es invalido. Lista vacia");
        else if(index<0){
            throw new IndexOutOfBoundsException("Indice negativo de "+index+ " es invalido");
        }else if(index>size()-1)
            throw new IndexOutOfBoundsException("Indice es mayor que limite superior valido "+ (size()-1) );
    }
    private void revisaPosInsercion(int index){
        if(index<0)
            throw new IndexOutOfBoundsException("Indice negativo de "+ index+ " es invalido" );
        else if(index>size())
            throw new IndexOutOfBoundsException(index + " es mayor que limite superior valido "+ size() );
    }
    private void expande(){
        int newLength=(int)(1.5*data.length);
        E[] temp=(E[]) new Object[newLength];
        for(int i=0;i<data.length;i++)
            temp[i]=data[i];
        data=temp;
    }    
    
    @Override
    public IteratorTDA<E> iterador(){
        return new Iterador<>(this);
    }
            
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        IteratorTDA<E> it= this.iterador();
        while(it.hasNext()){
            if(!str.isEmpty())
                str.append(",");
            str.append(it.next().toString());                        
        }
        return str.toString();
    }

    @Override
    public Object[] toArray() {        
        IteratorTDA<E> it= this.iterador();
        Object[] newArray= new Object[size()];
        
        int i=0;
        while(it.hasNext())
            newArray[i++]= (Object)it.next();
        
        return newArray;
    }

    @Override
    public String toString(String patron) {
        StringBuilder str=new StringBuilder();
        IteratorTDA<E> it= this.iterador();
        while(it.hasNext()){
            if(!str.isEmpty())
                str.append(patron);
            str.append(it.next().toString());                        
        }
        return str.toString();
    }

    @Override
    public void delete(int indexIni, int indexFin) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //2PC
    @Override
    public ListTDA<E> union(ListTDA<E> l1, ListTDA<E> l2) {
        IteratorTDA<E> it1 = l1.iterador();
        IteratorTDA<E> it2 = l2.iterador();
        ListTDA<E> result = new ArrayListTDA<E>();
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
        ListTDA<E> result = new ArrayListTDA<>();

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
        ListTDA<E> result = new ArrayListTDA<>();

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
