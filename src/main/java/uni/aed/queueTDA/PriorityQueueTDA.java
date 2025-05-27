package uni.aed.queueTDA;

public class PriorityQueueTDA<E> implements QueueTDA<E> {
    private static final int TAMANIO_INDEFINIDO=10;
    private static final int RAIZ=0;
    private E[] heap;
    private int count;

    public PriorityQueueTDA() {
        this(TAMANIO_INDEFINIDO);
    }
    
    public PriorityQueueTDA(int tamanio) {
        if(tamanio<0)
            throw new IllegalArgumentException("Capacidad debe ser mayor a cero");
        heap=(E[])new Object[tamanio];
        count=0;
    }
    
    @Override
    public void enqueue(E data) {
        if(count==heap.length)
            expande();
        heap[count]=data;
        construye();
        count++;
    }
    private void construye(){
        for(int i=(count-2)/2;i>=0;i--)
            reconstruye(i);
    }
    private void reconstruye(int raiz){
        int actual=raiz;
        boolean termina=false;
        while(!termina){
            if((2*actual+1)> count - 1)//el nodo actual no tiene hijos
                termina=true;
            else{//nodo actual tiene al menos un hijo, 
                //obteniendo el indice del hijo con mayor prioridad
                int indexHijoAlta=hijoMayorPrioridad(actual, count - 1);
                if(((Comparable<E>)heap[indexHijoAlta]).compareTo(heap[actual])<0){
                    swap(actual,indexHijoAlta);
                    actual=indexHijoAlta;
                }else
                    termina=true;
            }
        }
    }
    private int hijoMayorPrioridad(int ubicacion, int fin){
        int resultado, indexHijoIzq,indexHijoDer;
        indexHijoIzq=2*ubicacion+1;
        indexHijoDer=2*ubicacion+2;
        if(indexHijoDer<=fin 
           && ((Comparable<E>)heap[indexHijoIzq]).compareTo(heap[indexHijoDer])<0)
           resultado=indexHijoIzq;//es el que tendria la mayor proridad de acuerdo al metarial de C. Thomas Wu(pag 1089)
        else
           resultado=indexHijoDer; 
        return resultado;
    }
    
    private void swap(int index1,int index2){//index2 tendria la mayor prioridad sobre index1
        E temp=heap[index1];
        heap[index1]=heap[index2];
        heap[index2]=temp;
    }
    
    private void expande(){
        int newLength=(int)(1.5*heap.length);
        E[] temp=(E[])new Object[newLength];
        for(int i=0;i<heap.length;i++)
            temp[i]=heap[i];
        heap=temp;
    }

    @Override
    public E dequeue() throws QueueEmptyExceptionTDA {
        if(isEmpty())
            throw new QueueEmptyExceptionTDA(); 
        E item=heap[RAIZ];
        heap[RAIZ]=heap[count-1];//elemento de la ultima posicion del heap se consigna en la raiz
        count--;
        reconstruye(RAIZ);//metodo que debe garantizar que en la raiz se encuentre el elemento con mayor prioridad
        return item;        
    }

    @Override
    public E peek() throws QueueEmptyExceptionTDA {
        if(isEmpty())
            throw new QueueEmptyExceptionTDA(); 
        return heap[RAIZ];
    }

    @Override
    public void clear() {
        for(int i=0;i<count;i++)
            heap[i]=null;
        count=0;
    }

    @Override
    public boolean isEmpty() {
         return(count==0);
    }

    @Override
    public int size() {
        return count;
    }
    
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        int current=RAIZ;
        while(current<count){        
            if(!str.isEmpty())
                str.append(",");
            str.append(heap[current].toString());
            current++;
        }
        return str.toString();
    }
}
