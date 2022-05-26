/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

/**
 *
 * @author reroes
 */
public class Barrio {
    String nombre, referencia;
    
    
    
    public void establecerNombre(String c){
        nombre = c;
    }
    public void establecerReferencia(String c){
        referencia = c;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerApellidos(){
        return referencia;
    }
    
}
