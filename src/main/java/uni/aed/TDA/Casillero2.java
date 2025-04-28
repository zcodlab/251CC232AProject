package uni.aed.TDA;

public class Casillero2 <T1,T2>{
    private T1 contenido1;
    private T2 contenido2;

    public Casillero2(T1 contenido1, T2 contenido2) {
        this.contenido1 = contenido1;
        this.contenido2 = contenido2;
    }

    public void setContenido1(T1 contenido1) {
        this.contenido1 = contenido1;
    }

    public void setContenido2(T2 contenido2) {
        this.contenido2 = contenido2;
    }

    public T1 getContenido1() {
        return contenido1;
    }

    public T2 getContenido2() {
        return contenido2;
    }

    @Override
    public String toString() {
        return "Casillero2{" + "contenido1=" + contenido1 + ", contenido2=" + contenido2 + '}';
    }
    
    
}
