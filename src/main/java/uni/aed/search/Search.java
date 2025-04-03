package uni.aed.search;
public class Search {
    private Integer[] X;
    private final int NO_ENCONTRADO=-1;

    public void setX(Integer[] X) {
        this.X = X;
    }

    public Integer[] getX() {
        return X;
    }
    
    public int searchLineal(int valor){
        int loc=0;
        while(loc<X.length && X[loc]!=valor){
            loc++;
        }
        if(loc==X.length)
            return NO_ENCONTRADO;
        else
            return loc;
    }
    
    public int searchBinaria(int valor){
        int bajo=0,alto=X.length-1, medio=(bajo+alto)/2;
        while(bajo<=alto && X[medio]!=valor){
            if(X[medio]<valor)
                bajo=medio+1;
            else
                alto=medio-1;
            
            medio=(bajo+alto)/2;
        }
        if(bajo>alto)
            medio=NO_ENCONTRADO;
        return medio;
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
