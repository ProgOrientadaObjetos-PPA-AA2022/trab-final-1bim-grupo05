/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;


/**
 *
 * @author reroes
 */
public class Ciudad {
    String nombreC, provincia;
    
    
    
    public void establecerNombre(String c){
        nombreC = c;
    }
    public void establecerProvincia(String c){
        provincia = c;
    }
    
    public String obtenerNombre(){
        return nombreC;
    }
    public String obtenerApellidos(){
        return provincia;
    }
    
}
