package controlador;

import vista.Consola;
import vista.Escaner;
import java.io.IOException;

public class ControladorIncidencias {

    public static void iniciar() {
        String usuario = Escaner.pedirString("Introduce el usuario: ");

        Consola.mostrarString("=== MENÚ DE INCIDENCIAS ===");
        Consola.mostrarString("1. Introducir incidencia");
        Consola.mostrarString("2. Buscar por usuario");
        Consola.mostrarString("3. Buscar por fecha");
        Consola.mostrarString("0. Salir");

        int opcion = Escaner.pedirInt("Elige una opción: ");

        switch (opcion) {
            case 1:
                try {
                    int numero = Escaner.pedirInt("Dame un número (1-3): ");
                    if (numero < 1 || numero > 3) {
                        Consola.mostrarString("El número está fuera del rango.");
                        throw new IOException("Número fuera de rango permitido");
                    }
                    if (numero == 1) {
                        throw new java.io.FileNotFoundException("FileNotFoundException");
                    }
                    if (numero == 2) {
                        throw new java.io.IOException("IOExcepción");
                    }
                    if (numero == 3) {
                        throw new Exception("Exception");
                    }
                } catch (Exception ex) {
                    crearIncidencia(ex.getMessage(), usuario);
                }
                break;

            case 2:
                Consola.mostrarString("Has elegido buscar por usuario");
                break;

            case 3:
                Consola.mostrarString("Has elegido buscar por fecha");
                break;

            case 0:
                Consola.mostrarString("Saliendo...");
                break;

            default:
                Consola.mostrarString("Opción no válida");
        }
    }

    private static void crearIncidencia(String excepcion, String usuario) {
        java.time.LocalDate fecha = java.time.LocalDate.now();
        java.time.LocalTime hora = java.time.LocalTime.now();
        servicio.ServicioFichero.guardarIncidencia(fecha, hora, excepcion, usuario);
        vista.Consola.mostrarString("Incidencia registrada correctamente.");
    }
}