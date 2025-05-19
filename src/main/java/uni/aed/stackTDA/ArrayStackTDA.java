package uni.aed.stackTDA;

public class ArrayStackTDA<E> implements StackTDA<E> {
    public static final int TAMANIO_DEFINIDO=10;    
    private E[] data;
    private int count;

    public ArrayStackTDA() {
        this(TAMANIO_DEFINIDO);
    }
    public ArrayStackTDA(int size) {
        if(size<=0)
            throw new IllegalArgumentException("Tamaño de la Pila debe ser mayor a ceo");
        data=(E[])new Object[size];
        count=0;         
    }    
    
    @Override
    public void push(E elemento) {
        if(count==data.length)
            expande();
        data[count]=elemento;        
        count++;
    }
    private void expande(){
        int newLength=(int)(1.5*data.length);
        E[] temp=(E[]) new Object[newLength];
        for(int i=0;i<data.length;i++)
            temp[i]=data[i];
        data=temp;
    }    

    @Override
    public E pop() throws StackEmptyExceptionTDA {
        if(isEmpty())
            throw new StackEmptyExceptionTDA();        
        E elemento=data[count-1];
        data[count-1]=null;
        count--;
        return elemento;
    }

    @Override
    public E peek() throws StackEmptyExceptionTDA {
        if(isEmpty())
            throw new StackEmptyExceptionTDA();  
        return data[count-1];
    }

    @Override
    public void clear() {
       for(int i=0;i<count;i++)
            data[i]=null;
        count=0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return(count==0);
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        int current=count-1;
        while(current>=0){
            if(!str.isEmpty())
                str.append(",");
            str.append(data[current].toString());
            current--;
        }
        return str.toString();
    }
    
}
