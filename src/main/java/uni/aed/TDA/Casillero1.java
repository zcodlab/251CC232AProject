package uni.aed.TDA;

public class Casillero1<T> {
    private T contenido;

    public Casillero1() {
    }

    
    public Casillero1(T contenido) {
        this.contenido = contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return "Casillero1{" + "contenido=" + contenido + '}';
    }
    
    
    
}
