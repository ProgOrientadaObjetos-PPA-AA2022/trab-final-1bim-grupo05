/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Barrio implements Serializable{
    String nombre, referencia;
    
    public Barrio(String n,String r){
        nombre =n ;
        referencia  = r;
    }
    
    public void establecerNombre(String c){
        nombre = c;
    }
    public void establecerReferencia(String c){
        referencia = c;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerReferencia(){
        return referencia;
    }
    
    public String tostring(){
        String cadena = String.format("Nombre del Barrio: %s - Referencia:"
                + " %s. \n",obtenerNombre(), obtenerReferencia() );
        return cadena;
    }
}
