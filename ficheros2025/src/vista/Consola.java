package vista;

/**
 * Clase Consola: Vista del sistema.
 * Se encarga de mostrar menús, mensajes y apoyarse en Escaner
 * para recoger datos del usuario.
 */
public class Consola {

     //Muestra un texto en consola
    public static void mostrarString(String mensaje) {
        System.out.println(mensaje);
    }

    //Pide un número entero al usuario usando Escaner

    public static int pedirEntero(String mensaje) {
        return Escaner.pedirInt(mensaje);
    }

    //Pide un texto al usuario usando Escaner
    public static String pedirTexto(String mensaje) {
        return Escaner.pedirString(mensaje);
    }
}
