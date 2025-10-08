package controlador;

import vista.Consola;
import vista.Escaner;

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
            Consola.mostrarString("Tipos de incidencia:");
            Consola.mostrarString("1. Archivo no encontrado");
            Consola.mostrarString("2. Error de entrada/salida");
            Consola.mostrarString("3. Excepción general");
            int tipo = Escaner.pedirInt("Selecciona el tipo de incidencia (1-3):");

            String descripcion = "";
            switch (tipo) {
                case 1:
                    descripcion = "Archivo no encontrado";
                    break;
                case 2:
                    descripcion = "Error de entrada/salida";
                    break;
                case 3:
                    descripcion = "Excepción general";
                    break;
                default:
                    Consola.mostrarString("Tipo de incidencia no válido.");
                    return;
            }

            crearIncidencia(descripcion, usuario);
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

