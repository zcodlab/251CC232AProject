package uni.aed.model;
public class Bicicleta implements Comparable{
    private String nomPropietario;

    public Bicicleta(String nomPropietario) {
        this.nomPropietario = nomPropietario;
    }

    public void setNomPropietario(String nomPropietario) {
        this.nomPropietario = nomPropietario;
    }

    public String getNomPropietario() {
        return nomPropietario;
    }

    @Override
    public String toString() {
        return "Bicicleta{" + "nomPropietario=" + nomPropietario + '}';
    }    
    
    private int compareTo(Bicicleta o){
        String p2name=o.getNomPropietario();
        return this.nomPropietario.compareTo(p2name);
    }

    @Override
    public int compareTo(Object o) {
        return compareTo((Bicicleta)o);
    }
    
    
}
