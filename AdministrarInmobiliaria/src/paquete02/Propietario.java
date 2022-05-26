/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

/**
 *
 * @author reroes
 */
public class Propietario {
    String nombre, apellido, identificacion;
    
    
    
    public void establecerNombre(String c){
        nombre = c;
    }
    public void establecerApellidos(String c){
        apellido = c;
    }
    public void establecerIdentificacion(String c){
        identificacion = c;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerApellidos(){
        return apellido;
    }
    public String obtenerIdentificacion(){
        return identificacion;
    }
}
