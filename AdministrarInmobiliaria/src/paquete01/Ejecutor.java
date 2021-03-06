/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.util.Locale;
import java.util.Scanner;
import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;
import paquete06.*;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Propietario p = null;
        Barrio b = null;
        Ciudad c = null;
        Constructora construc = null;
        Casa cA;
        Departamento d;
        int opc = 0;
        int nC;
        double pMetro, nMetro;
        do {
            opc = opciones(); //Menu
            switch (opc) {
                case 1: 
                    ingresarPropietarios(leer,p);
                    opc = 0;
                    break;
                case 2:
                    ingresarBarrio(leer,b);
                    break;
                case 3:
                    ingresarCiudad(leer,c);
                    break;
                case 4:
                    ingresarConstructora(leer,construc);
                    
                    break;
                case 5:
                    
                    p = buscarP();
                    b = buscarB();
                    c = buscarC();
                    construc = buscarConstruc();
                    // se asigna el valor de numero de metros, precio de metros y numero de cuartos.
                    leer.useLocale(Locale.US);
                    System.out.print("Ingresar el precio por metro cuadrado: ");
                    pMetro = leer.nextDouble();
                    System.out.println("");
                    System.out.print("Ingresar el numero de metros cuadrado: ");
                    nMetro = leer.nextDouble();
                    System.out.println("");
                    System.out.print("Ingresar el número de cuartos: ");
                    nC = leer.nextInt();
                    System.out.println("");
                    //Crear objeto casa
                    cA = new Casa(p, pMetro, nMetro, b, c, nC, construc);
                    cA.establecerCosto();
                    System.out.printf("%s\n",cA);
                    EscrituraArchivosCasa archivo = new EscrituraArchivosCasa("datos/casas.dat");
                    System.out.println(cA);
                    
                    archivo.establecerRegistro(cA);
                    archivo.establecerSalida();
                    
                    
                    
                    break;
                case 6:
                    
                    p = buscarP();
                    b = buscarB();
                    c = buscarC();
                    construc = buscarConstruc();
                    leer.useLocale(Locale.US);
                    // se asigna el valor de numero de metros, precio de metros y alicuota.
                    System.out.print("Ingresar el precio por metro cuadrado: ");
                    pMetro = leer.nextDouble();
                    System.out.println("");
                    System.out.print("Ingresar el numero de metros cuadrado: ");
                    nMetro = leer.nextDouble();
                    System.out.println("");
                    System.out.print("Ingresar alicuota mensual: ");
                    double alicuota = leer.nextDouble();
                    System.out.println("");
                    leer.nextLine();
                    System.out.println("Ingrese el nombre del Departamento: ");
                    String nombre = leer.nextLine();
                    System.out.println("Ingrese la ubicacion del Departamento: ");
                    String ubi = leer.nextLine();
                    d = new Departamento(p, pMetro, nMetro, alicuota, b, c, nombre, ubi, construc);
                    d.establecerCosto();
                    
                    EscrituraArchivosDepa archivo1 = new EscrituraArchivosDepa("datos/departamentos.dat");
                    archivo1.establecerRegistro(d);
                    
                    archivo1.establecerSalida();
                    break;
                case 7:
                    System.out.println("Ha salido del programa");
                    opc = 1;
                    break;
                default:
                    break;

            }
        } while (opc != 1);
        
        System.out.println("----------------------------------------------------------");
        do {
            opc = presentar();
            switch (opc) {
                case 1:
                    LecturaArchivosPropietario lp = new LecturaArchivosPropietario("datos/propietarios.dat");
                    lp.establecerLista();
                    System.out.printf("%s\n", lp);
                    lp.cerrarArchivo();
                    break;
                case 2:
                    LecturaArchivosBarrio lb = new LecturaArchivosBarrio("datos/barrios.dat");
                    lb.establecerLista();
                    System.out.printf("%s\n", lb);
                    lb.cerrarArchivo();
                    break;
                case 3:
                    LecturaArchivosCiudad lc = new LecturaArchivosCiudad("datos/ciudades.dat");
                    lc.establecerLista();
                    System.out.printf("%s\n", lc);
                    lc.cerrarArchivo();
                    break;
                case 4:
                    LecturaArchivosCons lco = new LecturaArchivosCons("datos/constructoras.dat");
                    lco.establecerLista();
                    System.out.printf("%s\n", lco);
                    lco.cerrarArchivo();
                    break;
                case 5:
                    LecturaArchivosCasa lca = new LecturaArchivosCasa("datos/casas.dat");
                    lca.establecerLista();
                    System.out.printf("%s\n", lca);
                    lca.cerrarArchivo();
                    break;
                case 6:
                    LecturaArchivosDepa ld = new LecturaArchivosDepa("datos/departamentos.dat");
                    ld.establecerLista();
                    System.out.printf("%s\n", ld);
                    ld.cerrarArchivo();
                    break;
                case 7:
                    System.out.println("Ha salido del programa");
                    opc = 2;
                    break;
                default:
                    break;

            }
        } while (opc != 2);

    }

    public static int opciones() {
        int i;
        Scanner leer = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.println("(1)Ingresar un nuevo Propietario. ");
        System.out.println("(2)Ingresar un nuevo Barrio.");
        System.out.println("(3)Ingresar una nueva Ciudad. ");
        System.out.println("(4)Ingresar una nueva Constructora. ");
        System.out.println("(5)Ingresar una nueva Casa. ");
        System.out.println("(6)Ingresar un nuevo Departamento.");
        System.out.println("(7)Dejar de ingresar y enseñar listas.");
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.print("Ingrese la opción que requerida: ");
        i = leer.nextInt();
        System.out.println("");

        return i;
    }
    public static int presentar() {
        int i;
        Scanner leer = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.println("(1)Presentar listas de Propietarios ");
        System.out.println("(2)Presentar listas de Barrios.");
        System.out.println("(3)Presentar listas de Ciudades. ");
        System.out.println("(4)Presentar listas de Constructoras. ");
        System.out.println("(5)Presentar listas de Casas. ");
        System.out.println("(6)Presentar listas de Departamentos.");
        System.out.println("(7)Salir del programa.");
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.print("Ingrese la opción que requerida: ");
        i = leer.nextInt();
        System.out.println("");

        return i;
    }

    public static Propietario buscarP() {
        Scanner leer = new Scanner(System.in);
        String nombres;
        Propietario propietario_Buscado;
        String identificacion;
        String apellidos;
        String nombreArchivo = "datos/propietarios.dat";
        System.out.println("Ingrese identificación del propietario: ");
        identificacion = leer.nextLine();

        LecturaArchivosPropietario lectura = new LecturaArchivosPropietario(nombreArchivo);
        lectura.establecerIdentificador(identificacion);
        lectura.establecerPropietarioBuscado();
        propietario_Buscado = lectura.obtenerPropietarioBuscado();
        if (propietario_Buscado != null) {
            System.out.printf("Propietario encontrado: \n %s\n\n", propietario_Buscado);
            return propietario_Buscado;
        } else {
            System.out.println("Propietario no encontrado");
            System.out.println("¿Desea Ingresar un propietraio?");
            System.out.println(" ingrese (y) para ingresar un Propietario y (n) para no hacerlo. ");
            
            String ingresar = null;
            ingresar = leer.nextLine();

            if (ingresar.equals("y")) {
                System.out.println("Ingrese nombres del propietario: ");
                nombres = leer.nextLine();
                System.out.println("Ingrese apellidos del propietario: ");
                apellidos = leer.nextLine();
                System.out.println("Ingrese identificacion del propietario: ");
                identificacion = leer.nextLine();
                Propietario p = new Propietario(nombres, apellidos, identificacion);
                EscrituraArchivosPropietario archivo = new EscrituraArchivosPropietario(nombreArchivo);
                archivo.establecerRegistro(p);
                archivo.establecerSalida();
                return p;
            } else {
                Propietario p = new Propietario("No Ingresado", "No Ingresado", "No Ingresado");
                return p;
            }
        }
    }

    public static Barrio buscarB() {
        Scanner leer = new Scanner(System.in);
        String identificacion;
        Barrio barrio_buscar;
        String referencia;
        String nombreArchivo = "datos/barrios.dat";
        System.out.println("Ingrese el nombre del barrio buscado: ");
        identificacion = leer.nextLine();

        LecturaArchivosBarrio lectura = new LecturaArchivosBarrio(nombreArchivo);
        lectura.establecerIdentificador(identificacion);
        lectura.establecerBarrioBuscado();
        barrio_buscar = lectura.obtenerBarrioBuscado();
        if (barrio_buscar != null) {
            System.out.printf("Barrio encontrado %s\n", barrio_buscar);
            return barrio_buscar;
        } else {
            System.out.println("Barrio no encontrado");
            System.out.println("¿Desea Ingresar un nuevo Barrio?");
            System.out.println(" ingrese (y) para ingresar un nuevo Barrio y (n) para no hacerlo. ");
            String ingresar = null;
            ingresar = leer.nextLine();

            if (ingresar.equals("y")) {
                System.out.println("Ingrese nombres del Barrio: ");
                identificacion = leer.nextLine();
                System.out.println("Ingrese la referencia del Barrio: ");
                referencia = leer.nextLine();
                Barrio b = new Barrio(identificacion, referencia);
                EscrituraArchivosBarrio archivo = new EscrituraArchivosBarrio(nombreArchivo);
                archivo.establecerRegistro(b);
                archivo.establecerSalida();
                return b;
            } else {
                Barrio b = new Barrio("No Ingresado", "No Ingresado");
                return null;
            }
        }
    }

    //---------------------------------------------------Buscar las ciudades
    public static Ciudad buscarC() {
        Scanner leer = new Scanner(System.in);
        String id;
        Ciudad ciudad_buscar;
        String provincia;
        String nombreArchivo = "datos/ciudades.dat";
        System.out.println("Ingrese el nombre de la ciudad: ");
        id = leer.nextLine();

        LecturaArchivosCiudad lectura = new LecturaArchivosCiudad(nombreArchivo);
        lectura.establecerIdentificador(id);
        lectura.establecerCiudadBuscado();
        ciudad_buscar = lectura.obtenerCiudadBuscado();
        if (ciudad_buscar != null) {
            System.out.printf("Ciudad encontrado %s\n", ciudad_buscar);
            return ciudad_buscar;
        } else {
            System.out.println("Ciudad no encontrado");
            System.out.println("¿Desea Ingresar una nueva Ciudad?");
            System.out.println(" ingrese (y) para ingresar una nueva ciudad y (n) para no hacerlo. ");
            String ingresar = null;
            ingresar = leer.nextLine();
            if (ingresar.equals("y")) {
                System.out.println("Ingrese nombres de la ciudad: ");
                id = leer.nextLine();
                System.out.println("Ingrese la provincia de la ciudad: ");
                provincia = leer.nextLine();
                Ciudad c = new Ciudad(id, provincia);
                EscrituraArchivosCiudad archivo = new EscrituraArchivosCiudad(nombreArchivo);
                archivo.establecerRegistro(c);
                archivo.establecerSalida();
                return c;
            } else {
                return null;
            }
        }
    }

    //---------------------------------------------------Buscar las Constructoras
    public static Constructora buscarConstruc() {
        Scanner leer = new Scanner(System.in);
        String id;
        Constructora cons_buscar;
        String nombre;
        String nombreArchivo = "datos/constructoras.dat";
        System.out.println("Ingrese el id de la constructora Buscada ");
        id = leer.nextLine();
        LecturaArchivosCons lectura = new LecturaArchivosCons(nombreArchivo);
        lectura.establecerIdentificador(id);
        lectura.establecerConstructorBuscado();
        cons_buscar = lectura.obtenerConstructoraBuscado();
        if (cons_buscar != null) {
            System.out.printf("Constructora encontrado %s\n", cons_buscar);
            return cons_buscar;
        } else {
            System.out.println("Constructora no encontrada");
            System.out.println("¿Desea Ingresar una nueva constructora?");
            System.out.println(" ingrese (y) para ingresar una nueva constructora y (n) para no hacerlo. ");
            String ingresar = null;
            ingresar = leer.nextLine();

            if (ingresar.equals("y")) {
                System.out.println("Ingrese nombres de la constructora: ");
                nombre = leer.nextLine();
                System.out.println("Ingrese el id de la Constructora: ");
                id = leer.nextLine();
                Constructora c = new Constructora(nombre, id);
                EscrituraArchivosCons archivo = new EscrituraArchivosCons(nombreArchivo);
                archivo.establecerRegistro(c);
                archivo.establecerSalida();
                return c;
            } else {
                return null;
            }
        }
    }
    public static void ingresarPropietarios(Scanner leer, Propietario p){
        int opcion = 0;
        
            System.out.println("Ingrese el nombre del propietario: ");
                    String nombresPropie = leer.nextLine();
                    System.out.println("Ingrese el apellido del propietario: ");
                    String apellidosPropie = leer.nextLine();
                    System.out.println("Ingrese identificacion del propietario: ");
                    String identificacionPropie = leer.nextLine();

                    p = new Propietario(nombresPropie, apellidosPropie, identificacionPropie);
                    EscrituraArchivosPropietario archivoPropie = new EscrituraArchivosPropietario("datos/propietarios.dat");
                    System.out.println("------------------------------------");
                    System.out.println(p);
                    System.out.println("------------------------------------");
                    archivoPropie.establecerRegistro(p);
                    archivoPropie.establecerSalida();
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Si desea ingresar un nuevo Propietario escriba el número [0] ");
                    System.out.println("Si desea volver al menú escriba elvolver a número [1]");
                    opcion = leer.nextInt();
                    leer.nextLine();
                    System.out.println("-------------------------------------------------------------");
                    
                    if (opcion == 0) {
            ingresarPropietarios(leer,p);
        }
    }
    public static void ingresarBarrio(Scanner leer, Barrio b){
        int opc1 = 0;
        
                    System.out.println("Ingrese el nombre del Barrio: ");
                    String nombresBar = leer.nextLine();
                    System.out.println("Ingrese la referencia del Barrio: ");
                    String referBar = leer.nextLine();

                    b = new Barrio(nombresBar, referBar);
                    EscrituraArchivosBarrio archivoBar = new EscrituraArchivosBarrio("datos/barrios.dat");
                    System.out.println("------------------------------------");
                    System.out.println(b);
                    System.out.println("------------------------------------");
                    archivoBar.establecerRegistro(b);
                    archivoBar.establecerSalida();
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Si desea ingresar un nuevo Barrio escriba el número [0] ");
                    System.out.println("Si desea volver al menú escriba el número [1]");
                    opc1 = leer.nextInt();
                    leer.nextLine();
                    System.out.println("-------------------------------------------------------------");
                    
                    if (opc1 == 0) {
            ingresarBarrio(leer,b);
        }
    }
    
    public static void ingresarCiudad(Scanner leer, Ciudad c){
        int opc1 = 0;
        
                    System.out.println("Ingrese el nombre de la ciudad: ");
                    String nombreCiu = leer.nextLine();
                    System.out.println("Ingrese la povincia de la Ciudad: ");
                    String provCiu = leer.nextLine();

                    c = new Ciudad(nombreCiu, provCiu);
                    EscrituraArchivosCiudad archivoCiu = new EscrituraArchivosCiudad("datos/ciudades.dat");
                    System.out.println(c);
                    archivoCiu.establecerRegistro(c);
                    archivoCiu.establecerSalida();
                    System.out.println("------------------------------------");
                    System.out.println(c);
                    System.out.println("------------------------------------");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Si desea ingresar una nueva Ciudad escriba el número [0] ");
                    System.out.println("Si desea volver al menú escriba el número [1]");
                    opc1 = leer.nextInt();
                    leer.nextLine();
                    System.out.println("-------------------------------------------------------------");
                    
                    if (opc1== 0) {
            ingresarCiudad(leer,c);
        }
    }
    public static void ingresarConstructora(Scanner leer, Constructora construc){
        int opc1 = 0;
                    System.out.println("Ingrese el nombre de la Constructora: ");
                    String nombreCons = leer.nextLine();
                    System.out.println("Ingrese el id de la Constructora: ");
                    String idCons = leer.nextLine();

                    construc = new Constructora(nombreCons, idCons);
                    EscrituraArchivosCons archivoCons = new EscrituraArchivosCons("datos/constructoras.dat");
                    System.out.println(construc);
                    archivoCons.establecerRegistro(construc);
                    archivoCons.establecerSalida();
                    System.out.println("------------------------------------");
                    System.out.println(construc);
                    System.out.println("------------------------------------");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Si desea ingresar una nueva constructora escriba el número [0] ");
                    System.out.println("Si desea volver al menú escriba el número [1]");
                    opc1 = leer.nextInt();
                    leer.nextLine();
                    System.out.println("-------------------------------------------------------------");
                    
                    if (opc1 == 0) {
            ingresarConstructora(leer,construc);
        }
    }
}
