package uni.aed.sort;
public class Sort {
    private Integer[] X;

    public void setX(Integer[] X) {
        this.X = X;
    }
    //metodo de ordenamiento de la burbuja
    public void bubbleWuSort(){
        int temp,bottom;
        boolean exchange=true;
        bottom=X.length-2;
        while(exchange){
            exchange=false;
            for(int i=0;i<=bottom;i++){
                if(X[i]>X[i+1]){
                    temp=X[i];
                    X[i]=X[i+1];
                    X[i+1]=temp;
                    exchange=true;
                }                    
            }
            bottom--;            
        }
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
    
    @Override
    public String toString() {
        if (X==null) return "";
        StringBuilder str=new StringBuilder();
        for(Object x:X)
            if(str.isEmpty())
                str.append(x.toString());
            else
                str.append("," + x.toString());
        
        return str.toString();        
    }
    
}
