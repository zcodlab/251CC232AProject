/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.stackTDA;

/**
 *
 * @author zemr
 */
public class StackEmptyExceptionTDA extends RuntimeException{

    public StackEmptyExceptionTDA() {
        this("La Pila esta vacia");
    }

    public StackEmptyExceptionTDA(String message) {
        super(message);
    }
    
}
