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
public class Casa implements Serializable {
    private Propietario p;
    private double pMetro;
    private double nMetro;
    private double costo;
    private Barrio b;
    private Ciudad city;
    private int numCuartos;
    private Constructora cons;
    
    public Casa(Propietario pp, double pm, double nm, Barrio bb, Ciudad cy, int nC, Constructora cA){
         p = pp;
         pMetro = pm;
         nMetro = nm;
         b = bb;
         city = cy;
         numCuartos = nC;
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
    public void establecerCosto(){
        costo = nMetro * pMetro;
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
    
    @Override
    public String toString(){
        String cadena = "Casa\n";
        cadena = String.format("%s\n%s\n%s\n%s\n%s\nPrecio por Metro: %.2f.\n"
                + "Número de Metros: %.2f.\nNúmero de Cuartos: %d.\n"
                ,cadena,obtenerPropietario(),obtenerCiudad(),obtenerBarrio(),
                obtenerConstructora(), obtenerPrecioMetro(), obtenerNumeroMetro(), obtenerNumeroCuartos());
        return cadena;
    }
}
