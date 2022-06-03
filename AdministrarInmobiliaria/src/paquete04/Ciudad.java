/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;

import java.io.Serializable;


/**
 *
 * @author reroes
 */
public class Ciudad implements Serializable {
    String nombreC, provincia;
    
    public Ciudad(String n,String p){
        nombreC =n ;
        provincia  = p;
    }
    
    public void establecerNombre(String c){
        nombreC = c;
    }
    public void establecerProvincia(String c){
        provincia = c;
    }
    
    public String obtenerNombre(){
        return nombreC;
    }
    public String obtenerProvincia(){
        return provincia;
    }
    
    @Override
    public String toString(){
        String cadena = String.format("Nombre de la Ciudad: %s - Provincia:"
                + " %s \n",obtenerNombre(), obtenerProvincia() );
        return cadena;
    }
}
