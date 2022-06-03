/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Propietario implements Serializable{
    private String nombre, apellido, identificacion;
    
    public Propietario(String n, String a, String i){
        nombre = n;
        apellido = a;
        identificacion = i;
    }
    
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
    
    @Override
    public String toString(){
        String cadena = String.format("Nombre de propietario: %s - Apellido de Propietarios:"
                + " %s - Identificación: %s. \n",obtenerNombre(), obtenerApellidos(),
                obtenerIdentificacion() );
        return cadena;
    }
}
