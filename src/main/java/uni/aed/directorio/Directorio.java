package uni.aed.directorio;
import uni.aed.model.Persona;
public interface Directorio {
    public void add( Persona newPersona );
    public boolean delete( String searchName );          
    public Persona search( String searchName );  
    public int search( Object searchValue,String algoritmo );    
    public Persona[ ] sort ( int attribute);            
    public Object[ ] sort ( int attribute, String algoritmo );   
}
