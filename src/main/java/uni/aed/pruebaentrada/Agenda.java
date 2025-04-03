/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.pruebaentrada;

/**
 * Prueba de Entrada 251
 * Clase que permite realizar operaciones con la clase persona, como: 
 * insertarPersona y calcular su edad promedio
 * @author uni.cc232
 */
public class Agenda {
    private Persona[] agenda;
    private int cont;
    
    public Agenda(int N) {
        agenda= new Persona[N];
        cont=0;
    }
    
    public void registrarPersona(Persona p){
        if (cont<agenda.length)
            agenda[cont++]=p;                    
    }
    
    public float calcularEdadPromedio(){
        if (cont==0) return 0;
        
        float edadSuma=0.00f;        
        for(Persona p:agenda)
            if (p!=null) edadSuma+= p.getEdad();
        return (edadSuma/cont);
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        for(Persona p:agenda)
            if (p!=null) str.append(p.toString());            
        return str.toString();
    }   
    
}
