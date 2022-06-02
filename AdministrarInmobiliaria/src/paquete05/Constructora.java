/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete05;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Constructora implements Serializable{
    String nombre, id;
    
    public Constructora(String n,String i){
        nombre =n ;
        id  = i;
    }
    
    public void establecerNombre(String c){
        nombre = c;
    }
    public void establecerId(String c){
        id = c;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerId(){
        return id;
    }
    
    
    public String tostring(){
        String cadena = String.format("Nombre de la constructora: %s - Id de la constructora:"
                + " %s.\n",obtenerNombre(), obtenerId() );
        return cadena;
    }
}
