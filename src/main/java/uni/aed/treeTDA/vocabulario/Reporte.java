/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.treeTDA.vocabulario;

import uni.aed.treeTDA.BstTDA;

public class Reporte {
    private String unidad;
    private BstTDA<Vocabulario> bst=new BstTDA<>(); 
    
    public Reporte(String unidad,BstTDA<Vocabulario> bst) {
        this.unidad = unidad;
        this.bst = bst;
    }

    public String getUnidad() {
        return unidad;
    }

    public BstTDA<Vocabulario> getBst() {
        return bst;
    }

    @Override
    public String toString() {
        return unidad + "\n" + bst.toString();
    }
    
}
