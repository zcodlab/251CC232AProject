/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.directorio;

import java.util.Comparator;
import uni.aed.model.Persona;

/**
 *
 * @author hp
 */
public class NameComparator implements Comparator{    
    @Override
    public int compare(Object p1, Object p2) {
        String p1name = ((Persona)p1).getName( );
        String p2name = ((Persona)p2).getName( );
        return p1name.compareTo(p2name);
    }
}
