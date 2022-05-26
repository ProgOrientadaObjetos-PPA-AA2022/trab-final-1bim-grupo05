/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete06;

import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

/**
 *
 * @author reroes
 */
public class Casa {
    public Propietario p;
    public double pMetro;
    public double nMetro;
    public double costo;
    public Barrio b;
    public Ciudad city;
    public int numCuartos;
    public Constructora cons;
    
    
    
    
    public void establecerPropietario(Propietario c){
        p = c;
    }
    public void establecerPrecioMetro(double c){
        pMetro = c;
    }
    public void establecerNumeroMetro(double c){
        nMetro = c;
    }
    public void establecerCosto(double c){
        costo = c;
    }
    
    public void establecerBarrio(Barrio c){
        b = c;
    }
    
    public void establecerCiudad(Ciudad c){
        city = c;
    }
    public void establecerNumeroCuartos(int c){
        numCuartos = c;
    }
    public void establecerConstructora(Constructora c){
        cons = c;
    }
    
    public Propietario obtenerPropietario(){
        return p;
    }
    public double obtenerPrecioMetro(){
        return pMetro;
    }
    public double obtenerNumeroMetro(){
        return nMetro;
    }
    public double obtenerCosto(){
        return costo;
    }
    
    public Barrio obtenerBarrio(){
        return b;
    }
    public Ciudad obtenerCiudad(){
        return city;
    }
    public int obtenerNumeroCuartos(){
        return numCuartos;
    }
    public Constructora obtenerConstructora(){
        return cons;
    }
    
}
