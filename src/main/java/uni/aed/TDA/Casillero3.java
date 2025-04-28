package uni.aed.TDA;

public class Casillero3<T extends Number> {
    private T contenido;

    public Casillero3() {
    }

    public Casillero3(T contenido) {
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
        return "Casillero3{" + "contenido=" + contenido + '}';
    }
    
    
}
