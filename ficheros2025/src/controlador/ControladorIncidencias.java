package controlador;

import vista.Consola;
import vista.Escaner;

import java.util.Scanner;

public class ControladorIncidencias {



    public static void iniciar() {
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
                // pedir número
                int numero = Escaner.pedirInt("Dame un numero: ");
                if (numero < 1 || > 4)

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
                Consola.mostrarString("⚠️ Opción no válida");
        }
    }
}
