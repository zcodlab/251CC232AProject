package uni.aed.model;

import java.util.logging.Logger;

public class Libro {
    private String autor;

    public Libro() {
        this("Desconocido");
    }

    public Libro(String autor) {
        this.autor = autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "autor=" + autor + '}';
    }

    
    
    
    
}
