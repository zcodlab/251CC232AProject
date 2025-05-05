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
        if (size<=0)
            throw new IllegalArgumentException("tamaño de la lista debe ser mayor a cero");
        data=(E[])new Object[size];
        count=0;
    }

    @Override
    public void add(E elemento) {
        if(count==data.length)
            expande();
        data[count]=elemento;
        count++;
    }
    
    private void expande(){
        int newLength=(int)(1.5*data.length);
        E[] temp=(E[])new Object[newLength];
        for(int i=0;i< data.length;i++)
            temp[i]=data[i];
        data=temp;
    }    

    @Override
    public void add(int index, E elemento) throws IndexOutOfBoundsException {
        revisaPosInsercion(index);
        if(count==data.length)
            expande();
        for(int i=count;i>index;i--)
            data[i]=data[i-1];
        data[index]=elemento;
        count++;
    }
    
    protected void revisaPosInsercion(int index){
        if(index<0)
            throw new IndexOutOfBoundsException("Indice ingresado es invalido");
        else if (index>size())
            throw new IndexOutOfBoundsException("Indice es mayor al tamaño de la lsita");
    }

    @Override
    public void clear() {
        for(int i=0;i<count;i++)
            data[i]=null;
        count=0;
    }

    @Override
    public boolean contain(E elemento) {
        boolean resultado=true;
        int index=indexOf(elemento);
        if(index==NO_ENCONTRADO)
            resultado=false;
        return resultado;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        return data[index];
    }
    
    private void revisaPosAcceso(int index){
        if(size()==0)
            throw new IndexOutOfBoundsException("Indice "+ index+" es invalido, Lista vacia");        
        else if(index<0)
            throw new IndexOutOfBoundsException("Indice negativo "+ index+" es invalido");
        else if(index> size())
            throw new IndexOutOfBoundsException("Indice "+ index+" es mayor al tamaño de lista " + size());
    }    

    @Override
    public int indexOf(E elemento) {
        int index=0;
        while(index<count && !data[index].equals(elemento))
            index++;
        if(index==count)
            index=NO_ENCONTRADO;
        return index;
    }

    @Override
    public boolean isEmpty() {
        return (count==0);
    }

    @Override
    public E delete(int index) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        E elemento=data[index];
        for(int i=index;i<count;i++)
            data[i]=data[i+1];
        data[count]=null;
        count--;
        return elemento;
    }

    @Override
    public boolean delete(E elemento) {
        int index=indexOf(elemento);
        if(index==NO_ENCONTRADO)
            return false;
        else{
            delete(index);
            return true;
        }       
    }

    @Override
    public E modify(int index, E elemento) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        E previo=data[index];
        data[index]=elemento;
        return previo;//retonamos la data modificada o data antigua
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public IteratorTDA<E> iterador() {
        return new Iterador<>(this);
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        IteratorTDA<E> it=iterador();//obtiene la instacia de Iterador
        while(it.hasNext()){
            if(!str.isEmpty())
                str.append(",");
            str.append(it.next().toString());            
        }
        return str.toString();
    }
    
    
}
