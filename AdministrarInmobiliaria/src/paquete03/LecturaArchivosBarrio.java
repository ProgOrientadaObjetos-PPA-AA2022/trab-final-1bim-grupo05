/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

import paquete02.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class LecturaArchivosBarrio {
    private ObjectInputStream entrada;
    private ArrayList<Barrio> bar;
    private String nombreArchivo;
    private String identificador;
    private Barrio barrio_buscado;
    
    public LecturaArchivosBarrio(String n){
        nombreArchivo = n;
        File f = new File(obtenerNombre());

        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            } // fin de catch
        }
    }
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    } 
    public void establecerIdentificador(String n) {
        identificador = n;
    }
    public void establecerLista() {
        bar = new ArrayList<>();
        File f = new File(obtenerNombre());
        if (f.exists()) {

            while (true) {
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    bar.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    // System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }
    }
    
    public void establecerBarrioBuscado() {
        // 
        
        File f = new File(obtenerNombre());
        if (f.exists()) {

            while (true) {
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    
                    if(registro.obtenerNombre().equals(identificador)){
                        barrio_buscado = registro;
                        break;
                    }
                    
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo
                    // se puede usar el break;
                    // System.err.println("Fin de archivo: " + endOfFileException);

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }
    public String obtenerNombre(){
        return nombreArchivo;
    }
    
    public ArrayList<Barrio> obtenerListaBarrio(){
        return bar;
    }
    public String obternerIdentificador() {
        return identificador;
    }
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fi
    
    public Barrio obtenerBarrioBuscado(){
        return barrio_buscado;
    }
    
    @Override
    public String toString() {
        String cadena = "Lista de Barrios\n";
        for (int i = 0; i < obtenerListaBarrio().size(); i++) {
            Barrio barr = obtenerListaBarrio().get(i);
            cadena = String.format("%s (%d) Nombre: %s -Referencia: %s \n", cadena, i + 1,
                    barr.obtenerNombre(),barr.obtenerReferencia() );
        }

        return cadena;
    }
}
