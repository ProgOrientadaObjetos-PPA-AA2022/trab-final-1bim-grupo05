/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

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
public class LecturaArchivosDepa {
    private ObjectInputStream entrada;
    private ArrayList<Departamento> dep;
    private String nombreArchivo;
    private String identificador;
    private Propietario depa_buscado;
    
    public LecturaArchivosDepa(String n){
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
        dep = new ArrayList<>();
        File f = new File(obtenerNombre());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    dep.add(registro);
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
    
    public void establecerPropietarioBuscado() {
        // 
        
        File f = new File(obtenerNombre());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    
                    if(registro.obtenerIdentificacion().equals(identificador)){
                            depa_buscado = registro;
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
    
    public ArrayList<Departamento> obtenerListaDepartamento(){
        return dep;
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
    
    public Propietario obtenerDepartamentoBuscado(){
        return depa_buscado;
    }
    
    @Override
    public String toString() {
        String cadena = "Lista de Propietarios\n";
        
        if ((obtenerListaDepartamento().size()) >0){
            for (int i = 0; i < obtenerListaDepartamento().size(); i++) {
            Departamento depar = obtenerListaDepartamento().get(i);
            cadena = String.format("%s (%d) %s \n", cadena, i + 1,
                    depar);
            }
        }else{
            cadena = "No se ha ingresado ningun departamento.";
        }
        return cadena;
    }
}
