/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete05;

/**
 *
 * @author reroes
 */
public class Constructora {
    String nombre, id;
    
    
    
    public void establecerNombre(String c){
        nombre = c;
    }
    public void establecerId(String c){
        id = c;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerApellidos(){
        return id;
    }
    
}
