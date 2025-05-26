package uni.aed.stackTDA.tagsHTML;

import java.io.IOException;
import uni.aed.stackTDA.ArrayStackTDA;
import uni.aed.stackTDA.StackTDA;

public class HTMLRevisaEtiq {
    private StackTDA<HTMLEtiq> pila;
    private HTMLRecuperaEtiq etiqRecuperada;

    public HTMLRevisaEtiq(String nomArchivo) throws IOException {
        this.pila = new ArrayStackTDA<>();//instanciando la clase concreta de pila a usar
        this.etiqRecuperada = new HTMLRecuperaEtiq(nomArchivo);//instanciar la clase para cargar la informacion en el reader        
    }

    public StackTDA<HTMLEtiq> getPila() {
        return pila;
    }

    public HTMLRecuperaEtiq getEtiqRecuperada() {
        return etiqRecuperada;
    }
    
    public boolean esValido(){
        HTMLEtiq etiqSiguiente=null, etiqTop=null;
        boolean nohayerror=true,termina=false;
        pila.clear();
        while(!termina){
            if(!etiqRecuperada.hayMasEtiq()){
                termina=true;
                if(!pila.isEmpty())
                    nohayerror=false;//lo que implica que si hay error
            }else{
                try{
                    etiqSiguiente=etiqRecuperada.etiqSiguiente();
                }catch(IOException e){
                    e.printStackTrace();
                }
                if(etiqSiguiente.esEtiquetaApertura())
                    pila.push(etiqSiguiente);
                else if(etiqSiguiente.esEtiquetaCierre()){
                    etiqTop=pila.pop();//extraer de la pila el elemento de la cima o cuspide
                    if(!etiqTop.compara(etiqSiguiente)){
                        nohayerror=false;//quiere decir que si hay error
                        termina=true;
                    }
                }
            }
        }
        return nohayerror;
    }
}
