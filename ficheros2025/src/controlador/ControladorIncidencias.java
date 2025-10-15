package controlador;

import vista.Consola;
import vista.Escaner;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Incidencia;
import servicio.ServicioFichero;

public class ControladorIncidencias {
    //metodo iniciar que es llamado desde el main
    public static void iniciar() {

        //introdues tu nombre para registrarlo como creador de la incidencia
        String usuario = Escaner.pedirString("Introduce el usuario: ");
        //ESTE ES EL MENU
        Consola.mostrarString("=== MENÚ DE INCIDENCIAS ===");
        Consola.mostrarString("1. Introducir incidencia");
        Consola.mostrarString("2. Buscar por usuario");
        Consola.mostrarString("3. Buscar por fecha");
        Consola.mostrarString("0. Salir");

        //Aqui despues de introducir tu nombre eliges una opcion del menu
        int opcion = Escaner.pedirInt("Elige una opción: ");

        switch (opcion) {
            case 1:
                try {//te pide un numero dentro del rango para generar la excepcion, si esta fuera sale con la IOException
                    int numero = Escaner.pedirInt("Dame un número (1-3): ");
                    if (numero < 1 || numero > 3) {
                        Consola.mostrarString("El número está fuera del rango.");
                        throw new IOException("Número fuera de rango permitido");
                    }
                    if (numero == 1) {//Si se introduze numero 1 salta la siguiente excepcion asi igual con todos los numeros
                        throw new java.io.FileNotFoundException("FileNotFoundException");
                    }
                    if (numero == 2) {//Aqui igual
                        throw new java.io.IOException("IOExcepción");
                    }
                    if (numero == 3) {//Aqui igual
                        throw new Exception("Exception");
                    }
                } catch (Exception ex) {//Aqui segun el numero introduzido se crea laa incidencia
                    crearIncidencia(ex.getMessage(), usuario);
                }
                break;

            case 2:
                String usuarioBuscar = Escaner.pedirString("Introduce el usuario a buscar: ");
                //declaro los array
                //Y busco el usuario por nombre
                ArrayList<Incidencia> listaIncidenciasUsuario = ServicioFichero.leerIncidencias();
                ArrayList<String> resultadoUsuario = ServicioFichero.buscarPorUsuario(usuarioBuscar, listaIncidenciasUsuario);
                //Aqui compruebo si el aray esta vacio pasa el siguiente mensaje
                if (resultadoUsuario.isEmpty()) {
                    Consola.mostrarString("No se encontraron incidencias para ese usuario.");
                } else {//Si no te pasa pasa el siguiente mensaje y te muestra el usuario
                    Consola.mostrarString("Incidencias encontradas:");
                    //recorres el Array y muestra cada incidencia encontrada
                    for (String inc : resultadoUsuario) {
                        Consola.mostrarString(inc);
                    }
                }
                break;

            case 3:
                String fechaIniStr = Escaner.pedirString("Introduce la fecha de inicio (YYYY-MM-DD): ");
                String fechaFinStr = Escaner.pedirString("Introduce la fecha de fin (YYYY-MM-DD): ");
                try {
                    //aqui convierto las cadenas introducidas por el usuario a objetos de tipo LocalDate
                    LocalDate fechaIni = LocalDate.parse(fechaIniStr);
                    LocalDate fechaFin = LocalDate.parse(fechaFinStr);
                    //aqui se cargan laS incidencias desde el fichero
                    ArrayList<Incidencia> listaIncidenciasFecha = ServicioFichero.leerIncidencias();
                    //con este array busco las incidencias que esten dentro del rango de fechas
                    ArrayList<String> resultadoFecha = ServicioFichero.buscarPorFecha(fechaIni, fechaFin, listaIncidenciasFecha);
                    if (resultadoFecha.isEmpty()) {//aqui se muestra error si no se encuentran incidencias
                        Consola.mostrarString("No se encontraron incidencias en ese rango de fechas.");
                    } else {
                        //si hay incidencias se mueartan por consola
                        Consola.mostrarString("Incidencias encontradas:");
                        for (String inc : resultadoFecha) {//aqui se recorreo la lista y se muestran
                            Consola.mostrarString(inc);
                        }
                    }
                } catch (Exception e) {
                    // Si ocurre un error al convertir las fechas, se muestra un mensaje de error
                    Consola.mostrarString("Formato de fecha incorrecto.");
                }
                break;

            case 0:
                Consola.mostrarString("Saliendo...");
                break;

            default:
                Consola.mostrarString("Opción no válida");
        }
    }
    //Aqui solo se crea este metodo para crear la Incidencia los demas metodos se hacen en el servicio
    private static void crearIncidencia(String excepcion, String usuario) {
        //aqui se guarda la hora y la fecha a la que se ha creado la incidencia tambien el tipo de excepcioon y el creador de ella
        java.time.LocalDate fecha = java.time.LocalDate.now();
        java.time.LocalTime hora = java.time.LocalTime.now().withNano(0);
        servicio.ServicioFichero.guardarIncidencia(fecha, hora, excepcion, usuario);
        //si se ha creado correctamente manda este mensaje
        vista.Consola.mostrarString("Incidencia registrada correctamente.");
    }
}