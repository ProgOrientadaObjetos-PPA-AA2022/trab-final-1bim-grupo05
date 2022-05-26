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
public class Departamento {
    public Propietario p;
    public double pMetro;
    public double nMetro;
    public double alicuotaM;
    public double costoF;
    public Barrio b ;
    public Ciudad city ;
    public String nombreD;
    public String ubicacionD;
    public Constructora cons ;
    
    
    public void establecerPropietario(Propietario c){
        p = c;
    }
    public void establecerPrecioMetro(double c){
        pMetro = c;
    }
    public void establecerNumeroMetro(double c){
        nMetro = c;
    }
    public void establecerAlicuota(double c){
        alicuotaM = c;
    }
    public void establecerCosto(double c){
        costoF = c;
    }
    
    public void establecerBarrio(Barrio c){
        b = c;
    }
    
    public void establecerCiudad(Ciudad c){
        city = c;
    }
    public void establecerConstructora(Constructora c){
        cons = c;
    }
    public void establecerNombre(String c){
        nombreD = c;
    }
    public void establecerUbicacion(String c){
        ubicacionD = c;
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
    public double obtenerAlicuota(){
        return alicuotaM;
    }
    public double obtenerCosto(){
        return costoF;
    }
    
    public Barrio obtenerBarrio(){
        return b;
    }
    public Ciudad obtenerCiudad(){
        return city;
    }
    public Constructora obtenerConstructora(){
        return cons;
    }
    
    public String obtenerNombre(){
        return nombreD;
    }
    public String obtenerUbicacion(){
        return ubicacionD;
    }
    
}
