/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author kevin
 */
public class EscrituraArchivosBarrio{
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Barrio registro;
    private ArrayList<Barrio> lista ;
    
    public EscrituraArchivosBarrio(String n){
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
    public void establecerRegistro(Barrio n){
        registro = n;
    }
    public void establecerLista(){
        LecturaArchivosBarrio l = new LecturaArchivosBarrio(obtenerNombre());
        l.establecerLista();
        lista = l.obtenerListaBarrio();
    }
    
    public String obtenerNombre(){
        return nombreArchivo;
    }
    public Barrio obtenerPropietario(){
        return registro;
    }
    public ArrayList<Barrio> obtenerLista(){
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
