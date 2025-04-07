package uni.aed.search;
public class Search {
    private Integer[] X;
    private final int NO_ENCONTRADO=-1;
    private int nComp=0;
    StringBuilder analisis=new StringBuilder();

    public void setX(Integer[] X) {
        this.X = X;
    }

    public Integer[] getX() {
        return X;
    }

    public void setnComp(int nComp) {
        this.nComp = nComp;
    }

    public int getnComp() {
        return nComp;
    }

    public String getAnalisis() {
        return analisis.toString();
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
        int nComp=0;
        while(bajo<=alto && X[medio]!=valor){
            setSecuencia(medio,valor,bajo,alto);
            nComp++;
            if(X[medio]<valor)
                bajo=medio+1;
            else
                alto=medio-1;
            
            medio=(bajo+alto)/2;
        }
        if(bajo>alto){
            this.setnComp(nComp);
            medio=NO_ENCONTRADO;
        }else{
            setSecuencia(medio,valor,bajo,alto);
            this.setnComp(nComp+1);
        }
            
        return medio;
    }
    private void setSecuencia(int medio,int valor, int bajo,int alto){
        analisis.append("Bajo: X[").append(bajo).append("]= ").append(X[bajo])
                .append(", Alto: X[").append(alto).append("]= ").append(X[alto]).append("\n");
        analisis.append("Comparando: X[").append(medio).append("]= ").append(X[medio])
                .append(", con valor ").append(valor).append("\n");        
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
