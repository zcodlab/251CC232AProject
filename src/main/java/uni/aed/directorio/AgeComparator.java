/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.directorio;

import java.util.Comparator;
import uni.aed.model.Persona;

public class AgeComparator implements Comparator{    
    private final int LESS = -1;
    private final int EQUAL = 0;
    private final int MORE  = 1;

    @Override
    public int compare(Object p1, Object p2) {
        int comparisonResult;

        int p1age = ((Persona)p1).getAge( );
        int p2age = ((Persona)p2).getAge( );

        if (p1age < p2age) {
            comparisonResult = LESS;
        } else if (p1age == p2age) {
            comparisonResult = EQUAL;
        } else {
            assert p1age > p2age;
            comparisonResult = MORE;
        }

        return comparisonResult;
    }
}
