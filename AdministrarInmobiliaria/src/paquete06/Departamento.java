/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete06;

import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

/**
 *
 * @author reroes
 */
public class Departamento implements Serializable{ 
    private Propietario p;
    private double pMetro;
    private double nMetro;
    private double alicuotaM;
    private double costoF;
    private Barrio b ;
    private Ciudad city ;
    private String nombreD;
    private String ubicacionD;
    private Constructora cons ;
    
    
    public Departamento(Propietario pp, double pm, double nm, double ali, 
            Barrio bb, Ciudad cy,String nom,String ubi, Constructora cA){
         p = pp;
         pMetro = pm;
         nMetro = nm;
         alicuotaM = ali;
         b = bb;
         city = cy;
         nombreD = nom;
         ubicacionD = ubi;
         cons = cA;
    }
    
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
    public void establecerCosto(){
        costoF = (nMetro * pMetro) + (alicuotaM *12);
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
    
    @Override
    public String toString(){
        String cadena = String.format("Departamento:%s\n",obtenerNombre());
        cadena = String.format("%s\n%s\n%s\n%s\n%s\nPrecio por Metro: %.2f.\n"
                + "Número de Metros: %.2f.\nAlicuota Mensual: %.2f.\n"
                + "Ubicación del Departamento: %s\n"
                ,cadena,obtenerPropietario(),obtenerCiudad(),obtenerBarrio(),
                obtenerConstructora(), obtenerPrecioMetro(), obtenerNumeroMetro(),
                obtenerAlicuota(),obtenerUbicacion());
        return cadena;
    }
}
