package vista;

/**
 * Clase Consola: Vista del sistema.
 * Se encarga de mostrar menús, mensajes y apoyarse en Escaner
 * para recoger datos del usuario.
 */
public class Consola {

    /**
     * Muestra el menú principal de la aplicación.
     */
    public static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE CONTROL DE INCIDENCIAS ===");
        System.out.println("1. Registrar incidencia");
        System.out.println("2. Listar incidencias");
        System.out.println("3. Buscar incidencia por ID");
        System.out.println("4. Resolver incidencia");
        System.out.println("0. Salir");
    }

    /**
     * Muestra un texto en consola.
     */
    public static void mostrarString(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Pide un número entero al usuario usando Escaner.
     */
    public static int pedirEntero(String mensaje) {
        int numero = -1;
        boolean valido = false;

        while (!valido) {
            try {
                String respuesta = Escaner.pedirString(mensaje);
                numero = Integer.parseInt(respuesta);
                valido = true;
            } catch (NumberFormatException e) {
                mostrarString("Error: introduce un número válido.");
            }
        }

        return numero;
    }

    /**
     * Pide un texto al usuario usando Escaner.
     */
    public static String pedirTexto(String mensaje) {
        return Escaner.pedirString(mensaje);
    }
}
