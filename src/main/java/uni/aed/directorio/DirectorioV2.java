package uni.aed.directorio;

import uni.aed.model.Persona;
import java.util.Arrays;
import java.util.Comparator;

public class DirectorioV2 implements Directorio{
    
    private static final int  DEFAULT_SIZE = 25;    
    private static final int  NOT_FOUND    = -1;
    private Persona[]   entry;
    private int        count;

    public DirectorioV2( ) {
        this( DEFAULT_SIZE );
    }
    
    public DirectorioV2(int size) {
        count = 0;
        if (size <= 0 ) { 
            throw new IllegalArgumentException("Size must be positive");
        }
        entry = new Persona[size]; 
    }
    public void add( Persona newPersona ) {
        if (count == entry.length)
            enlarge( );             
        
        entry[count] = newPersona;
        count++;
    }
    
    public boolean delete( String searchName ) {
        boolean    status;
        int        loc;
        loc = findIndex( searchName );//metodo que realiza la busqueda lineal
        if (loc == NOT_FOUND)
            status = false;
        else { 
            entry[loc] = entry[count-1];
            entry[count-1]=null;
            status = true;
            count--; //un elemento menos en el array       
        }
        return status;
    }    
    public Persona search( String searchName ) {//metodo aplica la busqueda lineal
        Persona foundPersona;
        int    loc = 0;
        while ( loc < count &&
                !searchName.equals( entry[loc].getName() ) )
            loc++;        
        if (loc == count)
            foundPersona = null;
        else
            foundPersona = entry[loc];        
        return foundPersona;
    }
    
    @Override
    public Persona[ ] sort ( int attribute ) {
        if (!(attribute == Persona.NAME || attribute == Persona.AGE) )
            throw new IllegalArgumentException( );        
        Persona[ ] sortedList = new Persona[ count ];        
        for (int i = 0; i < count; i++)
            sortedList[i] = entry[i];        
        Arrays.sort(sortedList, getComparator(attribute));
        return sortedList;
    }

    private void enlarge( )
    {
        int newLength = (int) (1.5 * entry.length);
        Persona[] temp = new Persona[newLength];     
        for (int i = 0; i < entry.length; i++)
            temp[i] = entry[i];        
        entry = temp;   
    }  
    
    @Override
    public String toString() {
        String result="";        
        for(Persona p: entry)
            if (p!=null)
                if (result.length()==0)
                    result=p.toString() ;
                else
                    result=result + ", " +p.toString() ;
        return result;
    }    
    
    private int findIndex( String searchName )//metodo que aplica el metodo de busqueda lineal
    {
        int loc = 0;
        while ( loc < count &&
                !searchName.equals( entry[loc].getName() ) )
            loc++;        
        
        if (loc == count)
            loc = NOT_FOUND;
        
        return loc;
    }
    
    private Comparator getComparator(int attribute) {
        Comparator comp = null;
        if (attribute == Persona.AGE) {
            comp = new AgeComparator( );
        } else {
            assert attribute == Persona.NAME:
                    "Atributo no reconocido por el ordenamiento";
            comp = new NameComparator( );
        }
        return comp;
    }     

    @Override
    public Object[] sort(int attribute, String algoritmo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int search(Object searchValue, String algoritmo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}