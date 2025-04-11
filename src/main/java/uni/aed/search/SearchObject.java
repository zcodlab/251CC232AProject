package uni.aed.search;

public class SearchObject {
    private Object[] X;
    private final int NO_ENCONTRADO=-1;    
    StringBuilder analisis=new StringBuilder();

    public void setX(Object[] X) {
        this.X = X;
    }

    public Object[] getX() {
        return X;
    }
    
    public int searchLineal(Object valor){
        int loc=0;
        while(loc<X.length && ((Comparable)X[loc]).compareTo(valor)!=0){//X[loc]!=valor
            loc++;
        }
        if(loc==X.length)
            return NO_ENCONTRADO;
        else
            return loc;
    }
    public int searchBinaria(Object valor){
        int bajo=0,alto=X.length-1, medio=(bajo+alto)/2;
        int nComp=0;
        while(bajo<=alto && ((Comparable)X[medio]).compareTo(valor)!=0){//X[medio]!=valor
            if(((Comparable)X[medio]).compareTo(valor)<0)
                bajo=medio+1;
            else
                alto=medio-1;
            
            medio=(bajo+alto)/2;
        }
        if(bajo>alto)
            medio=NO_ENCONTRADO;
        return medio;
    }
}
