package uni.aed.stackTDA.tagsHTML;

public class HTMLEtiq {
    private String texto;

    public HTMLEtiq(String texto) {
        this.texto = texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
    public boolean esEtiquetaApertura(){
        return texto.startsWith("<")
                && texto.endsWith(">")
                && texto.charAt(1)!='/';
    }
    
    public boolean esEtiquetaCierre(){
        return texto.startsWith("</")
                && texto.endsWith(">");
    }
    public boolean compara(HTMLEtiq etiq){//compara si se trata de su etiqueta de cierre
        String etiqueta1=texto.toLowerCase();
        String etiqueta2=etiq.getTexto().toLowerCase();
        if(etiqueta1.startsWith("<") && etiqueta1.endsWith(">")
                && etiqueta2.startsWith("</") && etiqueta2.endsWith(">")){
            String etiqueta1Nombre=etiqueta1.substring(1, etiqueta2.length()-2);
            String etiqueta2Nombre=etiqueta2.substring(2, etiqueta2.length()-1);
            return etiqueta1Nombre.equals(etiqueta2Nombre);
        }else
            return false;
    }
    
}
