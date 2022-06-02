/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

import paquete02.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import paquete01.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author kevin
 */
public class EscrituraArchivosDepa{
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Departamento registro;
    private ArrayList<Departamento> lista ;
    
    public EscrituraArchivosDepa(String n){
        nombreArchivo = n;
        establecerLista();
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerLista().size() > 0) {
                for (int i = 0; i < obtenerLista().size(); i++) {
                    establecerRegistro(obtenerLista().get(i));
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catchh
    }
    
    public void establecerNombre(String n){
        nombreArchivo = n;
    }
    public void establecerRegistro(Departamento n){
        registro = n;
    }
    public void establecerLista(){
        LecturaArchivosDepa l = new LecturaArchivosDepa(obtenerNombre());
        l.establecerLista();
        lista = l.obtenerListaDepartamento();
    }
    
    public String obtenerNombre(){
        return nombreArchivo;
    }
    public Departamento obtenerPropietario(){
        return registro;
    }
    public ArrayList<Departamento> obtenerLista(){
        return lista;
    }
    
    
    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            
        } // fin de catch
    }
    
    public void establecerSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
}
