package controlador;

import modelo.Incidencia;
import vista.Consola;
import vista.Escaner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ControladorIncidencias {



    public static void iniciar() throws Exception {
        //aqui pides el nombre del usuario y lo guarda en
        String usuario=Escaner.pedirString("Introduce el usuario: ");
        // mostrar menú
        Consola.mostrarString("=== MENÚ DE INCIDENCIAS ===");
        Consola.mostrarString("1. Introducir incidencia");
        Consola.mostrarString("2. Buscar por usuario");
        Consola.mostrarString("3. Buscar por fecha");
        Consola.mostrarString("0. Salir");

        int opcion = Escaner.pedirInt("Elige una opción: ");

        switch (opcion) {
            case 1:
                // pedir número, tiene que estar entre el 1 y el 4 si esta fuera salta una excepcion de tipo IOException si no se almacena y lo guarda
                int numero = Escaner.pedirInt("Dame un numero: ");
                if (numero < 1 || numero > 4){
                    Consola.mostrarString("El numero esta fuera del rango.  ");
                }
                if (numero == 1) {
                    throw new FileNotFoundException("No se encontro el archivo");
                }
                if (numero == 2){
                    throw new IOException("");
                }


            case 2:
                Consola.mostrarString("Has elegido buscar por usuario");
                // aquí pondrás la lógica para buscar usuario en el fichero
                break;

            case 3:
                Consola.mostrarString("Has elegido buscar por fecha");
                // aquí pondrás la lógica para buscar por fecha
                break;

            case 0:
                Consola.mostrarString("Saliendo del programa...");
                break;

            default:
                Consola.mostrarString("Opción no válida");
        }

    }


}
