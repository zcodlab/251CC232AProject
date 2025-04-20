package uni.aed.sort;
public class Sort {
    private Integer[] X;
    private int nInt=0;//#ntercambios
    private int nComp=0;//#Comparaciones
    private long tEjec=0;//Tiempo de Ejecucion

    public void setX(Integer[] X) {
        this.X = X;
    }

    public Integer[] getX() {
        return X;
    }

    public void setnInt(int nInt) {
        this.nInt = nInt;
    }

    public void setnComp(int nComp) {
        this.nComp = nComp;
    }

    public void settEjec(long tEjec) {
        this.tEjec = tEjec;
    }

    public int getnInt() {
        return nInt;
    }

    public int getnComp() {
        return nComp;
    }

    public long gettEjec() {
        return tEjec;
    }
    
    
    //metodo de ordenamiento de la burbuja
    public void bubbleWuSort(){
        int temp,bottom;
        boolean exchange=true;
        bottom=X.length-2;
        int nInt=0,nComp=0;
        long tIni=System.nanoTime();
        while(exchange){
            exchange=false;
            for(int i=0;i<=bottom;i++){
                nComp++;
                if(X[i]>X[i+1]){
                    temp=X[i];
                    X[i]=X[i+1];
                    X[i+1]=temp;
                    exchange=true;
                    nInt++;
                }                    
            }
            bottom--;            
        }
        long tFin=System.nanoTime();
        clear();
        this.setnInt(nInt);
        this.setnComp(nComp);
        this.settEjec(tFin-tIni);
    }
    
    private void clear(){
        this.setnInt(0);
        this.setnComp(0);
        this.settEjec(0);
    }
    //metodo de ordenamiento por seleccion
    public void selectionWuSort(){
        int startIndex,minIndex,lenght,temp;
        lenght=X.length;
        for(startIndex=0;startIndex<=lenght-2;startIndex++){
            minIndex=startIndex;
            //buscando el valor mas pequeño
            for(int i=startIndex+1;i<=lenght-1;i++){
                if(X[i]<X[minIndex]) minIndex=i;
            }
            //intercambio
            temp=X[startIndex];
            X[startIndex]=X[minIndex];
            X[minIndex]=temp;            
        }
    }    
    public void insercionSort(){
        int aux,k;
        boolean sw=false;
        for(int i=1;i<X.length;i++){
            aux=X[i];
            k=i-1;
            sw=false;
            while(!sw && k>=0){
                if(aux<X[k])
                {
                   X[k+1]=X[k];
                   k--;
                }
                else
                    sw=true;
            }
            X[k+1]=aux;
        }//end for        
    }
    public void insercionBinariaSort(){
        int aux,p,u,c;
        for(int i=1;i<X.length;i++){
            aux=X[i];
            p=0;
            u=i-1;
            while(p<=u){
                c=(p+u)/2;
                if(aux<X[c])
                    u=c-1;
                else
                    p=c+1;
            }
            for(int k=i-1;k>=p;k--)
                X[k+1]=X[k];
            X[p]=aux;
        }//end for externo
    }     
    
    public void heapSort(){
        heapSortConstruct();//fase 1: construccion
        heapSortExtract();//fase 2: extraccion
    }
    private void heapSortConstruct(){
        int current=0, maxChildIndex;
        boolean hecho;
        for(int i=(X.length-2)/2;i>=0;i--){
            current=i;
            hecho=false;
            while(!hecho)//2*i+1 2*i+2
            {
                if(2*current+1 > X.length -1)
                    //nodo actual no tiene hijo
                    hecho=true;
                else{
                    maxChildIndex=heapSortMaxChild(current,X.length-1);
                    if(X[current]<X[maxChildIndex]){
                        intercambio(current,maxChildIndex);
                        current=maxChildIndex; }//aqui estaba la incidencia, faltaba esta linea de codigo
                    else
                        hecho=true;
                }
            }//end while
        }//end for
    }
    private void intercambio(int p, int q){
        int temp=X[p];
        X[p]=X[q];
        X[q]=temp;
    }
    private int heapSortMaxChild(int loc, int end){
        int result,izq,der;
        izq=2*loc+1;//pos izq
        der=2*loc+2;//pos der
        if(der<=end && X[izq]<X[der])
            result=der;
        else
            result=izq;
        return result;//devolviendo la pos del hijo que tiene el mx valor
    }
    private void heapSortExtract(){
        Integer[] Y=new Integer[X.length];
        int current, maxChildIndex;
        boolean hecho;
        for(int i=X.length-1;i>=0;i--){
            Y[i]=X[0];//consignamos el root del heap
            X[0]=X[i];//actualizamos el root con el ult. elemento del heap
            //reconstruir el heap
            current=0;
            hecho=false;
            while(!hecho){
                if(2*current+1 > i)//validando la restriccion estructural
                    hecho=true;
                else{//verificamos si el nodo actual tiene al menos 1 hijo
                    maxChildIndex=heapSortMaxChild(current, i);
                    if(X[current]<X[maxChildIndex]){
                        intercambio(current,maxChildIndex);
                        current=maxChildIndex;
                    }else
                        hecho=true;
                } 
            }//end wuile
        }//end for
        X=Y;//Y es el array ordenado luego del proceso
    }
    
    // ✅ NUEVO MÉTODO: QuickSort | solucion enunciado 1-pc1
    public Integer[] QuickSort(Integer[] X, int start, int end) {
        if (start < end) {
            int pIndex = QuickSortPartition(X, start, end);
            QuickSort(X, start, pIndex - 1);
            QuickSort(X, pIndex + 1, end);
        }
        return X;
    }

    private int QuickSortPartition(Integer[] X, int start, int end) {
        int pivot = X[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (X[i] <= pivot) {
                intercambio(X, i, pIndex);
                pIndex++;
            }
        }
        intercambio(X, pIndex, end);
        return pIndex;
    }

    // ✅ Sobrecarga del método intercambio para QuickSort
    private void intercambio(Integer[] X, int p, int q) {
        int temp = X[p];
        X[p] = X[q];
        X[q] = temp;
    }
    
    @Override
    public String toString() {
        if (X==null) return "";
        StringBuilder str=new StringBuilder();
        for(Object x:X)
            if(str.isEmpty())
                str.append(x.toString());
            else
                str.append("," + x.toString());
        
        return "{"+str.toString()+"} nInt= "+ nInt +", nComp= "+nComp +", tEjec= "+tEjec+ "(ns)";        
    }
    
}
