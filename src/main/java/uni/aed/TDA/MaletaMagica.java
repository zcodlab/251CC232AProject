package uni.aed.TDA;

public class MaletaMagica<T> implements ContenedorMagico<T> {    
    private T contenido;

    public MaletaMagica() {
        set(null);
    }    

    @Override
    public void set(T contenido) {
        this.contenido=contenido;
    }
    
    @Override
    public T get() {
        return contenido;
    }
    
}
